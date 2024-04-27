import axios from "axios";
import React, { useEffect, useState } from "react";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { baseURL } from "../../utils/Utils/Utils";
const ProfiledScreen = () => {

    const username = sessionStorage.getItem('username');
    const [show, setShow] = useState(false);
    const [userprofile, setUserprofile] = useState([]);

    // const handleShow = () => {

    //     setShow(true);

    // }


    const handleClose = () => {
        setShow(false);

    };

    useEffect(() => {
        fetchUserProfile();
    }, []);


    const fetchUserProfile = async () => {
        try {
            const response = await axios.get(baseURL + `/users/${username}`);
            setUserprofile(response.data);
        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };



    const handleEditProfile = async (e) => {
        e.preventDefault();

        const formEditData = new FormData(e.target);
        const formDataObj = Object.fromEntries(formEditData.entries());

        formDataObj.userId = username;

        const response = await axios.put(baseURL + `/users/${username}`, formDataObj);
        // clearForm();
        setShow(false);
        fetchUserProfile();
        try {

        } catch (error) {
            console.error('Error registering user:', error);
        }
    };

    return (
        <div>
            <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Profile</h1>
            <div className="mb-2">

            </div>

            <div className="max-w-7xl w-full">
                <div className="bg-gray-100 p-6 rounded-lg shadow-md">
                    <div className="flex items-center justify-between mb-4">
                        <h2 className="text-xl font-semibold text-black">{userprofile.firstName} {userprofile.lastName}</h2>
                        <span className="bg-blue-500 text-white px-2 py-1 rounded-full text-sm">Active</span>
                    </div>
                    <div className="grid grid-cols-2 gap-x-4">
                        <div className="mb-4">
                            <label htmlFor="username" className="block text-gray-700 font-medium mb-2">Username</label>
                            <p id="username" className="text-gray-900 font-semibold">{userprofile.email}</p>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="name" className="block text-gray-700 font-medium mb-2">Date of Birth</label>
                            <p id="name" className="text-gray-900 font-semibold">{userprofile.dob}</p>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="department" className="block text-gray-700 font-medium mb-2">Department</label>
                            <p id="department" className="text-gray-900 font-semibold">{userprofile.department}</p>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="position" className="block text-gray-700 font-medium mb-2">Position</label>
                            <p id="position" className="text-gray-900 font-semibold">{userprofile.position}</p>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="gender" className="block text-gray-700 font-medium mb-2">Gender</label>
                            <p id="gender" className="text-gray-900 font-semibold">{userprofile.gender}</p>
                        </div>
                        {/* 
            <div className="mb-4">
                <label htmlFor="role" className="block text-gray-700 font-medium mb-2">Role</label>
                <p id="role" className="text-gray-900 font-semibold">{userprofile.roles[0].title}</p>
            </div>
            */}
                    </div>
                    {/* 
        <div className="flex justify-end">
            <button onClick={handleShow} className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 focus:outline-none focus:bg-blue-600">Edit Profile</button>
        </div>
        */}
                </div>
            </div>




            <Modal show={show} onHide={handleClose} size="lg">
                <form onSubmit={handleEditProfile} className="w-full">
                    <Modal.Header closeButton>
                        <Modal.Title>Edit Profile</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <div className="grid grid-cols-2 gap-4">

                            <div className="mb-4">
                                <label htmlFor="firstName" className="block text-gray-700 font-medium mb-2">First Name</label>
                                <input type="text" id="firstName" name="firstName" value={userprofile.firstName} className="w-full border-gray-300 rounded-md shadow-sm focus:border-blue-300 focus:ring focus:ring-blue-200 focus:ring-opacity-50" />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="lastName" className="block text-gray-700 font-medium mb-2">Last Name</label>
                                <input type="text" id="lastName" name="lastName" value={userprofile.lastName} className="w-full border-gray-300 rounded-md shadow-sm focus:border-blue-300 focus:ring focus:ring-blue-200 focus:ring-opacity-50" />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="department" className="block text-gray-700 font-medium mb-2">Department</label>
                                <input type="text" id="department" name="department" value={userprofile.department} className="w-full border-gray-300 rounded-md shadow-sm focus:border-blue-300 focus:ring focus:ring-blue-200 focus:ring-opacity-50" />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="position" className="block text-gray-700 font-medium mb-2">Position</label>
                                <input type="text" id="position" name="position" value={userprofile.position} className="w-full border-gray-300 rounded-md shadow-sm focus:border-blue-300 focus:ring focus:ring-blue-200 focus:ring-opacity-50" />
                            </div>
                            <div className="mb-4">
                                <label htmlFor="gender" className="block text-gray-700 font-medium mb-2">Gender</label>
                                <select id="gender" name="gender" className="w-full border-gray-300 rounded-md shadow-sm focus:border-blue-300 focus:ring focus:ring-blue-200 focus:ring-opacity-50">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="other">Other</option>
                                </select>
                            </div>

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



        </div>
    );
}

export default ProfiledScreen;