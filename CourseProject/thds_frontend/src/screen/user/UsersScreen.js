
import axios from "axios";

import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';

import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';

import {baseURL} from "../../utils/Utils/Utils";

const UsersScreen = () => {

    const [users, setUsers] = useState([]);

    useEffect(() => {
        fetchUsers();
    }, []);


    const fetchUsers = async () => {
        try {
            const response = await axios.get(baseURL+'/users'); // Replace '/api/issues' with your backend endpoint
            setUsers(response.data);
            
        } catch (error) {
            console.error('Error fetching Category:', error);
        }
    };


    return (
        <div>
            <h1 className="text-3xl font-bold text-gray-800 mb-2 mt-4  mr-10  border-gray-900 border-b-4" b>Users</h1>
            <div className="mb-2">

            </div>
            <Table striped className="max-w-7xl w-full">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Position</th>
                        <th>Gender</th>
                        <th>Role</th>
                        {/* <th>Action</th> */}


                    </tr>
                </thead>
                <tbody>
                    {users.map(user => (
                        <tr>
                            <td>{user.email}</td>
                            <td>{user.firstName} {user.lastName} </td>
                            <td>{user.department}  </td>
                            <td>{user.position}  </td>
                            <td>{user.gender}  </td>
                            <td>
                                {user.roles.map(role => (
                                    <span>{role.title}</span> // Assuming each role has a unique identifier
                                ))}
                            </td>
                            {/* <td>

                                <Button onClick={() => handleClickEdit(cate.id, "edit")} variant="primary btn-sm mr-2">Edit</Button> 
                                <Button variant="primary btn-sm mr-2">Edit</Button>
                            </td> */}
                        </tr>
                    ))}
                </tbody>
            </Table>




        </div>



    );
}

export default UsersScreen;