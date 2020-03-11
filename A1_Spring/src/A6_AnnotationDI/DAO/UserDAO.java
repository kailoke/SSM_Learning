package A6_AnnotationDI.DAO;

import A6_AnnotationDI.Domain.User;

import java.util.List;

public interface UserDAO {
    User queryUser(Long id);

    List<User> queryUsers();

    void addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
