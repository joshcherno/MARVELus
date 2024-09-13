# MARVELus - Comic Book Collection Assistant
## Overview
MARVELus is a full-stack web application designed for comic book collectors to create and manage their collections easily. The application allows users to search for comics by title, main character, or unique UPC through the Marvel API, adding selected comics to their collections. While some functions were hard-coded or slightly limited to ensure the project was ready for demo, the app has been built with planned future enhancements in mind. These enhancements include social sharing, adding friends, trading, and real-time valuation based on collector sites like PSA or CGC, creating potential revenue streams. MARVELus was developed in under two weeks, showcasing rapid, collaborative development and effective team coordination.

## Features
### 1. User Registration & Authentication
New users can register, and existing users can securely log in to manage their comic book collections.
Authentication is handled through Spring Security to ensure data privacy and user-specific collections.
### 2. Comic Search & Collection Management
Users can search for comics by:
Comic Title
Main Character
Unique UPC
The search results are pulled directly from the Marvel API, allowing access to real-time comic data.
Users can add comics to their collections for easy management and reference.
### 3. Personal Comic Book Collection
Users get a dedicated space to view and manage their saved comic books.
Users can remove items from their collection or update notes about individual comics.
## Technologies Used
### Front-End:

Vue.js for dynamic user interfaces and responsive web design.
Axios for handling HTTP requests between the front-end and back-end.
### Back-End:

Java and Spring Boot for handling business logic, service layers, and API management.
PostgreSQL for data storage and retrieval.
RESTful API for communication between front-end and back-end.
Marvel API for comic data.
## Development Tools:

Git for version control.
Maven for project build management.
## Team Members
#### Joshua Chernomorets
Full-Stack Developer with a focus on front-end development for this project. Joshua played a key role in planning the full-stack architecture and led efforts on aesthetics, user experience, branding, and ensuring seamless connectivity between the front-end and back-end systems. He worked closely with the team to ensure smooth integration of all components.
#### Dylan Akers
Full-Stack Developer, contributing to both back-end logic and API integration. Dylan played a pivotal role in the initial front-end architecture to establish a strong UI foundation and collaborated on the overall structure to ensure a consistent user experience. His input was key in developing the back-end services that powered the application.
#### Rob Roberts
Full-Stack Developer with a focus on back-end development for this project. who laid the foundational structure for the back-end services and led efforts to integrate the Marvel API. Rob ensured data handling was smooth, playing a major role in the communication between the API and the app’s internal systems, enabling efficient data flow.
Working together, the team tackled complex challenges, such as integrating Marvel’s extensive API and managing the large datasets involved.
