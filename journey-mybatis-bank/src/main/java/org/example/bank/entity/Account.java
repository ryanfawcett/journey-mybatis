package org.example.bank.entity;

/**
 * 账户类
 *
 * @author ryanfawcett
 * @version 1.0
 * @since 1.0
 */
public class Account {
    private Long id;
    private String accountId;
    private Double balance;

    public Account() {
    }

    public Account(Long id, String accountId, Double balance) {
        this.id = id;
        this.accountId = accountId;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
