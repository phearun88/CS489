import axios from "axios";
import React, { useEffect, useState } from "react";

import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import {useLocation } from "react-router-dom";
import {baseURL, userId} from "../../utils/Utils/Utils";
const CheckIssueScreen = () => {

    const location = useLocation();
    const checkIssId = location.state.checkIssId;

    const [categories, setCategories] = useState([]);
    const [subtcategories, setSubCategories] = useState([]);
    const [issues, setIssues] = useState([]);
    const [userIssueId, setUserIssueId] = useState("");
    
    const handleCategoryChange = (event) => {
        fetchSubCategory(event.target.value);
    };

    const fetchCategory = async () => {
        try {
            const response = await axios.get(baseURL+'/category');
            setCategories(response.data);
            if (response.data.length > 0) {
                const firstCateId = response.data[0].id
                fetchSubCategory(firstCateId);
            }
        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };

    const fetchSubCategory = async (cateId) => {
        try {
            const responseSubCate = await axios.get(baseURL+`/subcategory/category/${cateId}`);
            setSubCategories(responseSubCate.data);

        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setIssues({ ...issues, [name]: value });
        
    };

    useEffect(() => {
        fetchCategory ();
      

        
        fetchIssues();
        
    }, []);

    const fetchIssues = async () => {
        try {
          
            const response = await axios.get(baseURL+`/issue/${checkIssId}`);

            setIssues(response.data);

            console.log("dd  "+response.data.userId);

            setUserIssueId(response.data.userId);
        } catch (error) {
            console.error('Error fetching issues:', error);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        const formData = new FormData(e.target);
        const formDataObj = Object.fromEntries(formData.entries());

        formDataObj.issAssigneeTo = userId;
        formDataObj.userId = userIssueId;
        formDataObj.issId = checkIssId;
     
        
        const buttonClicked = e.nativeEvent.submitter.name;
        if (buttonClicked === "saveDraft") {
            formDataObj.issDraft = "yes";
        } else if (buttonClicked === "submitIssue") {
            formDataObj.issDraft = "no";
        }

        console.log(formDataObj);
        try {
            const response = await axios.put(baseURL+`/issue/${checkIssId}`, formDataObj);
      
        } catch (error) {
            console.error('Error registering user:', error);
        }
    };


    return (

        <>
            <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Check Issue</h1>


            <div className="max-w-7xl w-full bg-white p-8 rounded shadow-lg text-gray-800">

                <form onSubmit={handleSubmit}>
                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridCategory">
                            <Form.Label>Category</Form.Label>
                            <Form.Select defaultValue="Choose..." onChange={handleCategoryChange} name="cateId"  >
                                {categories.map(cate => (
                                    <option value={cate.id}>{cate.name}</option>
                                ))}
                            </Form.Select>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridSubCategory">
                            <Form.Label>SubCategory</Form.Label>
                            <Form.Select defaultValue="Choose..." name="subCateId"  >
                                {/* <option>Choose...</option> */}
                                {subtcategories.map(subcate => (
                                    <option value={subcate.id}>{subcate.name}</option>
                                ))}
                            </Form.Select>
                        </Form.Group>
                    </Row>

                    <Form.Group className="mb-3" controlId="formGridTitle">
                        <Form.Label>Title</Form.Label>
                        <Form.Control value={issues.issName} name="issName" onChange={handleChange} />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formGridAddress2">
                        <Form.Label>Description</Form.Label>
                        <Form.Control as="textarea" value={issues.issDesc} row={5} name="issDesc"   onChange={handleChange}/>
                    </Form.Group>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>Status</Form.Label>
                            <Form.Select defaultValue="Choose..." name="issStatus" >
                                <option value={0}>New</option>
                                <option value={1}>Accepted</option>
                                <option value={2}>In progress</option>
                                <option value={3}>Done</option>
                                <option value={4}>Closed</option>

                            </Form.Select>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridType">
                            <Form.Label>Priority</Form.Label>
                            <Form.Select defaultValue="Choose..." name="issTp"  >
                                <option value={"Urgent"}>Urgent</option>
                                <option value={"High"}>High</option>
                                <option value={"Medium"}>Medium</option>
                                <option value={"Normal"}>Normal</option>
                            </Form.Select>
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridHandler">
                            <Form.Label>Handler</Form.Label>
                            <Form.Control placeholder="Title" name="issAssigneeTo" value={issues.issAssigneeTo}  />
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>%Progress</Form.Label>
                            <Form.Select defaultValue="Choose..." name="issDone">
                                <option value={"0"}>0 %</option>
                                <option value={"30"}>30 %</option>
                                <option value={"50"}>50 %</option>
                                <option value={"80"}>80 %</option>
                                <option value={"100"}>100 %</option>
                            </Form.Select>
                        </Form.Group>
                    </Row>

                    <Row className="mb-3">
                        <Form.Group as={Col} controlId="formGridHandler">
                            <Form.Label>Start Date</Form.Label>
                            <Form.Control placeholder="Title" value={issues.createdDate} name="createdDate" onChange={handleChange}/>
                        </Form.Group>

                        <Form.Group as={Col} controlId="formGridState">
                            <Form.Label>End Date</Form.Label>
                            <Form.Control placeholder="Title" value={issues.updatedDate} name="updatedDate" onChange={handleChange}/>
                        </Form.Group>
                    </Row>

                    
                        
                        <Button type="submit" variant="primary"  name="submitIssue">
                            Accept Issue
                        </Button>
                   
                </form>
            </div>
        </>



    )
}

export default CheckIssueScreen;