package service;

import dao.TransactionDao;
import modal.Transaction;

import java.sql.SQLException;
import java.util.List;

public class TransactionService {
    private TransactionDao transactionDao;

    public TransactionService() {
        transactionDao = new TransactionDao();
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        transactionDao.addTransaction(transaction);
    }

    public Transaction getTransactionById(int id) throws SQLException {
        return transactionDao.getTransactionById(id);
    }

    public List<Transaction> getAllTransactions() throws SQLException {
        return transactionDao.getAllTransactions();
    }

    public void updateTransaction(Transaction transaction) throws SQLException {
        transactionDao.updateTransaction(transaction);
    }

    public void deleteTransaction(int id) throws SQLException {
        transactionDao.deleteTransaction(id);
    }
}
