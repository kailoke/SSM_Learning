package A12_TransactionAnnotation.service;

import A12_TransactionAnnotation.domain.Account;

public interface AccountService {
    Account findAccountById(Integer accountId);

    void transfer(String sourceAccount, String targetAccount, Double money) throws Exception;
}
