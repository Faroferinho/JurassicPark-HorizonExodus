# Jurassic Park - Horizon Exodus

# Overview

Basically a site with three areas. In the dinosaur management page a display show a map with the creature where to appear as silhouettes icons and a list of species, quantity expected, quantity found and species version. The contact us display is where a form send a email message to the InGen team, which at first will be automatically answered by the system and later by an administrador. A about us section with the lore of InGen, John Hammond and both Site A (Isla Nublar), Site B (Isla Sorna) and the rest of La Cinco Muertes. A Species Index with common name, scientific name, average height, weight and Length, description, diet, time period and animal version. A Worker page also would be needed, with a administrator, ranger, geneticist and construction worker.

# Requirements

This project would need a few smart choices to be have a smooth flow of one operation to another.

## Quality Requirements

| **ID** | **Requirement** |
| --- | --- |
| RNF - 1 | The Application must have a micro-service oriented architecture back-end architecture, with a Authentication, Species Management and Email Management System. The front-end must be both a flutter and react application. |
| RNF - 2 | The Back-End must be allocated in Three different Containers. |
| RNF - 3 | The interface must use the classic JP color scheme (black, red, yellow, orange and beige). |
| RNF - 4 | the interface must obey the Web Content Accessibility Guidelines, for a more universal experience. |
| RNF - 5 | The Documentation must be updated after every update. |
| RNF - 6 | The interface must be intuitive. |
| RNF - 7 | The average user must be capable of returning feedback with in at most three clicks. |
| RNF - 8 | The Site must comply with the legal norms of Autarchy. |

## Functional Requirements

| **ID** | **Name** | **Description** | **Priority** |
| --- | --- | --- | --- |
| RF - 1 | Login | The user must be capable of entering the website to do any operation, with the correct type of user. | High |
| RF - 2 | Registration | A Registration must be done with the following types of users, unregistered, customer, guests, administrator, ranger geneticist, construction and paleontologists. | High |
| RF - 3 | Animal Display | A display must be shown, where you select the padlock / region, and the animals will appear as silhouettes in the logo style. | Average |
| RF - 4 | Animal Generation | Animal can be created by the geneticists and later allocated by a ranger in a padlock. | Low |
| RF - 5 | Animal Interaction | Animals in the same padlock can do a plethora of interactions. | Low |
| RF - 5.1 | BigCarnivores | Big carnivores will Move, Fight for Dominance, Hunt and Fight | Low |
| RF - 5.2 | SmallCarnivores | Small Carnivores will Move, Hunt in Packs, and Fight in Packs | Low |
| RF - 5.3 | Ornitopod | Ornitopods will just Move and Eat. | Low |
| RF - 5.4 | Marginocephalia / Thyreophora | Marginocephalia and Thyreophora will Move, Fight and Eat. | Low |
| RF - 5.5 | Sauropod | Sauropod will Eat and Move. | Low |
| RF - 6 | Animal Behavior Log | Every time a animal interacts with another it is shown in the log chat. | Low |
| RF - 7 | Species Listing | In the animal display page a table must appear with the animals in the padlock data, including species, quantity expected, quantity found and species version | Low |
| RF - 8 | Feedback | A user must be capable of sending a message to the InGen group, the feedback must contain name, return email and message. | High |
| RF - 9 | Email Response | The InGen group must answer with a “we receive the feedback” and later a appropriate user of the group would answer the feedback. | Average |
| RF - 10 | Create Worker | Create a User for the worker. | High |
| RF - 11 | Edit Worker | Change workers in case a update in their work inside InGen happens. | High |
| RF - 12 | List Workers | List one or more workers that are currently working for InGen and what type of worker. | High |
| RF - 13 | Delete Worker | Delete workers not currently employed by InGen. | High |
| RF - 14 | Create Operations | Create a operations for the workers to conclude. | High |
| RF - 15 | Edit Operations | Change the operations if a mistake were to be made. | High |
| RF - 16 | Read Operations | List one or more open operations to be concluded by the workers. | High |
| RF - 17 | Delete Operation | Delete mistaken operations. | High |
| RF - 18 | Conclude Operations | Delete operations that were concluded and append the concluded operations list. | High |

# Diagrams

## UML

### Context Diagram

![Context Diagram.drawio.png](Diagrams\Context_Diagram.drawio.png)

### Entity Relationship

![Entity Relationship Diagram.drawio.png](Diagrams\Entity_Relationship\Entity_Relationship_Diagram.drawio.png)

### Dinosaurs

![Entity Relationship.drawio.png](Diagrams\Entity_Relationship\Entity_Relationship.drawio.png)

