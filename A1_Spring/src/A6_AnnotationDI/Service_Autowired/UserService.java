package A6_AnnotationDI.Service_Autowired;

import A6_AnnotationDI.Domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User find(Long id);

    void add(User user);

    void update(Long id, User user);

    void delete(Long id);
}
