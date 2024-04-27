import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { useNavigate } from "react-router-dom";

import { getStatus, baseURL, userId, userRole, getUserHanlder} from "../../utils/Utils/Utils";

const IssuesScreen = () => {
    const navigator = useNavigate();
    const [issues, setIssues] = useState([]);
    const [show, setShow] = useState(false);
    const [categories, setCategories] = useState([]);
    const [subtcategories, setSubCategories] = useState([]);
   
    const handleClose = () => setShow(false);

    const handleShowAddIssue = () => {
        setShow(true);
        fetchCategory();
    };

    const gotoCheckPage = (param) => {

        const checkIssId = param;
        navigator('/issues/check', { state: { checkIssId: checkIssId } })
    }

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

    useEffect(() => {
        fetchIssues();
    }, []); 

    const fetchIssues = async () => {
        
        try {
            console.log("role "+userRole)

            if(userRole == "ROLE_ADMIN"){

                const response = await axios.get(baseURL+'/issue');
                setIssues(response.data);
                console.log(response.data)
                console.log("ROLE_ADMIN "+response.data)
            }else{
                const response = await axios.get(baseURL + `/issue/user/${userId}`);
                setIssues(response.data);
                console.log("ROLE_USER "+response.data)
            }

            

            
            
        } catch (error) {
            console.error('Error fetching issues:', error);
        }
    };


    const handleCategoryChange = (event) => {

        fetchSubCategory(event.target.value);

        // const { name, value } = event.target;
        // setFormData({ ...formData, [name]: value });
    };



    const handleSubmit = async (e) => {
        e.preventDefault();

        const formData = new FormData(e.target);
        const formDataObj = Object.fromEntries(formData.entries());
        formDataObj.userId = userId;

        const buttonClicked = e.nativeEvent.submitter.name;
        if (buttonClicked === "saveDraft") {
            formDataObj.issDraft = "yes";
        } else if (buttonClicked === "submitIssue") {
            formDataObj.issDraft = "no";
        }
        try {
            const response = await axios.post(baseURL+'/issue', formDataObj);
            setShow(false);
            fetchIssues();
        } catch (error) {
            console.error('Error registering user:', error);
        }
    };
    const goToDraft = async () => {
        navigator('/issues/draft')
    }





    return (
        <div>
            <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Issues</h1>
            <div className="mb-2">
                <Button variant="primary" className="mr-2" onClick={handleShowAddIssue}> Add </Button>
                <Button variant="primary" onClick={goToDraft.bind(this, userId)}> Draft </Button>

            </div>
            <Table striped className="max-w-7xl w-full">
                <thead>
                    <tr>
                        <th>Title</th>
                        {/* <th>Subject</th> */}
                        <th>Status</th>
                        <th>Priority</th>
                        <th>Progress</th>
                        <th>Handler</th>
                        <th>Date</th>
                        {userRole === 'ROLE_ADMIN' && <th>Action</th>}
                    </tr>
                </thead>
                <tbody>
                    {issues.map(issue => (
                        <tr>
                            <td>{issue.issName}</td>
                            {/* <td>{issue.subCateId}</td> */}
                            <td>{getStatus(issue.issStatus)}</td>
                            <td >
                                <span className={issue.issTp === 'Urgent' ? 'bg-red-600 text-white rounded-md px-1 py-0' : ' text-black rounded-md px-1 py-0'}>
                                    {issue.issTp}
                                </span>
                            </td>
                            <td>{issue.issDone} %</td>
                            <td>{getUserHanlder(issue.issAssigneeTo)}</td>
                            <td>{issue.createdDate}</td>
                            {userRole === 'ROLE_ADMIN' && <td><Button onClick={gotoCheckPage.bind(this, issue.issId)} variant="primary btn-sm">Check Issue</Button> </td>}


                        </tr>
                    ))}
                </tbody>
            </Table>

            <>
                <Modal show={show} onHide={handleClose} size="lg">
                    <form onSubmit={handleSubmit}>
                        <Modal.Header closeButton>
                            <Modal.Title>Add Issue</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>

                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridCategory">
                                    <Form.Label>Category</Form.Label>
                                    <Form.Select defaultValue="Choose..." onChange={handleCategoryChange} name="cateId">

                                        {categories.map(cate => (
                                            <option value={cate.id}>{cate.name}</option>
                                        ))}

                                    </Form.Select>
                                </Form.Group>

                                <Form.Group as={Col} controlId="formGridSubCategory">
                                    <Form.Label>SubCategory</Form.Label>
                                    <Form.Select defaultValue="Choose..." name="subCateId">
                                        {/* <option>Choose...</option> */}
                                        {subtcategories.map(subcate => (
                                            <option value={subcate.id}>{subcate.name}</option>
                                        ))}
                                    </Form.Select>
                                </Form.Group>
                            </Row>

                            <Form.Group className="mb-3" controlId="formGridTitle">
                                <Form.Label>Title</Form.Label>
                                <Form.Control placeholder="Title" name="issName" />
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formGridAddress2">
                                <Form.Label>Description</Form.Label>
                                <Form.Control as="textarea" row={5} placeholder="" name="issDesc" />
                            </Form.Group>

                            <Row className="mb-3">
                                <Form.Group as={Col} controlId="formGridState">
                                    <Form.Label>Status</Form.Label>
                                    <Form.Select defaultValue="Choose..." name="issStatus">
                                        <option value={0}>New</option>

                                    </Form.Select>
                                </Form.Group>


                                <Form.Group as={Col} controlId="formGridState">
                                    <Form.Label>Priority</Form.Label>
                                    <Form.Select defaultValue="Choose..." name="issTp">
                                        <option value={"Urgent"}>Urgent</option>
                                        <option value={"High"}>High</option>
                                        <option value={"Medium"}>Medium</option>
                                        <option value={"Normal"}>Normal</option>
                                    </Form.Select>
                                </Form.Group>
                            </Row>


                        </Modal.Body>
                        <Modal.Footer>
                            <Button type="submit" variant="secondary" name="saveDraft">
                                Save Draft
                            </Button>
                            <Button type="submit" variant="primary" name="submitIssue">
                                Submit
                            </Button>
                        </Modal.Footer>
                    </form>
                </Modal>
            </>


        </div>

    );
}

export default IssuesScreen;