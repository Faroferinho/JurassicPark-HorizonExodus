import React from 'react';
import { Link } from 'react-router-dom';

const register = () => {
  return (
    <div>
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>
            <div className='card-slim'>
                <h1 className='w3-center'>Register User</h1>
                
                <p className='w3-center'>Please fill in the details to create an account</p>

                <form className='w3-container w3-card-3 w3-padding-16'>
                  <div className='w3-section w3-padding-16'>
                      <label htmlFor='password'>Username</label>
                      <input className='w3-input w3-round-large' type='password' id='password' name='password' required />
                  </div>
                  
                  <div className='w3-section w3-padding-16'>
                      <label htmlFor='birthdate'>Birthdate</label>
                      <input className='w3-input w3-round-large' type='date' id='birthdate' name='birthdate' required />
                  </div>

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
                
                <p className='signup'>Já tem uma conta? <Link to={"/login"}> Inscreva-se</Link> </p>
            </div>
    </div>
  );
}
export default register;