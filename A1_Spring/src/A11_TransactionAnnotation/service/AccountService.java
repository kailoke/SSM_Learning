package A11_TransactionAnnotation.service;

import A11_TransactionAnnotation.domain.Account;

public interface AccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceAccount, String targetAccount, Double money) throws Exception;
}
