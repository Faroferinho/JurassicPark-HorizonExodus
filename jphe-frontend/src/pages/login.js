import React from 'react';
import { Link } from 'react-router-dom';
//https://www.sourcecodester.com/tutorial/htmlcss/16250/creating-floating-input-placeholderlabel-using-html-and-css-tutorial

const Login = () => {
    return (
        <div className='login-page'>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>
            <div className='card-slim'>
                <h1 className='w3-center'>Welcome to InGen</h1>
                <p className='w3-center'>Please log in to continue</p>
                
                {/* Implement Floating Input/Placeholder */}

                <form className='w3-container w3-card-3 w3-padding-16'>
                    <div className='w3-section w3-padding-16'>
                        <label htmlFor='username'>Email</label>
                        <input className='w3-input w3-round-large' type='text' id='email' name='email' required />
                    </div>
                    <div className='w3-section w3-padding-16'>
                        <label htmlFor='password'>Password</label>
                        <input className='w3-input w3-round-large' type='password' id='password' name='password' required />
                    </div>
                    <button className='confirm-button w3-hover-red w3-padding-16' type='submit'>Entrar</button>
                </form>
                <p className='signup'>Still don't have a account? <Link to={"/register"}> Sign-In Freely</Link> </p>
            </div>
        </div>
    );
}
export default Login;