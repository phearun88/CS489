import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router } from 'react-router-dom';
import { Route, Routes } from 'react-router-dom';
import NavBar from './screen/navbar/NavBar';
import MainContainer from './container/MainContainer'
import { useState } from 'react';
import LoginScreen from './screen/login/LoginScreen';
import RegisterScreen from './screen/register/RegisterScreen';
import HomeScreen from './screen/home/HomeScreen';

const App = () => {
  const [isLogin, setIsLogin] = useState(true);

  const handleLoginSuccess = () => {
    setIsLogin(true);
  };

  const handleLogoutSuccess = () => {
    setIsLogin(false);
  };

  return (
    <>
      <Router>
        {isLogin ? (
          <div className='h-screen p-2 bg-black text-white flex-col overflow-hidden justify-between'>
            <div className="max-w-full h-full flex gap-2 overflow-hidden mb-[5rem]">
              <NavBar onLogoutSuccess={handleLogoutSuccess}/>
              <div className="max-w-full h-full w-10/12 bg-amber-100 ">
                <MainContainer />
              </div>
            </div>
          </div >
        ) : 
        <Routes>
          <Route path='/' element={<HomeScreen />} />
          <Route path='/login' element={<LoginScreen onLoginSuccess={handleLoginSuccess}/>} />
          <Route path='/register' element={<RegisterScreen />} />
        </Routes>}
      </Router>

    </>
  )
}

export default App;

