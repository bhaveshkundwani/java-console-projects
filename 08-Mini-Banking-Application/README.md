# Mini Banking Application (Java + JDBC)

A console-based mini banking application built in Java using **JDBC** (Java Database Connectivity) to persist accounts and transactions in a MySQL database. It supports creating an account, logging in, viewing your balance, and transferring money to another customer.

This is a project in my java-console-projects repository.

## About JDBC & Transactions in This Project

This project uses JDBC to connect to and interact with a MySQL database —
`PreparedStatement` is used throughout for safe, parameterized SQL queries.

Money transfers are treated as a proper **database transaction**:

- `con.setAutoCommit(false)` groups the debit and credit updates into a
  single unit of work.
- If both updates succeed, `con.commit()` saves the changes permanently.
- If anything fails partway through, `con.rollback()` undoes any partial
  changes, so a transfer can never leave the sender debited without the
  receiver being credited (or vice versa).

## Features

- Create a new account (unique username + password/pass-code, starting balance of 1000)
- Log in with username and password
- View your account balance
- Transfer money to another account (with balance and rollback safety)
- Simple, menu-driven console interface

## Project Structure

```
08-Mini-Banking-Application/
├── README.md
└── src/
    └── com/
        └── banking/
            ├── ConnectionWithDB.java   # Loads the JDBC driver and opens the DB connection
            ├── BankManagement.java     # Business logic: create account, login, balance, transfer
            └── Bank.java               # Main class — the console menu / entry point
```

## Key Concepts Used

- **JDBC** – `DriverManager`, `Connection`, `PreparedStatement`, and `ResultSet` for talking to MySQL.
- **Transactions** – `setAutoCommit(false)`, `commit()`, and `rollback()` to keep a transfer's debit and credit in sync.
- **Exception handling** – catches `SQLIntegrityConstraintViolationException` specifically to report a duplicate username, and handles other failures without crashing.
- **Switch expressions** (`case 1 ->`) – Java 14+ arrow-style `switch` for the console menu.
- **`BufferedReader`** – reads console input as full lines, including account names with spaces.

## Database Setup

```sql
CREATE DATABASE bank;
USE bank;

CREATE TABLE customer (
    ac_no INT NOT NULL AUTO_INCREMENT,
    cname VARCHAR(45) UNIQUE NOT NULL,
    balance INT DEFAULT 1000,
    pass_code INT NOT NULL,
    PRIMARY KEY (ac_no)
);
```

## Configuration

Update the credentials in `ConnectionWithDB.java` to match your local MySQL setup:

```java
String url = "jdbc:mysql://localhost:3306/bank";
String user = "root";
String pass = "your_mysql_password";
```

## How to Run

1. Add the MySQL JDBC Connector `.jar` to your project's build path (a `lib/` folder works well in Eclipse).
2. Make sure MySQL is running and the `bank` database/table exist (see **Database Setup** above).
3. Compile and run `Bank.java` as a Java application — from your IDE.

## Sample Output

```
===============================
 Welcome to IndianBank 
===============================
1) Create Account
2) Login Account
3) Exit

Enter Choice: 1
Enter Unique Username: bhavesh
Enter Password: 1234
Account created successfully! You can now login.
You can now login from the main menu.

===============================
 Welcome to IndianBank 
===============================
1) Create Account
2) Login Account
3) Exit

Enter Choice: 2
Enter Username: bhavesh
Enter Password: 1234

 Hello, bhavesh! What would you like to do?
1) Transfer Money
2) View Balance
3) Logout
Enter Choice: 2

-------------------------------------------------
  Account No   Customer Name    Balance
-------------------------------------------------
           1         bhavesh    1000.00
-------------------------------------------------

 Hello, bhavesh! What would you like to do?
1) Transfer Money
2) View Balance
3) Logout
Enter Choice: 1
Enter Receiver A/c No: 2
Enter Amount: 200
Transaction successful!

 Hello, bhavesh! What would you like to do?
1) Transfer Money
2) View Balance
3) Logout
Enter Choice: 3
Logged out successfully. Returning to main menu.

Enter Choice: 3
Thank you for using IndianBank! Goodbye.
```

### Handling common errors

**Duplicate username on account creation:**
```
Username already exists! Try another one.
```

**Insufficient balance on transfer:**
```
Insufficient Balance!
```

**Wrong username or password on login:**
```
Invalid username or password!
```

## Notes

- The database password in `ConnectionWithDB.java` is hardcoded for
  simplicity — for anything beyond a learning project, move credentials
  out of source code (e.g. environment variables or a config file) and
  never commit real credentials to GitHub.
- Passwords are stored and compared as **plain integers** (`pass_code`),
  with no hashing — fine for practicing JDBC, but not something to reuse
  for real account security.
- `transferMoney()` doesn't verify that the receiver's account number
  actually exists before crediting it, so transferring to a non-existent
  account number will silently update zero rows instead of failing.
- The single `Connection` returned by `ConnectionWithDB.getConnection()`
  is reused for the whole application rather than opened per-request.