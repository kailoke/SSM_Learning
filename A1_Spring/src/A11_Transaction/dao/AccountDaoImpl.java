package A11_Transaction.dao;

import A11_Transaction.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = getJdbcTemplate().query("select * from account where accountId=?", new BeanPropertyRowMapper<>(Account.class), accountId);
        return query.isEmpty()?null:query.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> query = getJdbcTemplate().query("select * from account where `name`=?", new BeanPropertyRowMapper<>(Account.class), name);
        return query.isEmpty()?null:query.get(0);
    }

    @Override
    public void update(Account account) {
        getJdbcTemplate().update("update account set money=? where accountId=?",account.getMoney(),account.getAccountId());
    }
}
