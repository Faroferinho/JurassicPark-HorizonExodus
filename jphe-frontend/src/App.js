import React from 'react';
import { useState, useEffect } from 'react';
import './App.css';
import { Route, Routes, BrowserRouter as Router, Link } from 'react-router-dom';

import Home from './pages/home.js';
import Login from './pages/login.js';
import Register from './pages/register.js';
import AboutUs from './pages/aboutUs.js';

function App() {
  return (
    <div className="App">
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>

      <Router>
        {/* Navigation Bar */}
        <nav className='w3-bar w3-black'>
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
              Login
            </div>
          </Link>

          <Link to="Register">
            <div className="spacer w3-button w3-bar-item">
              Register
            </div>
          </Link>

          <Link to="AboutUs">
            <div className="spacer w3-button w3-bar-item">
              About InGen
            </div>
          </Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/Login" element={<Login />} />
          <Route path="/Register" element={<Register />} />
          <Route path="/AboutUs" element={<AboutUs />} />
          <Route path="*" element={<Home />} />
        </Routes>
      </Router>
      
      {/*
      <header className="App-header">
        
      </header>
      */}
      
      <footer className="App-footer">
        <p>© 1987 - 2025 InGen. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default App;
