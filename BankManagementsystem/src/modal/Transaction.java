package modal;

import java.util.Date;

public class Transaction {
    private int id;
    private int accountId;
    private double amount;
    private String transactionType;
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(int id, int accountId, double amount, String transactionType, Date transactionDate) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
