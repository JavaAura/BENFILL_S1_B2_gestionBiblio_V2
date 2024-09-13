# Municipal Library Management - V2

## Project Description
This municipal library management application allows for efficient handling of books, magazines, academic theses, and scientific journals, as well as the borrowing and returning processes. The system offers distinct roles for users, such as students and professors, each with specific functionalities according to their role.

## General Objective of the Application
The main goal of this application is to automate the common tasks of library management, including:
- Managing the inventory of documents (books, magazines, theses, etc.)
- Facilitating the borrowing and returning of documents
- Improving user management through specific roles (student and professor)

## Technologies Used
- **Java 8**: Main programming language for development
- **Eclipse IDE**: Integrated Development Environment
- **PostgreSQL**: Relational database for data persistence
- **JDBC (Java Database Connectivity)**: For managing data persistence
- **Git & GitHub**: Version control and project hosting

## Project Structure
The project is organized as follows:

- **controllers**: Manages controllers that link views and business logic (e.g., `AppController`, `LibraryController`).
- **dao**: Contains interfaces for accessing document and user data (`DocumentDao`, `BookDao`, etc.).
- **db**: Contains classes for managing database connections and queries (`DbConnection`, `DbRequest`) as well as table creation.
- **models**: Classes representing the data models of the application (`Book`, `Magazine`, `Student`, etc.).
- **services**: Responsible for implementing DAOs, handling CRUD operations with PostgreSQL.
- **views**: Contains classes related to the console user interface.
- **utils**: Utility classes for basic operations (e.g., date management in `DateUtils`).

## Brief Description of the Adopted Architecture
The application follows an MVC (Model-View-Controller) architecture:
- **Model**: Represents the data structure (classes `Document`, `Book`, `Magazine`, etc.).
- **View**: User interface in the form of interactive command-line menus.
- **Controller**: Links the views and models, manages business logic and user actions (classes `AppController`, `LibraryController`).

Data is managed via PostgreSQL to ensure persistence. The project includes classes for table creation and executing CRUD queries, ensuring effective management of documents and users.

## Installation and Usage Instructions

### Prerequisites
- **Java 8** or higher installed
- **PostgreSQL** for data persistence
- **Git** for project version control

### Steps to Set Up the Database
1. Install and configure PostgreSQL.
2. Create a database for the application.
3. Modify the configurations in the `DbConnection` class to include your database parameters.
4. Execute the SQL scripts in the `db` directory to create the necessary tables.

### How to Run the Application
1. Clone the Git repository:
   ```bash
   git clone https://github.com/JavaAura/BENFILL_S1_B2_gestionBiblio_V
   ```
2. Import the project into Eclipse IDE.
3. Compile and run the main class `Main.java`.
4. Follow the instructions in the console to interact with the application.

## Possible Future Enhancements
- **Graphical User Interface**: Create a graphical interface with JavaFX or Swing to make the application more user-friendly.
- **Advanced User Management**: Add additional roles and permissions specific to each role.
- **Statistics and Reports**: Generate reports on borrowing, returns, and inventory.

## Ideas to Extend or Improve the Project
- **Integration with Third-Party Library Management Systems**.
- **Import/Export Features**: Allow users to import or export library data in CSV or JSON format.
- **Advanced Search**: Add the ability to search for documents with advanced filters (by author, subject, etc.).

## Author and Contact
Developed by **Anass Benfillous**.  
Contact: [Benfianass@gmail.com]
