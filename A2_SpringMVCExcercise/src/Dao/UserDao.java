package Dao;

import domain.Account;
import domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    private static Map<Integer, User> users = new HashMap<>();
    static {
        users.put(1001,new User(1001,"user_1001",new Account(101,1000)));
        users.put(1002,new User(1002,"user_1002",new Account(102,3000)));
        users.put(1003,new User(1003,"user_1003",new Account(103,2000)));
        users.put(1004,new User(1004,"user_1004",new Account(104,5000)));
        users.put(1005,new User(1005,"user_1005",new Account(105,2500)));
    }

    public static Collection<User> getUsers() {
        return users.values();
    }
    public static User get(Integer id) {
        return users.get(id);
    }
    public static void delete(Integer id) {
        users.remove(id);
    }

    private static Integer initID = 1006;
    public static void save(User user) {
        if (user.getId() == 0) {
            user.setId(initID++);
        }

        user.setAccount(AccountDao.getAccount(user.getAccount().getAccountId()));
        users.put(user.getId(),user);
    }
}
