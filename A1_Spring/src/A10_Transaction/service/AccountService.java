package A10_Transaction.service;

import A10_Transaction.domain.Account;

public interface AccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceAccount,String targetAccount,Double money);
}
