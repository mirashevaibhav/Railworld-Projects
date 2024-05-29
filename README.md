Introduction
The Bank Management System is a Java-based console application designed to manage customers, accounts, and transactions. It leverages JDBC for database operations and follows a DAO pattern for data access.

Project Structure
dao/: Data Access Objects for managing database interactions.
AccountDao.java
CustomerDao.java
TransactionDao.java

modal/: Model classes representing the data structures.
Account.java
Customer.java
Transaction.java

service/: Service classes containing business logic.
AccountService.java
CustomerService.java
TransactionService.java

util/: Utility classes for database connectivity.
DBUtil.java

Main.java: Entry point of the application with a menu-driven console interface.

AccountDao.java
addAccount(Account account): Adds a new account.
getAllAccounts(): Retrieves all accounts.
getAccountById(int id): Retrieves an account by ID.
updateAccount(Account account): Updates an account.
deleteAccount(int id): Deletes an account.

CustomerDao.java
addCustomer(Customer customer): Adds a new customer.
getAllCustomers(): Retrieves all customers.
getCustomerById(int id): Retrieves a customer by ID.
updateCustomer(Customer customer): Updates a customer.
deleteCustomer(int id): Deletes a customer.

TransactionDao.java
addTransaction(Transaction transaction): Adds a new transaction.
getAllTransactions(): Retrieves all transactions.
getTransactionById(int id): Retrieves a transaction by ID.
updateTransaction(Transaction transaction): Updates a transaction.
deleteTransaction(int id): Deletes a transaction.

Main.java
run(): Starts the main loop.
showMenu(): Displays menu options.
Methods to handle each menu option (e.g., addCustomer(), viewAllCustomers(), etc.).
Future Enhancements
Implement a graphical user interface (GUI).
Add security features like user authentication.
Expand functionality with more detailed transaction types.
