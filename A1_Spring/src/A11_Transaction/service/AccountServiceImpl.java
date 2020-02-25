package A11_Transaction.service;

import A11_Transaction.dao.AccountDao;
import A11_Transaction.domain.Account;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void transfer(String sourceAccount, String targetAccount, Double money) {
        // 1. 查询账户
        Account source = accountDao.findAccountByName(sourceAccount);
        Account target = accountDao.findAccountByName(targetAccount);

        // 2.转出金钱
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        // 3.更新账户信息
        accountDao.update(source);
//        int i = 1 / 0;    // 模拟事务中的异常
        accountDao.update(target);
    }
}
