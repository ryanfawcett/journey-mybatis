package org.example.bank.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.bank.dao.IAccountMapper;
import org.example.bank.dao.impl.AccountMapperImpl;
import org.example.bank.entity.Account;
import org.example.bank.service.IAccountService;
import org.example.bank.util.SqlSessionUtil;

import java.util.Objects;

/**
 * 账户业务实现类
 *
 * @author ryanfawcett
 * @version 1.0
 * @since 1.0
 */
public class AccountServiceImpl implements IAccountService {

    private final IAccountMapper accountMapper = new AccountMapperImpl();

    @Override
    public void transfer(String from, String to, double amt) {
        // 判断账户是否存在
        Account accountFrom = accountMapper.getAccountById(from);
        if (Objects.isNull(accountFrom)) {
            return;
        }

        Account accountTo = accountMapper.getAccountById(to);
        if (Objects.isNull(accountTo)) {
            return;
        }
        // 判断转出账户中的金额是否充足
        if (accountFrom.getBalance() < amt) {
            return;
        }
        // 更新转出账户余额
        accountFrom.setBalance(accountFrom.getBalance() - amt);
        // 更新转入账户余额
        accountTo.setBalance(accountTo.getBalance() + amt);

        try {
            accountMapper.updateByAccountId(accountFrom);
            accountMapper.updateByAccountId(accountTo);
        } catch (Exception e) {
            SqlSession session = SqlSessionUtil.getAutoCommitSqlSession();
            session.rollback();
            throw new RuntimeException(e);
        }
    }
}
