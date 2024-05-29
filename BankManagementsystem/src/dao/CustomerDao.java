package dao;

import modal.Customer;
import utility.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (name, email, phoneNumber) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhoneNumber());
            stmt.executeUpdate();
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customers.add(customer);
            }
        }
        return customers;
    }

    public Customer getCustomerById(int id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE id=?";
        Customer customer = null;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setId(rs.getInt("id"));
                    customer.setName(rs.getString("name"));
                    customer.setEmail(rs.getString("email"));
                    customer.setPhoneNumber(rs.getString("phoneNumber"));
                }
            }
        }
        return customer;
    }

    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE customers SET name = ?, email = ?, phoneNumber = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhoneNumber());
            stmt.setInt(4, customer.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
