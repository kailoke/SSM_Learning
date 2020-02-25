package A11_Transaction.dao;

import A11_Transaction.domain.Account;

public interface AccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String name);
    void update(Account account);
}
