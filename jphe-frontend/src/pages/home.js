import React from 'react';

function home() {
  return (
    <div className='home'>
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>

      <div className='card w3-container w3-card-4'>
        <p className='w3-xxlarge w3-center w3-padding-16'>
          Home
        </p>
        
        <p className='w3-large w3-center'>Welcome to the Jurassic Park Horizon Exodus project!</p>

        <div className='content w3-center w3-padding-16'>
          <div className='display-container'>
            <img 
              src={`${process.env.PUBLIC_URL}/images/Portrait_Hammond.png`}
              className="portrait"
              alt="John Hammond portrait, a balding white man, with white hair, rounded glasses and a beije suit, he sits cross
              legged, in his hand a long stripped wooden cane, the handle is a round clear ambar with a lone mosquito inside" 
            />
            <p>John Hammond, around 1987</p>
          </div>
          
          <p className='paragraph w3-padding-8 w3-margin-top'>
            This is a fan made project not affiliated with Universal Pictures or Amblin Entertainment.
            About 32 years ago now, a visionary man who had a unprecedented talent to touch the public's imagination, 
            changed the way we see dinosaurs forever. John Hammond, the founder of Internation Genectics Incorporates 
            also know InGen, created a theme park like no other, a theme park where the main attraction were real dinosaurs 
            cloned from ancient DNA. The park was called Jurassic Park, and it was located on a remote island 120 miles off
            the west coast of Costa Rica, the small island called Isla Nublar then became the birth place of the infamous
            Jurassic Park.
          </p>
          
          <p className='paragraph w3-padding-8'>
            The park was a success, but it was short lived, the park was closed after a series of unfortunate events that
            led to the death of several people and the destruction of the park. But the legacy of Jurassic Park lives on,
            and now, in 2023, we are proud to present Jurassic Park Horizon Exodus, a fan made project that aims to bring
            back the magic of Jurassic Park.
          </p>
        </div>
      </div>
      
    </div>
  );
}

export default home;