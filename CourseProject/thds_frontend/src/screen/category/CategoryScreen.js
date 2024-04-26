import axios from "axios";
import React, { useEffect, useState } from "react";
// import { Link } from "react-router-dom";

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Table from 'react-bootstrap/Table';
import InputGroup from 'react-bootstrap/InputGroup';
import {baseURL} from "../../utils/Utils/Utils";

const CategoryScreen = () => {

    const [categories, setCategories] = useState([]);
    const [subtcategories, setSubCategories] = useState([]);
    const [cateId, setCateId] = useState([]);
    const [categoryById, setCategoriesById] = useState([]);

    const [show, setShow] = useState(false);
    const [show1, setShow1] = useState(false);
    const [showEdit, setShowEdit] = useState(false);

    const [showDataForm, setShowDataForm] = useState(false);
    const [showDataMessage, setShowDataMessage] = useState(false);


    const handleClose = () => {
        setShow(false);
        setShow1(false);
        setShowEdit(false);
    };


    const handleShow = () => setShow(true);
    const handleShow1 = () => setShow1(true);
    const handleShowEdit = () => setShowEdit(true);

    const userId = sessionStorage.getItem('userId');

    useEffect(() => {


        fetchCategory();
    }, []); // Empty dependency array to run the effect only once after the component mounts

    const fetchCategory = async () => {
        try {
            const response = await axios.get(baseURL+'/category'); // Replace '/api/issues' with your backend endpoint
            setCategories(response.data);
        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };

    const [formData, setFormData] = useState({
        name: '',
    });
    const [formEditData, setFormEditData] = useState({
        active: '',
        name: '',
        userId: ''
    });

    const [formSubCateData, setFormSubCateData] = useState({
        name: '',
    });

    const clearForm = () => {
        setFormSubCateData({ name: '' });
        setFormData({ name: '' });
        setFormEditData({ name: '' });
    }

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
        setFormSubCateData({ ...formSubCateData, [name]: value })
        setFormEditData({ ...formEditData, [name]: value })
    };

    const handleSubmitCate = async (e) => {
        e.preventDefault();
        try {


            formData.active = true;
            formData.userId = userId;
            const response = await axios.post(baseURL+'/category', formData);
            const responseCate = await axios.get(baseURL+'/category'); // Replace '/api/issues' with your backend endpoint
            setCategories(responseCate.data);

            setShow(false);
            clearForm();

        } catch (error) {
            console.error('Error registering user:', error);
            // Handle error
        }
    };



    const handleSubmitSubCate = async (e) => {
        e.preventDefault();

        try {
            formSubCateData.cateId = cateId;
            formSubCateData.active = true;
            const response = await axios.post(baseURL+'/subcategory', formSubCateData);

            getDataSubCategoryByCateId(cateId)
            clearForm();
            setShow(false);
        } catch (error) {
            console.error('Error registering user:', error);
        }
    };

    const getDataSubCategoryByCateId = async (cateId) => {
        try {
            const response1 = await axios.get(baseURL+`/subcategory/category/${cateId}`);
            setSubCategories(response1.data);
        } catch {
            console.error('Error registering user:');
        }

    }



    const handleClick = async (cateId) => {
        try {
            const response = await axios.get(baseURL+`/subcategory/category/${cateId}`);
            setSubCategories(response.data);
            setCateId(cateId);
            setShow1(true);
        } catch (error) {
            console.error('Error fetching category data:', error);
        }
    };

    const handleSubmitEdit = async (e) => {
        e.preventDefault();

        const formEditData = new FormData(e.target);
        const formDataObj = Object.fromEntries(formEditData.entries());
        formDataObj.userId = userId;
        const response = await axios.put(baseURL+`/category/${cateId}`, formDataObj);
        clearForm();
        setShowEdit(false);
        fetchCategory();
        try {

        } catch (error) {
            console.error('Error registering user:', error);
        }
    };

    const handleClickDeleteSubCate = async (subCateId, cateId) => {

        try {

            const response = await axios.delete(baseURL+`/subcategory/${subCateId}`);
            setCategoriesById(response.data);

            getDataSubCategoryByCateId(cateId)
        } catch (error) {
            console.error('Error fetching category data:', error);
        }

    }

    const handleClickEdit = async (cateId, buttonClicked) => {
        try {

            const response = await axios.get(baseURL+`/category/${cateId}`);
            setCategoriesById(response.data);


            const categoryData = response.data;
            setFormEditData({
                name: categoryData.name,
                active: categoryData.active,
            });


            if (buttonClicked === "edit") {
                setShowDataForm(true);
                setShowDataMessage(false);

            } else if (buttonClicked === "disable") {
                setFormEditData({ active: false })
                setShowDataMessage(true);
                setShowDataForm(false);

            }

            setCateId(cateId)
            setShowEdit(true);
        } catch (error) {
            console.error('Error fetching category data:', error);
        }

    };


    return (
        <div>
            <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Category</h1>

            <div className="mb-2">
                <Button variant="primary" onClick={handleShow}> Add </Button>
            </div>

            <Table striped className="max-w-7xl w-full">
                <thead>
                    <tr>
                        <th>Title</th>

                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {categories.map(cate => (
                        <tr key={cate.id}>
                            <td>{cate.name}</td>
                            {/* <td onClick={() => handleClick(cate.id)}>subcate</td> */}
                            <td>
                                <Button onClick={() => handleClick(cate.id)} variant="primary btn-sm mr-2">View</Button>
                                <Button onClick={() => handleClickEdit(cate.id, "edit")} variant="primary btn-sm mr-2">Edit</Button>
                                {/* <Button onClick={() => handleClickEdit(cate.id, "disable")} variant="primary btn-sm mr-2">Delete</Button> */}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

            <>

                <Modal show={showEdit} onHide={handleClose}>
                    <form onSubmit={handleSubmitEdit}>
                        <Modal.Header closeButton>
                            <Modal.Title>Update Category</Modal.Title>
                        </Modal.Header>

                        <Modal.Body>

                            {showDataForm && (
                                <div className="form-group">
                                    <input type="text" className="form-control" name="name" value={formEditData.name} onChange={handleChange} placeholder="Enter username" />
                                    {/* <input type="hidden" className="form-control" name="active" value={formEditData.active} /> */}
                                    <label>
                                        <input
                                            type="radio"
                                            name="active"
                                            value="true"
                                            checked={formEditData.active === "true"}
                                            onChange={handleChange}
                                        />
                                        Active
                                    </label>
                                    <label>
                                        <input
                                            type="radio"
                                            name="active"
                                            value="false"
                                            checked={formEditData.active === "false"}
                                            onChange={handleChange}
                                        />
                                        Inactive
                                    </label>
                                </div>
                            )}

                            {showDataMessage && (
                                <div className="form-group">
                                    <input type="text" className="form-control" name="active" value="false" />
                                    <input type="text" className="form-control" name="name" value={formEditData.name} />
                                    Do you want to disable this category?
                                </div>
                            )}

                        </Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>
                                Close
                            </Button>
                            <Button type="submit" variant="primary">
                                Save
                            </Button>
                        </Modal.Footer>
                    </form>
                </Modal>

                <Modal show={show} onHide={handleClose}>
                    <form onSubmit={handleSubmitCate}>
                        <Modal.Header closeButton>
                            <Modal.Title>Modal heading</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <div className="form-group">
                                <input type="text" className="form-control" name="name" value={formData.name} onChange={handleChange} placeholder="Enter username" />
                            </div>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>
                                Close
                            </Button>
                            <Button type="submit" variant="primary">
                                Save
                            </Button>
                        </Modal.Footer>
                    </form>
                </Modal>

                <Modal show={show1} onHide={handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>
                            Sub Category
                        </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form onSubmit={handleSubmitSubCate}>
                            <InputGroup className="mb-3">
                                <div className="form-group">

                                    <input type="text" className="form-control" name="name" value={formSubCateData.name} onChange={handleChange} placeholder="Enter username" />
                                </div>
                                <Button type="submit" variant="outline-secondary" id="btnSaveSubCate">
                                    Save
                                </Button>
                            </InputGroup>
                        </form>
                        <Table striped>
                            <thead>
                                <tr>
                                    <th>Title</th>

                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {subtcategories.map(subcate => (
                                    <tr>
                                        <td>{subcate.name}</td>

                                        <td>
                                            <Button onClick={() => handleClickEdit(subcate.id)} variant="primary btn-sm mr-2">Edit</Button>
                                            <Button onClick={() => handleClickDeleteSubCate(subcate.id, subcate.cateId)} variant="primary btn-sm mr-2">Delete</Button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose}>
                            Close
                        </Button>
                    </Modal.Footer>
                </Modal>
            </>
        </div>

    );
}

export default CategoryScreen;