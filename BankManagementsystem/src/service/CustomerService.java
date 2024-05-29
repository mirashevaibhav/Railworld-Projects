package service;

import dao.CustomerDao;
import modal.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public void addCustomer(Customer customer) throws SQLException {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int id) throws SQLException {
        return customerDao.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() throws SQLException {
        return customerDao.getAllCustomers();
    }

    public void updateCustomer(Customer customer) throws SQLException {
        customerDao.updateCustomer(customer);
    }

    public void deleteCustomer(int id) throws SQLException {
        customerDao.deleteCustomer(id);
    }
}
