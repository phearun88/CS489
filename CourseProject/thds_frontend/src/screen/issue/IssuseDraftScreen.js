import axios from "axios";

import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { baseURL } from "../../utils/Utils/Utils";
import { useNavigate } from "react-router-dom";


const IssuseDraftScreen = () => {
    const [issueByUserId, setIssueByUserId] = useState([]);
    const userId = sessionStorage.getItem('userId');

    const [categories, setCategories] = useState([]);
    const [subtcategories, setSubCategories] = useState([]);
    const [show, setShow] = useState(false);
    const [issueUpdate, setIssueUpdate] = useState([]);
    const [formEditData, setFormEditData] = useState([]);
    const [issueId, setIssId] = useState([]);
    const navigator = useNavigate();

    const handleClose = () => setShow(false);

    const fetchCategory = async () => {
        try {
            const response = await axios.get(baseURL + '/category');
            setCategories(response.data);
            if (response.data.length > 0) {
                const firstCateId = response.data[0].id

                fetchSubCategory(firstCateId);
            }
        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };

    const handleShowAddIssue = async (issId) => {
        try {

            setShow(true);
            fetchCategory();
            setIssId(issId);

            const response = await axios.get(baseURL + `/issue/${issId}`);
            const issueDraftRes = response.data;

            setIssueUpdate(issueDraftRes);

            setFormEditData({
                issName: issueDraftRes.issName,
                issDesc: issueDraftRes.issDesc,
            });

        } catch (error) {
            console.error('Error fetching Category:', error);
        }


    };

    const fetchSubCategory = async (cateId) => {
        try {
            const responseSubCate = await axios.get(baseURL + `/subcategory/category/${cateId}`);
            setSubCategories(responseSubCate.data);

        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };

    const handleCategoryChange = (event) => {
        fetchSubCategory(event.target.value);
    };

    useEffect(() => {
        fetchIssuesDraft();
    }, []);


    const fetchIssuesDraft = async () => {

        try {
            const responseIssueByUserId = await axios.get(baseURL + `/issue/user/draft/${userId}`);
            setIssueByUserId(responseIssueByUserId.data);

        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    }

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormEditData({ ...formEditData, [name]: value });

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

            const response = await axios.put(baseURL + `/issue/${issueId}`, formDataObj);

            setShow(false);
            fetchIssuesDraft();

        } catch (error) {
            console.error('Error registering user:', error);
        }
    };

    const goToIssue = async () => {
        navigator('/issues')
    }

    return (
        <div>
            <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Issues Draft</h1>
            <div className="mb-2">
                <Button variant="primary" onClick={goToIssue.bind()}> BackToIssues </Button>
            </div>
            <Table striped className="max-w-7xl w-full">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Subject</th>
                        {/* <th>Status</th> */}
                        <th>Priority</th>
                        {/* <th>%Process</th> */}
                        <th>Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {issueByUserId.map(draft => (
                        <tr>
                            <td>{draft.issName}</td>
                            <td>{draft.subCateId}</td>
                            {/* <td>{draft.issStatus}</td> */}
                            <td>{draft.issTp}</td>

                            <td>{draft.createdDate}</td>
                            <td>
                                <Button variant="primary btn-sm" className="mr-2" onClick={() => handleShowAddIssue(draft.issId)} >Edit</Button>
                                {/* <Button  onClick={() => clickDelete(draft.iss_id)} variant="primary btn-sm">Delete</Button>  */}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>


            <>
                <Modal show={show} onHide={handleClose} size="lg">
                    <form onSubmit={handleSubmit}>
                        <Modal.Header closeButton>
                            <Modal.Title>Edit Issue</Modal.Title>
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
                                <Form.Control placeholder="Title" name="issName" value={formEditData.issName} onChange={handleChange} />
                            </Form.Group>

                            <Form.Group className="mb-3" controlId="formGridAddress2">
                                <Form.Label>Description</Form.Label>
                                <Form.Control as="textarea" row={5} placeholder="" name="issDesc" value={formEditData.issDesc} onChange={handleChange} />
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

export default IssuseDraftScreen;