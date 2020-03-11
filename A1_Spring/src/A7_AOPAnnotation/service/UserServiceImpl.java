package A7_AOPAnnotation.service;

import org.springframework.stereotype.Service;

/**
 * 模拟User业务层的实现类
 */
@Service()
public class UserServiceImpl implements IUserService {

    @Override
    public void addUser(int user) {
        System.out.println("添加用户的方法");
    }

    @Override
    public void updateUser(int user) {
        System.out.println("更新用户的方法，下一帧发生异常");
        // 测试异常通知
        int i = 1 / 0;
    }

    @Override
    public int deleteUser(int user) {
        System.out.println("删除客户的方法");
        return 5;
    }

    @Override
    public void selectUser() {
        System.out.println("查询客户的方法");
    }
}
