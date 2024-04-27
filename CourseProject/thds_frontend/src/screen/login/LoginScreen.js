import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import {baseURLAuth} from "../../utils/Utils/Utils";

const LoginScreen = ({ onLoginSuccess }) => {
    const navigator = useNavigate();
    const [userinfo, setUserinfo] = useState([]);
    const [formData, setFormData] = useState({
        email: '',
        password: ''
    });
    const handleSubmitCate = async (e) => {
        e.preventDefault();
        try {
           
            const response = await axios.post(baseURLAuth+'/login', formData);
           
            setUserinfo(response.data);

            sessionStorage.setItem("authToken", response.data.token);
            sessionStorage.setItem("userId", response.data.id);
            sessionStorage.setItem("username", response.data.email);
            sessionStorage.setItem("role", response.data.roles[0].title);
       
            onLoginSuccess();

            navigator('/dashboard');
        
        } catch (error) {
            console.error('Error registering user:', error);
            // Handle error
        }
    };

 

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
        
    };

    return (
        <div className="flex justify-center items-center h-screen bg-gray-200">
            <div className="max-w-md w-full bg-white p-8 rounded shadow-lg">
                <div className="mb-4 flex justify-center">
                    <Link to="/" ><h1 className="text-3xl font-bold text-blue-500 underline-offset-0">Ticket Help Desk</h1></Link>
                </div>
                <h1 className="text-2xl font-semibold mb-6">Login</h1>
                <form onSubmit={handleSubmitCate}>
                    <div className="mb-4">
                        <label htmlFor="username" className="block text-gray-700 font-semibold mb-2">Username</label>
                        <input type="text" id="eamil" name="email" className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500"  onChange={handleChange} placeholder="Enter username" />
                    </div>
                    <div className="mb-6">
                        <label htmlFor="password" className="block text-gray-700 font-semibold mb-2">Password</label>
                        <input type="text" id="password" name="password" className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500"  onChange={handleChange} placeholder="Enter password" />
                    </div>
                    <button type="submit" className="w-full bg-blue-500 text-white font-semibold py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:bg-blue-600">Login</button>
                </form>
                <p className="mt-4 text-center">
                    Don't have an account? <Link to="/register" className="text-blue-500 hover:underline">Register</Link>
                </p>
            </div>
        </div>


    )
}

export default LoginScreen;