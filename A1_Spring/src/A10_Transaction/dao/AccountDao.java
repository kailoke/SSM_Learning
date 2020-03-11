package A10_Transaction.dao;

import A10_Transaction.domain.Account;

public interface AccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String name);
    void update(Account account);
}
