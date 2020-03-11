package A8_AOPXml.service;

/**
 * 模拟User业务层接口
 */
public interface IUserService {
    // 无参无返回值
    void addUser();
    // 有参无返回值
    void updateUser(int i);
    // 有返回值
    int deleteUser();
}
