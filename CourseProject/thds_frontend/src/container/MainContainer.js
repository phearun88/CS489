import React from "react";
import {Route, Routes } from 'react-router-dom';
import PageNotFound from '../screen/notfound/PageNotFound';
import IssuesScreen from '../screen/issue/IssuesScreen';
import CategoryScreen from '../screen/category/CategoryScreen';
import CheckIssueScreen from '../screen/issue/CheckIssueScreen';
import IssuseDraftScreen from "../screen/issue/IssuseDraftScreen";
import UsersScreen from "../screen/user/UsersScreen";
import ProfiledScreen from "../screen/profile/ProfileScreen";

import DashboardScreen from "../screen/dashboard/DashboardScreen";
import HomeScreen from "../screen/home/HomeScreen";

const MainContainer = () => {
    return (
        <div className="ml-5">
            <Routes>
                {/* <Route path='' element={<HomeScreen />} /> */}
                <Route path='/profile' element={<ProfiledScreen />} />
                <Route path='/issues' element={<IssuesScreen />} />
                <Route path='/issues/check' element={<CheckIssueScreen />} />
                <Route path='/issues/draft' element={<IssuseDraftScreen />} />
                <Route path='/category' element={<CategoryScreen />} />
                <Route path='/users' element={<UsersScreen />} />
                <Route path='/dashboard' element={<DashboardScreen />} />
               
                <Route path='*' element={<PageNotFound />} />
            </Routes>
        </div>
    )
}

export default MainContainer;