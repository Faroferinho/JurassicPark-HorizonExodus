import React from 'react';
import { useState, useEffect } from 'react';
import './App.css';
import { Route, Routes, BrowserRouter as Router, Link } from 'react-router-dom';

import Home from './pages/home.js';
import Login from './pages/login.js';
import Register from './pages/register.js';
import SpeciesIndex from './pages/speciesIndex.js';
import AboutUs from './pages/aboutUs.js';

import OperationsBoard from './pages/operationsBoard.js';
import Actions from './pages/actions.js';
import UserPage from './pages/user-page.js';

function App() {
  return (
    <div className="App">
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>

      <Router>
        {/* Navigation Bar */}
        <nav className='w3-bar w3-black w3-card-4'>
          <Link to="/">
            <div className="logo w3-bar-item">
              <h2 className='title'>
                InGen
              </h2>
              <img src={`${process.env.PUBLIC_URL}/images/jp-logo.ico`} className="App-logo" alt="logo" />
            </div>
          </Link>

          <Link to="Login">
            <div className="spacer w3-button w3-bar-item">
              👤 Login
            </div>
          </Link>

          <Link to="Register">
            <div className="spacer w3-button w3-bar-item">
              👥 Register
            </div>
          </Link>

          <Link to="SpeciesIndex">
            <div className="spacer w3-button w3-bar-item">
              🦖 Species Index
            </div>
          </Link>

          <Link to="AboutUs">
            <div className="spacer w3-button w3-bar-item">
              🧬 About InGen
            </div>
          </Link>

          <div className="spacer w3-bar-item" style={{flexGrow: 3}}></div>

          <Link to="OperationsBoard">
            <div className="spacer w3-button w3-bar-item">
              ⚙️ Operations Board
            </div>
          </Link>
          
          <Link to="Actions">
            <div className="spacer w3-button w3-bar-item">
              🛠️ Actions
            </div>
          </Link>

          <Link to="UserPage">
            <div className="spacer w3-button w3-bar-item">
              👤 User Page
            </div>
          </Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/Login" element={<Login />} />
          <Route path="/Register" element={<Register />} />
          <Route path="/SpeciesIndex" element={<SpeciesIndex />} />
          <Route path="/AboutUs" element={<AboutUs />} />
          <Route path="/OperationsBoard" element={<OperationsBoard />} />
          <Route path="/Actions" element={<Actions />} />
          <Route path="/UserPage" element={<UserPage />} />
          <Route path="*" element={<Home />} />
        </Routes>
      </Router>
      
      {/*
      <header className="App-header">
        
      </header>
      */}

      <footer className="App-footer">
        <p>© 1983 - 2025 InGen. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default App;
