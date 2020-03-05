package A8_Json;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountDao {
    private static Map<Integer, Account> accounts = new HashMap<>();
    static {
        accounts.put(101,new Account(101,1000));
        accounts.put(102,new Account(102,3000));
        accounts.put(103,new Account(103,2000));
        accounts.put(104,new Account(104,5000));
        accounts.put(105,new Account(105,2500));
    }
    public static Collection<Account> getAccounts() {
        return accounts.values();
    }
    public static Account getAccount(Integer id) {
        return accounts.get(id);
    }
}
