import react from "react";

const UserPage = () => {
    return (
        <div className='user-page'>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>
            <div className='card w3-container w3-card-4'>
                <h1 className=''>User Page</h1>
                <div className='w3-panel w3-leftbar w3-text-black'>
                    <p>Name: John Doe</p>
                    <p>Email: jdoe@domain.com</p>
                    <p>Role: Operations Manager</p>
                    <p>Last Login: 2024-06-01</p>
                    <p>Status: Active</p>
                </div>
            </div>
        </div>
    );
}

export default UserPage;