import React from "react";

const OperationsBoard = () => {
    return (
        <div className='species-index'>
            {/* Fix the background, as the background ends before page */}
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>
            <div className='card w3-container w3-card-4'>
                <h1 className=''>Operations Board</h1>
                <div className='w3-panel w3-text-black'>
                    <table className='w3-table-all w3-hoverable'>
                        <thead>
                            <tr className='w3-black'>
                                <th>Task</th>
                                <th>Description</th>
                                <th>Status</th>
                                <th>Assigned To</th>
                                <th>Due Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            {/* Example tasks, replace with dynamic data */}
                            <tr>
                                <td>Feed Raptors</td>
                                <td>Ensure all raptors are fed with appropriate diet</td>
                                <td>In Progress</td>
                                <td>John Hammond</td>
                                <td>2024-06-15</td>
                            </tr>
                            <tr>
                                <td>Check Fencing</td>
                                <td>Inspect perimeter fencing for any breaches</td>
                                <td>Pending</td>
                                <td>Ellie Sattler</td>
                                <td>2024-06-20</td>
                            </tr>
                            <tr>
                                <td>Update Species Database</td>
                                <td>Review and update the species database with new findings</td>
                                <td>Completed</td>
                                <td>Alan Grant</td>
                                <td>2024-06-10</td>
                            </tr>
                            <tr>
                                <td>Monitor Weather Conditions</td>
                                <td>Keep track of weather conditions for safety protocols</td>
                                <td>In Progress</td>
                                <td>Ian Malcolm</td>
                                <td>2024-06-18</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default OperationsBoard;