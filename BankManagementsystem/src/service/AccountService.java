package service;

import dao.AccountDao;
import modal.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    private AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public void addAccount(Account account) throws SQLException {
        accountDao.addAccount(account);
    }

    public Account getAccountById(int id) throws SQLException {
        return accountDao.getAccountById(id);
    }

    public List<Account> getAllAccounts() throws SQLException {
        return accountDao.getAllAccounts();
    }

    public void updateAccount(Account account) throws SQLException {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(int id) throws SQLException {
        accountDao.deleteAccount(id);
    }
}
