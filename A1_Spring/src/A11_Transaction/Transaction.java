package A11_Transaction;

import A11_Transaction.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 声明式事务，基于AOP
 * 一、顶级接口
 *  > PlatformTransactionManager 平台事务管理器(通知类)，提供操作事务的方法
 *      > commit() \ rollback()
 *      > 提供不同数据源的实现类，管理数据源的Connection
 *  > TransactionDefinition 连接的事务属性(针对方法)
 *      > Isolation: default read_uncommitted read_committed repeatable_read serializable
 *      > PropagationBehavior: 事务的传播行为
 *          > required  (自动创建事务)
 *          > support   (事务随意)
 *          > mandatory (强制)无事务则抛出异常
 *      > readOnly
 *      > timeout: 超时时间，默认-1不超时
 *  > TransactionStatus
 *      > flush() 刷新事务
 *      > hasSavePoint() 是否有回滚点
 *      > isRollbackOnly() \ setRollBackOnly() 测试SQL语句，但不对数据库进行提交
 *
 * 二、Spring事务配置流程
 *  > 通知类：TransactionManager
 *  > 事务通知(切面)：<tx:advice --> tx:attribute (definition) --> tx:method
 *      > 通知方法commit\rollback的通知类型由Spring管理
 *      > 用户配置切入点方法method，及其事务属性Definition
 *  > aop通知器:<aop:config --> aop:pointcut && aop:advisor(advice-ref = 通知)
 *
 * 三、作用：
 *  > doBegin从连接池中获取连接并且改变连接属性，将设置后的连接传递执行SQl语句
 *  > 使用AOP思想的事务的关键点 completed\exception时进行commit\rollback
 */

public class Transaction {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A11_Transaction/a11_SpringTx.xml");
        AccountService accountService = ctx.getBean("accountService", AccountService.class);

        accountService.transfer("aaa","bbb",500.0);
    }
}
