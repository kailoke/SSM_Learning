package A7_AnnotationIOC.Service;

import A7_AnnotationIOC.DAO.UserDAO;
import A7_AnnotationIOC.Domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource(name = "userDAOImpl")
    private UserDAO userDao;

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.queryUsers();
    }

    @Override
    public User find(Long id) {
        return userDao.queryUser(id);
    }

    @Override
    public void add(User user) {
        userDao.addUser(user);
    }

    @Override
    public void update(Long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteUser(id);
    }
}
