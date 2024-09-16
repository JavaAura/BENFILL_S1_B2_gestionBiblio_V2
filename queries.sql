-- Create the database
CREATE DATABASE LibraryApp;

-- Create the sequence for document IDs
CREATE SEQUENCE global_document_id_seq;

-- Create the documents table
CREATE TABLE documents (
    id INT DEFAULT nextval('global_document_id_seq') PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publicationDate VARCHAR(255),
    pagesNumber INT,
    borrowed BOOLEAN DEFAULT FALSE,
    type VARCHAR(255)
);

-- Create the books table, inheriting from documents
CREATE TABLE books (
    isbn VARCHAR(255)
) INHERITS (documents);

-- Create the magazines table, inheriting from documents
CREATE TABLE magazines (
    number INT
) INHERITS (documents);

-- Create the scientific journals table, inheriting from documents
CREATE TABLE scientific_journals (
    researchField VARCHAR(255)
) INHERITS (documents);

-- Create the university theses table, inheriting from documents
CREATE TABLE university_theses (
    university VARCHAR(255),
    fieldOfStudy VARCHAR(255)
) INHERITS (documents);

-- Create the sequence for user IDs
CREATE SEQUENCE global_user_id_seq;

-- Create the users table
CREATE TABLE users (
    id INT DEFAULT nextval('global_user_id_seq') PRIMARY KEY,
    name VARCHAR(255) UNIQUE,
    email VARCHAR(255)
);

-- Create the students table, inheriting from users
CREATE TABLE students (
    academicLevel VARCHAR(255)
) INHERITS (users);

-- Create the professors table, inheriting from users
CREATE TABLE professors (
    professorID VARCHAR(255),
    department VARCHAR(255)
) INHERITS (users);

-- Create the reservations table with foreign key references to documents and users
CREATE TABLE reservations (
    document_id INT REFERENCES documents(id),
    user_id INT REFERENCES users(id),
    status VARCHAR(255)
);

-- Create the borrowings table with foreign key references to documents and users
CREATE TABLE borrowings (
    document_id INT REFERENCES documents(id),
    user_id INT REFERENCES users(id),
    status VARCHAR(255)
);
