package A11_TransactionAnnotation;

import A11_TransactionAnnotation.config.SpringConfiguration;
import A11_TransactionAnnotation.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 一、开启事务管理器
 * > 1. xml开启事务注解
 *  > <tx:annotation-driven #transaction-manager=default:"transactionManager"/>
 *
 * > 2. 注解开启事务注解
 *  > @EnableTransactionManagement
 *
 * 二、声明受事务管理
 * > @Transactional(TxDefinition..)
 *  > 声明为切入点方法
 *  > 声明为受事务管理器管理的目标类方法
 *  > 事务管理器会自动会此对象创建代理对象并返回
 *
 * 三、TransactionManager
 *  > 根据数据源选择
 */
public class TransactionAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ctx.getBean("accountService", AccountService.class);
        // getBean()得到代理类对象
        System.out.println("accountServiceClass:" + accountService.getClass().getName());

        try {
            accountService.transfer("aaa","bbb",500.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exception captured");
    }
}
