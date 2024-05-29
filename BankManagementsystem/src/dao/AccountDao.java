package dao;

import modal.Account;
import utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    public void addAccount(Account account) throws SQLException {
        String sql = "INSERT INTO accounts (customerId, accountType, balance) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.executeUpdate();
        }
    }

    public List<Account> getAllAccounts() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setCustomerId(rs.getInt("customerId"));
                account.setAccountType(rs.getString("accountType"));
                account.setBalance(rs.getDouble("balance"));
                accounts.add(account);
            }
        }
        return accounts;
    }

    public Account getAccountById(int id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE id=?";
        Account account = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    account = new Account();
                    account.setId(rs.getInt("id"));
                    account.setCustomerId(rs.getInt("customerId"));
                    account.setAccountType(rs.getString("accountType"));
                    account.setBalance(rs.getDouble("balance"));
                }
            }
        }
        return account;
    }

    public void updateAccount(Account account) throws SQLException {
        String sql = "UPDATE accounts SET customerId = ?, accountType = ?, balance = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, account.getCustomerId());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.setInt(4, account.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteAccount(int id) throws SQLException {
        String sql = "DELETE FROM accounts WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
