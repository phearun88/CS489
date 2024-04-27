import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { baseURL } from "../../utils/Utils/Utils";
const RegisterScreen = () => {

    const navigator = useNavigate();

    const [formData, setFormData] = useState({
        email: '',
        password: '',
        confirmPassword: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

   
    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(formData);
        try {
            const response = await axios.post(baseURL + '/users/register', formData);
            navigator('/login')
        } catch (error) {
            console.error('Error registering user:', error);
            navigator('/login')
            // Handle error
        }
    };


    return (

        <div className="flex justify-center items-center h-screen bg-gray-200">
            <div className="max-w-md w-full bg-white p-8 rounded shadow-lg">
                <div className="mb-4 flex justify-center">
                    <Link to="/" ><h1 className="text-3xl font-bold text-blue-500 underline-offset-0">Ticket Help Desk</h1></Link>
                </div>
                <h1 className="text-2xl font-semibold mb-6">Register</h1>
                <form onSubmit={handleSubmit}>
              

                    <div className="grid grid-cols-2 gap-4">

                        <div className="mb-0">
                            
                            <input type="text" id="firstName" name="firstName" placeholder="First Name" value={formData.firstName} onChange={handleChange}  className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" />
                        </div>
                        <div className="mb-0">
                          
                            <input type="text" id="lastName" name="lastName" placeholder="Last Name" value={formData.lastName} onChange={handleChange}  className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" />
                        </div>


                        <div className="mb-0">
                            
                          <input type="text" id="username" name="email" value={formData.email} onChange={handleChange} className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" placeholder="Enter username" />
                        </div>

                        <div className="mb-0">
                            
                            <select id="gender" name="gender" value={formData.gender} onChange={handleChange} className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500">
                                <option value="">==Gender==</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                
                            </select>
                        </div>

                        <div className="mb-0">
                            
                            <input type="password" id="password" name="password" value={formData.password} onChange={handleChange} className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" placeholder="Enter password" />
                        </div>

                        <div className="mb-0">
                            
                            <input type="password" id="confirmPassword" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" placeholder="Confirm password" />
                        </div>


                        <div className="mb-">
                            
                            <input type="text" id="department" name="department"  placeholder="Department" value={formData.department} onChange={handleChange} className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" />
                        </div>
                        <div className="mb-2">
                            
                            <input type="text" id="position" name="position" placeholder="Position" value={formData.position} onChange={handleChange} className="w-full px-3 py-2 border rounded-md focus:outline-none focus:border-blue-500" />
                        </div>
                        

                    </div>
                    <button type="submit" className="w-full bg-blue-500 text-white font-semibold py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:bg-blue-600">Register</button>
                </form>
                <p className="mt-4 text-center">
                    Already have an account? <Link to="/login" className="text-blue-500 hover:underline">Login</Link>
                </p>
            </div>
        </div>



        // <div className="container login-container">
        //     <h1>Register</h1>
        //     <div className="row justify-content-center">
        //         <div className="col-md-6">
        //             <div className="card">
        //                 <div className="card-header"> Register </div>
        //                 <div className="card-body">
        //                     <form onSubmit={handleSubmit}>
        //                         <div className="form-group">
        //                             <input type="text" className="form-control" name="username" value={formData.username} onChange={handleChange} placeholder="Enter username" />
        //                         </div>
        //                         <div className="form-group">
        //                             <input type="password" className="form-control" name="password" value={formData.password} onChange={handleChange} placeholder="Enter password" />
        //                         </div>
        //                         <div className="form-group">
        //                             <input type="password" className="form-control" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} placeholder="Confirm password"/>
        //                         </div>
        //                         <button type="submit" className="btn btn-primary btn-block">Register</button>
        //                     </form>
        //                     <p>Already have an account? <Link to="/login">Login</Link></p>
        //                 </div>
        //             </div>
        //         </div>
        //     </div>
        // </div>



    )
}

export default RegisterScreen;