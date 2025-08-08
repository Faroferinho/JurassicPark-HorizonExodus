import React from "react";

const SpeciesIndex = () => {
    return (
        <div className='species-index'>
            {/* Fix the background, as the background ends before page */}
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css"/>
            <div className='card w3-container w3-card-4'>
                <h1 className='w3-center'>Species Index</h1>
                <p className='w3-large w3-center'>Explore the diverse species of Jurassic Park!</p>
                <div className='species-list w3-padding-16'>
                    <ul className='w3-ul'>
                        <li className='w3-padding-16'>
                            <h2 className='index-title'>Tyrannosaurus Rex</h2>
                            <p className='index-description w3-small'>The king of the dinosaurs, known for its massive size and ferocious nature.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/tyrannosaurus-rex.jpg`} alt="Tyrannosaurus Rex" className='index-image w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Velociraptor</h2>
                            <p className='w3-small'>A small but deadly predator, known for its intelligence and pack hunting behavior.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/velociraptor.jpg`} alt="Velociraptor" className='w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Triceratops</h2>
                            <p className='w3-small'>A herbivorous dinosaur with three distinctive horns on its face.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/triceratops.jpg`} alt="Triceratops" className='w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Brachiosaurus</h2>
                            <p className='w3-small'>One of the largest dinosaurs, known for its long neck and towering height.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/brachiosaurus.jpg`} alt="Brachiosaurus" className='w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Stegosaurus</h2>
                            <p className='w3-small'>A herbivore known for its distinctive back plates and spiked tail.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/stegosaurus.jpg`} alt="Stegosaurus" className='w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Spinosaurus</h2>
                            <p className='w3-small'>A large carnivorous dinosaur known for its sail-like structure on its back.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/spinosaurus.jpg`} alt="Spinosaurus" className='w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Ankylosaurus</h2>
                            <p className='w3-small'>A heavily armored dinosaur with a club-like tail, known for its defensive capabilities.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/ankylosaurus.jpg`} alt="Ankylosaurus" className='w3-round' />
                        </li>
                        <li className='w3-padding-16'>
                            <h2 className=''>Pteranodon</h2>
                            <p className='w3-small'>A large flying reptile known for its impressive wingspan and beak.</p>
                            <img src={`${process.env.PUBLIC_URL}/images/pteranodon.jpg`} alt="Pteranodon" className='w3-round' />
                        </li>
                    </ul>
                    <p className='w3-center'>More species will be added soon!</p>
                </div>
            </div>
        </div>
    );
}

export default SpeciesIndex;