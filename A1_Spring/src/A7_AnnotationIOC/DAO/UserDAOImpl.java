package A7_AnnotationIOC.DAO;

import A7_AnnotationIOC.Domain.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl extends Dao<User> implements UserDAO {

    @Override
    public User queryUser(Long id) {
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user = query(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> queryUsers() {
        String sql = "select * from user";
        List<User> list = new ArrayList<>();
        try {
            list = queryList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user(id,name,age,gender,tel) values(?,?,?,?,?)";
        try {
            update(sql, user.getId(), user.getName(), user.getAge(), user.getGender(), user.getTel());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(Long id, User user) {
        String sql = "update user set id=?,name=?,age=?,gender=?,tel=? where id=?";
        try {
            update(sql, user.getId(), user.getName(), user.getAge(), user.getGender(), user.getTel(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "delete from user where id = ?";
        try {
            update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
