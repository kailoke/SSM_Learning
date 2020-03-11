package A7_AOPAnnotation.service;

/**
 * 模拟User业务层接口
 */
public interface IUserService {
    // 无参无返回值
    void addUser(int i);
    // 有参无返回值
    void updateUser(int user);
    // 有返回值
    int deleteUser(int user);

    // 测试环绕通知
    void selectUser();
}
