package org.example.bank.dao;

import org.example.bank.entity.Account;

/**
 * 账户持久层接口, 用于操作账户表, 实现账户的CRUD
 *
 * @author ryanfawcett
 * @version 1.0
 * @since 1.0
 */
public interface IAccountMapper {
    Account getAccountById(String account);

    void updateByAccountId(Account account);

    Account getAccounts();
}
