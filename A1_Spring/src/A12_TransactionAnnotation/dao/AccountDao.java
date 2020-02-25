package A12_TransactionAnnotation.dao;

import A12_TransactionAnnotation.domain.Account;

public interface AccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String name);
    void update(Account account);
}
