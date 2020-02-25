package A12_TransactionAnnotation.dao;

import A12_TransactionAnnotation.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = jdbcTemplate.query("select * from account where accountId=?", new BeanPropertyRowMapper<>(Account.class), accountId);
        return query.isEmpty()?null:query.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> query = jdbcTemplate.query("select * from account where `name`=?", new BeanPropertyRowMapper<>(Account.class), name);
        return query.isEmpty()?null:query.get(0);
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update("update account set money=? where accountId=?",account.getMoney(),account.getAccountId());
    }
}
