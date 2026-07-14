# Library Management System (Java Console App)

A menu-driven console application for managing a small library, built in
Java. It supports adding and searching books, registering students, and
checking books in and out — all through a simple numbered menu driven by a
`switch` statement.

This is the third project in my console-java-projects repository.

## Why This Project

This project is a practical way to reinforce core Java fundamentals through
a real-world scenario:

- Using `switch` (including a nested `switch`) to drive a menu-based application.
- Managing related data with multiple classes and objects.
- Implementing common real-world operations: add, search, update, and remove.

## Features

- Add a new book (rejects duplicate names or serial numbers)
- Upgrade the quantity of an existing book
- Search for a book by serial number **or** author name
- Show all books currently in the library
- Register a new student (rejects duplicate registration numbers)
- Show all registered students
- Check out a book to a student (max 3 books per student, only if in stock)
- Check in a book returned by a student
- Exit the application

## Project Structure

```
03-Library-Management-System/
├── README.md
└── src/
      └── com.college/
    	  ├── Book.java         # A single book's details (serial no, name, author, quantity)
    	  ├── Books.java        # Manages the collection of books: add, search, update, checkout/checkin
    	  ├── Student.java      # A single student's details (name, reg number, borrowed books)
    	  ├── Students.java     # Manages student records and book borrowing/returning
    	  └── Library.java      # Main menu and application entry point
```

## How to Use

Run the app and you'll see a menu of numbered options:

```
Press 0 to Exit Application.
Press 1 to Add new Book.
Press 2 to Upgrade Quantity of a Book.
Press 3 to Search a Book.
Press 4 to Show All Books.
Press 5 to Register Student.
Press 6 to Show All Registered Students.
Press 7 to Check Out Book.
Press 8 to Check In Book
```

Enter a number and follow the prompts. Option **3** (Search a Book) opens a
second, nested menu so you can search by serial number or by author name.
The menu keeps reappearing until you choose to exit.

## Key Concepts Used

- **`switch` / nested `switch`** – Drives the main menu and the book-search sub-menu.
- **Classes & objects** – `Book`/`Student` model individual records, while
  `Books`/`Students` manage the collections and the operations on them.
- **Arrays** – Books and Students are stored in fixed-size arrays (`book[50]`, `student[50]`).
- **`do-while` loop** – Keeps the menu showing until the user chooses to exit.
- **`Scanner`** – Reads all user input from the console.


## Sample Output

```
********************Welcome to the College Library!********************
                  Select From The Following Options:
**********************************************************************
----------------------------------------------------------------------------------------------------------
Press 0 to Exit Application.
Press 1 to Add new Book.
Press 2 to Upgrade Quantity of a Book.
Press 3 to Search a Book.
Press 4 to Show All Books.
Press 5 to Register Student.
Press 6 to Show All Registered Students.
Press 7 to Check Out Book. 
Press 8 to Check In Book
-------------------------------------------------------------------------------------------------------
1
Enter Serial No of Book:
101
Enter Book Name:
Wings of Fire
Enter Author Name:
A.P.J Abdul Kalam
Enter Quantity of Books:
5

... (menu reprints) ...
4
				SHOWING ALL BOOKS

S.No	Name		  Author		 Available Qty   Total Qty
101	Wings of Fire     A.P.J Abdul Kalam      5	         5 

... (menu reprints) ...
5
Enter Student Name:
Riya Sharma
Enter Registration Number:
REG001

... (menu reprints) ...
6
Student Name		Reg Number
Riya Sharma		REG001

... (menu reprints) ...
7
Enter Reg Number:
REG001
checking out
				SHOWING ALL BOOKS

S.No	Name		  Author		 Available Qty   Total Qty
101	Wings of Fire     A.P.J Abdul Kalam      5	         5
Enter Serial No of Book to be Checked Out.
101
Book is Available.
checking out
adding book

... (menu reprints) ...
0
ENTER BETWEEN 0 TO 8.
```