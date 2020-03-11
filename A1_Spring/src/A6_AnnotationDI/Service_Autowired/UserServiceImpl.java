package A6_AnnotationDI.Service_Autowired;

import A6_AnnotationDI.DAO.UserDAO;
import A6_AnnotationDI.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/** >@Autowired
 * 1.根据byType实现自动装配，若IOC中存在多个类型匹配的兼容Bean，则尝试byName匹配
 *   * 可通过 @Qualifier注入byName的BeanId
 * 2.构造器、普通字段(忽略权限)、一切具有参数的方法(setter)都可以应用@Autowired
 * 3.默认情况下，所有@Autowired注解的属性都需要被注入，若Spring匹配不到对应的Bean装配则抛出fatal exception
 *   * @Autowired#required=false，可允许该属性不被设置
 * 4.可应用在数组类型的属性上，Spring会将所有匹配的数组Bean进行自动装配
 * 5.可应用在集合类型的属性上，Spring读取集合信息并且自动装配所有与之兼容的Bean
 * 6.可应用在Map类型的属性上，若Map键为String则Spring将自动装配与值类型兼容的Bean，并以BeanId作为键
 */
@Service
@Scope
public class UserServiceImpl implements UserService {
//    @Resource(name = "userDAOImpl")
    @Autowired
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
