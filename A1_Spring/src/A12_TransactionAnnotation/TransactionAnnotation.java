package A12_TransactionAnnotation;

import A12_TransactionAnnotation.config.SpringConfiguration;
import A12_TransactionAnnotation.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 一、xml开启事务注解  <tx:annotation-driven />
 *      > 通知类(方法） @Transactional(TxDefinition)
 *
 * 二、注解开启事务注解 @EnableTransactionManagement
 */

public class TransactionAnnotation {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ctx.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("aaa","bbb",500.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("exception captured");
    }
}
