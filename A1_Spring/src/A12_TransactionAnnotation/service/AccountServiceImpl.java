package A12_TransactionAnnotation.service;

import A12_TransactionAnnotation.dao.AccountDao;
import A12_TransactionAnnotation.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    @Transactional()
    public void transfer(String sourceAccount, String targetAccount, Double money) {
        // 1. 查询账户
        Account source = accountDao.findAccountByName(sourceAccount);
        Account target = accountDao.findAccountByName(targetAccount);

        // 2.转出金钱
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        // 3.更新账户信息
        accountDao.update(source);
        int i = 1 / 0;  // 模拟事务中的异常
        accountDao.update(target);
    }
}
