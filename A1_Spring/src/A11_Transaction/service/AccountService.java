package A11_Transaction.service;

import A11_Transaction.domain.Account;

public interface AccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceAccount,String targetAccount,Double money);
}
