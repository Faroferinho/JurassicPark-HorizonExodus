import React from 'react';
import { Link } from 'react-router-dom';

const Login = () => {
    return (
        <div className='login-page'>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>
            <div className='card-slim'>
                <h1 className='w3-center'>Efetue Login</h1>
                <form className='w3-container w3-card-3 w3-padding-16'>
                    <div className='w3-section w3-padding-16'>
                        <label htmlFor='username'>Usuário</label>
                        <input className='w3-input w3-round-large' type='text' id='username' name='username' required />
                    </div>
                    <div className='w3-section w3-padding-16'>
                        <label htmlFor='password'>Senha</label>
                        <input className='w3-input w3-round-large' type='password' id='password' name='password' required />
                    </div>
                    <button className='confirm-button w3-hover-red w3-padding-16' type='submit'>Entrar</button>
                </form>
                <p className='signup'>Ainda não tem uma conta? <Link to={"/register"}> Inscreva-se</Link> </p>
            </div>
        </div>
    );
}
export default Login;