package A7_AnnotationIOC.Service;

import A7_AnnotationIOC.Domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User find(Long id);

    void add(User user);

    void update(Long id, User user);

    void delete(Long id);
}
