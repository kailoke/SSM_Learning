package A11_TransactionAnnotation.dao;

import A11_TransactionAnnotation.domain.Account;

public interface AccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String name);
    void update(Account account);
}
