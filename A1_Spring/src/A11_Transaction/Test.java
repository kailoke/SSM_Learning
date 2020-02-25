package A11_Transaction;

import A11_Transaction.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("a11_SpringTx.xml");
        AccountService accountService = ctx.getBean("accountService", AccountService.class);

        accountService.transfer("aaa","bbb",500.0);
    }
}
