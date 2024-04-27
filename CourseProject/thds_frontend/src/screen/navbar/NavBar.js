import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { FaAddressCard, FaHSquare, FaHome, FaPeopleArrows, FaUser } from "react-icons/fa";
import { AiFillIdcard, AiOutlineLogout } from 'react-icons/ai';


const NavBar = ({ onLogoutSuccess }) => {
    const navigator = useNavigate();

    const userRole = sessionStorage.getItem('role');

    const logout = (e) => {

        sessionStorage.clear();
        navigator('/')
        onLogoutSuccess();
    }

    return (
        <div className='h-full bg-slate-800 w-[18rem] max-w-[20rem] p-2 rounded-lg '>

            <div className="flex-1 flex flex-col overflow-y-auto">
                <Link to="/profile" className="p-2 text-white hover:bg-gray-700 flex items-center"><FaUser /> <span className='ml-2'>My Profile</span></Link>
                {userRole === 'ROLE_ADMIN' && <Link to="/dashboard" className="p-2 text-white hover:bg-gray-700 flex items-center"><FaAddressCard /> <span className='ml-2'>Dashboard</span></Link>}
                {userRole === 'ROLE_ADMIN' && <Link to="/users" className="p-2 text-white hover:bg-gray-700 flex items-center"><FaPeopleArrows /> <span className='ml-2'>Users</span></Link>}
                {userRole === 'ROLE_ADMIN' &&     <Link to="/category" className="p-2 text-white hover:bg-gray-700 flex items-center"><FaHome /> <span className='ml-2'>Category</span></Link>}
                <Link to="/issues" className="p-2 text-white hover:bg-gray-700 flex items-center"><AiFillIdcard /> <span className='ml-2'>Issues</span></Link>
                <span className="p-2 text-white hover:bg-gray-700 flex items-center cursor-pointer" onClick={logout}><AiOutlineLogout /> <span className='ml-2'>Log out</span></span>
                {/* {prop.children} */}

            </div>

        </div>
    );
};

export default NavBar;
