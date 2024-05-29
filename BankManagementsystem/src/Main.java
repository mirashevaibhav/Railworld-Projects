import modal.Account;
import modal.Customer;
import modal.Transaction;
import service.AccountService;
import service.CustomerService;
import service.TransactionService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private CustomerService customerService;
    private AccountService accountService;
    private TransactionService transactionService;
    private Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {
        customerService = new CustomerService();
        accountService = new AccountService();
        transactionService = new TransactionService();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        viewAllCustomers();
                        break;
                    case 3:
                        updateCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        viewCustomerById();
                        break;
                    case 6:
                        addAccount();
                        break;
                    case 7:
                        viewAllAccounts();
                        break;
                    case 8:
                        updateAccount();
                        break;
                    case 9:
                        deleteAccount();
                        break;
                    case 10:
                        viewAccountById();
                        break;
                    case 11:
                        addTransaction();
                        break;
                    case 12:
                        viewAllTransactions();
                        break;
                    case 13:
                        updateTransaction();
                        break;
                    case 14:
                        deleteTransaction();
                        break;
                    case 15:
                        viewTransactionById();
                        break;
                    case 16:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showMenu() {
        System.out.println("\nBank Management System");
        System.out.println("1. Add Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        System.out.println("5. View Customer by ID");
        System.out.println("6. Add Account");
        System.out.println("7. View All Accounts");
        System.out.println("8. Update Account");
        System.out.println("9. Delete Account");
        System.out.println("10. View Account by ID");
        System.out.println("11. Add Transaction");
        System.out.println("12. View All Transactions");
        System.out.println("13. Update Transaction");
        System.out.println("14. Delete Transaction");
        System.out.println("15. View Transaction by ID");
        System.out.println("16. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addCustomer() throws SQLException {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);

        customerService.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    private void viewAllCustomers() throws SQLException {
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void updateCustomer() throws SQLException {
        System.out.print("Enter customer ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = customerService.getCustomerById(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter new customer name: ");
        customer.setName(scanner.nextLine());
        System.out.print("Enter new customer email: ");
        customer.setEmail(scanner.nextLine());
        System.out.print("Enter new customer phone number: ");
        customer.setPhoneNumber(scanner.nextLine());

        customerService.updateCustomer(customer);
        System.out.println("Customer updated successfully.");
    }

    private void deleteCustomer() throws SQLException {
        System.out.print("Enter customer ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        customerService.deleteCustomer(id);
        System.out.println("Customer deleted successfully.");
    }

    private void viewCustomerById() throws SQLException {
        System.out.print("Enter customer ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void addAccount() throws SQLException {
        System.out.print("Enter customer ID for the account: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter account type (Savings/Current): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        Account account = new Account();
        account.setCustomerId(customerId);
        account.setAccountType(accountType);
        account.setBalance(balance);

        accountService.addAccount(account);
        System.out.println("Account added successfully.");
    }

    private void viewAllAccounts() throws SQLException {
        List<Account> accounts = accountService.getAllAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private void updateAccount() throws SQLException {
        System.out.print("Enter account ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Account account = accountService.getAccountById(id);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter new customer ID: ");
        account.setCustomerId(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter new account type (Savings/Current): ");
        account.setAccountType(scanner.nextLine());
        System.out.print("Enter new balance: ");
        account.setBalance(Double.parseDouble(scanner.nextLine()));

        accountService.updateAccount(account);
        System.out.println("Account updated successfully.");
    }

    private void deleteAccount() throws SQLException {
        System.out.print("Enter account ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        accountService.deleteAccount(id);
        System.out.println("Account deleted successfully.");
    }

    private void viewAccountById() throws SQLException {
        System.out.print("Enter account ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());
        Account account = accountService.getAccountById(id);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void addTransaction() throws SQLException {
        System.out.print("Enter account ID for the transaction: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter transaction amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter transaction type (Credit/Debit): ");
        String transactionType = scanner.nextLine();

        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setTransactionType(transactionType);
        transaction.setTransactionDate(new java.util.Date());

        transactionService.addTransaction(transaction);
        System.out.println("Transaction added successfully.");
    }

    private void viewAllTransactions() throws SQLException {
        List<Transaction> transactions = transactionService.getAllTransactions();
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private void updateTransaction() throws SQLException {
        System.out.print("Enter transaction ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction == null) {
            System.out.println("Transaction not found.");
            return;
        }

        System.out.print("Enter new account ID: ");
        transaction.setAccountId(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter new transaction amount: ");
        transaction.setAmount(Double.parseDouble(scanner.nextLine()));
        System.out.print("Enter new transaction type (Credit/Debit): ");
        transaction.setTransactionType(scanner.nextLine());
        transaction.setTransactionDate(new java.util.Date());

        transactionService.updateTransaction(transaction);
        System.out.println("Transaction updated successfully.");
    }

    private void deleteTransaction() throws SQLException {
        System.out.print("Enter transaction ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        transactionService.deleteTransaction(id);
        System.out.println("Transaction deleted successfully.");
    }

    private void viewTransactionById() throws SQLException {
        System.out.print("Enter transaction ID to view: ");
        int id = Integer.parseInt(scanner.nextLine());
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            System.out.println(transaction);
        } else {
            System.out.println("Transaction not found.");
        }
    }
}