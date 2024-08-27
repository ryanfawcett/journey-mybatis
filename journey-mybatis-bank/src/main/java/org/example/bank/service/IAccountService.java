package org.example.bank.service;

/**
 * 账户业务接口
 *
 * @author ryanfawcett
 * @version 1.0
 * @since 1.0
 */
public interface IAccountService {
    /**
     * 转账
     *
     * @param from 转出账户
     * @param to   转入账户
     * @param amt  转账金额
     */
    void transfer(String from, String to, double amt);
}
