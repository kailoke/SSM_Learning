package A9_AOPAnnotation.service;

import org.springframework.stereotype.Service;

/**
 * 模拟User业务层的实现类
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Override
    public void addUser() {
        System.out.println("添加了用户");
    }

    @Override
    public void updateUser(int i) {
        System.out.println("更新了客户" + i);
    }

    @Override
    public int deleteUser() {
        System.out.println("删除客户");
        return 0;
    }
}
