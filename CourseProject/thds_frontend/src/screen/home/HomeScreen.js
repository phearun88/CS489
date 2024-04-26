import React from "react";
import { Link } from "react-router-dom";

import backgroundImage from '../../utils/images/bg.jpg';

const HomeScreen = () => {
    return (
        <>
            <div className="flex flex-col h-screen bg-gray-300">
                <header className="bg-gray-900 text-white p-4">
                    <div className="container mx-auto flex justify-between items-center">
                        <h1 className="text-2xl font-bold">Ticket Help Desk</h1>
                        <Link to="/login" className="text-gray-200 hover:text-gray-300">Login</Link>
                    </div>
                </header>

                <div className="flex-grow container mx-auto bg-cover bg-center" style={{ backgroundImage: `url(${backgroundImage})` }}>
                    {/* Your routes here */}
                    {/* For demonstration purposes, I'm assuming your routes are wrapped in a div */}
                    <div className="ml-5">

                    </div>
                </div>

                <footer className="bg-gray-900 text-white p-4">
                    <div className="container mx-auto">
                        <p className="text-center">Developed by Phearun Phin | Contact: phin.phearun9@email.com</p>
                    </div>
                </footer>
            </div>
        </>
    );
}

export default HomeScreen;