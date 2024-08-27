package org.example.bank.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.bank.dao.IAccountMapper;
import org.example.bank.entity.Account;
import org.example.bank.util.SqlSessionUtil;

/**
 * 账户持久层实现类
 *
 * @author ryanfawcett
 * @version 1.0
 * @since 1.0
 */
public class AccountMapperImpl implements IAccountMapper {
    @Override
    public Account getAccountById(String accountId) {
        SqlSession session = SqlSessionUtil.getAutoCommitSqlSession();
        return session.selectOne("getAccountById", accountId);
    }

    @Override
    public void updateByAccountId(Account account) {
        SqlSession session = SqlSessionUtil.getAutoCommitSqlSession();
        session.update("updateByAccountId", account);
    }

    @Override
    public Account getAccounts() {
        return null;
    }
}
