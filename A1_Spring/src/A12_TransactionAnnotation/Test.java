package A12_TransactionAnnotation;

import A12_TransactionAnnotation.config.SpringConfiguration;
import A12_TransactionAnnotation.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ctx.getBean("accountService", AccountService.class);

        accountService.transfer("aaa","bbb",500.0);
    }
}