## Data-Flow Diagram

### RF - 1: Login

![RF1 Login.drawio.png](Diagrams\Functional_Requirements\RF1_Login.drawio.png)

### RF - 2: Register

![RF2 Register.drawio.png](Diagrams\Functional_Requirements\RF2_Register.drawio.png)

### RF - 3: Animal Display

![RF3 Animal Display.drawio.png](Diagrams\Functional_Requirements\RF3_Animal_Display.drawio.png)

### RF - 4: Animal Generation

![RF4 Animal Generation.drawio.png](Diagrams\Functional_Requirements\RF4_Animal_Generation.drawio.png)

### RF - 5.1: Animal Behavior - BigCarnivore

![RF5.1 Animal Interaction Carnivore.drawio.png](Diagrams\Functional_Requirements\RF5.1_Animal_Interaction_Carnivore.drawio.png)

### RF - 5.4: Animal Behavior - Marginocephalia

![RF5.4 Animal Interaction Marginocephalia Thyreophora.drawio.png](Diagrams\Functional_Requirements\RF5.4_Animal_Interaction_Marginocephalia_Thyreophora.drawio.png)

### RF - 6: Animal Behavior Log

![RF6 Animal Behavior Log.drawio.png](Diagrams\Functional_Requirements\RF6_Animal_Behavior_Log.drawio.png)

### RF - 7: Species Listing

![RF7 Species Listing.drawio.png](Diagrams\Functional_Requirements\RF7_Species_Listing.drawio.png)

### RF - 8: Feedback

![RF8 Feedback.drawio.png](Diagrams\Functional_Requirements\RF8_Feedback.drawio.png)

### RF - 9: Email Response

![RF9 Email Response.drawio.png](Diagrams\Functional_Requirements\RF9_Email_Response.drawio.png)

### RF - 10: Create Worker

![RF10 Create Worker.drawio.png](Diagrams\Functional_Requirements\RF10_Create_Worker.drawio.png)

### RF - 11: Edit Worker

![RF11 Edit Worker.drawio.png](Diagrams\Functional_Requirements\RF11_Edit_Worker.drawio.png)

### RF - 12: List Workers

![RF12 List Workers.drawio.png](Diagrams\Functional_Requirements\RF12_List_Workers.drawio.png)

### RF - 13: Delete Worker

![RF13 Delete Worker.drawio.png](Diagrams\Functional_Requirements\RF13_Delete_Worker.drawio.png)

### RF - 14: Create Operation

![RF14 Create Operation.drawio.png](Diagrams\Functional_Requirements\RF14_Create_Operation.drawio.png)

### RF - 15: Edit Operation

![RF15 Edit Operations.drawio.png](Diagrams\Functional_Requirements\RF15_Edit_Operations.drawio.png)

### RF - 16: List Operations

![RF16 Read Operations.drawio.png](Diagrams\Functional_Requirements\RF16_Read_Operations.drawio.png)

### RF - 17: Remove Operation

![RF17 Delete Operation.drawio.png](Diagrams\Functional_Requirements\RF17_Delete_Operation.drawio.png)

### RF - 18: Conclude Operation

![RF18 Conclude Operation.drawio.png](Diagrams\Functional_Requirements\RF18_Conclude_Operation.drawio.png)

# Data

## Database

### User

- Name
- Email
- Password

### Animal

- Id
- Species*
- PositionX
- PositionY

### Species

- ID
- Name
- Version
- Speed
- Size

### Operations

- ID
- Name
- Description
- Worker

## Rendering Animal

- Get the padlock based on the id;
- Get the dinos list;
    - ID;
    - Name;
    - Position;
    - Size;
    - Speed;
- Render in a grid based system, all padlocks will be a 40 x 30;
- Render the animals Scaled up to be the rendered grid;
- Start with the animals in the last saved position;
- Every (current time % 60 / (dino speed) results in 0) seconds the animals do a behavior based on their behavior list;
- when the user goes to another page the function ends

## Animal List

### Sauropods

- Apatosaurus
- Brontosaurus
- Braquiosaurus
- Camarasaurus

### Thyreophora

- Stegosaurus
- Euoplecephalids
- Ankylosaurus

### **Marginocephalia**

- Triceratops
- Styracosaurus
- Microceratops

### **Ornitopod**

- Maiasaurus
- Othnielia
- Hadrosaurus
- Hypsilophodontids
- Parasaurolophus

### Big Carnivores

- Tyrannosaurus Rex
- Dilophosaurus

### Small Carnivores

- Procompsognatus
- Velociraptor (Deinonychus)
- Pterosaurus

### Others

- Galimimus