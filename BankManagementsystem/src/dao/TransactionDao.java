package dao;

import modal.Transaction;
import utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (accountId, amount, transactionType, transactionDate) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getAccountId());
            stmt.setDouble(2, transaction.getAmount());
            stmt.setString(3, transaction.getTransactionType());
            stmt.setDate(4, new java.sql.Date(transaction.getTransactionDate().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Transaction> getAllTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountId(rs.getInt("accountId"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setTransactionType(rs.getString("transactionType"));
                transaction.setTransactionDate(rs.getDate("transactionDate"));
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public Transaction getTransactionById(int id) throws SQLException {
        String sql = "SELECT * FROM transactions WHERE id=?";
        Transaction transaction = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    transaction = new Transaction();
                    transaction.setId(rs.getInt("id"));
                    transaction.setAccountId(rs.getInt("accountId"));
                    transaction.setAmount(rs.getDouble("amount"));
                    transaction.setTransactionType(rs.getString("transactionType"));
                    transaction.setTransactionDate(rs.getDate("transactionDate"));
                }
            }
        }
        return transaction;
    }

    public void updateTransaction(Transaction transaction) throws SQLException {
        String sql = "UPDATE transactions SET accountId = ?, amount = ?, transactionType = ?, transactionDate = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getAccountId());
            stmt.setDouble(2, transaction.getAmount());
            stmt.setString(3, transaction.getTransactionType());
            stmt.setDate(4, new java.sql.Date(transaction.getTransactionDate().getTime()));
            stmt.setInt(5, transaction.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteTransaction(int id) throws SQLException {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
