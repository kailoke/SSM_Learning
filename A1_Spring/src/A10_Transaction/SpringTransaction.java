package A10_Transaction;

import A10_Transaction.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 声明式事务，基于AOP
 * 一、顶级接口
 *  > AbstractPlatformTransactionManager 平台事务管理器接口，规范操作事务的方法
 *      > commit() \ rollback()
 *      > 提供不同数据源的实现子类，!!管理不同的数据源!!
 *
 *  > TransactionDefinition 连接的事务属性(连接属性 或 某个切入点连接属性)
 *      > Isolation: default read_uncommitted read_committed repeatable_read serializable
 *      > PropagationBehavior: 一个事务方法被另一个事务方法调用时，当前方法如何使用事务
 *          > required      默认值，使用调用者的事务，若调用者无事务则为自身`新建`事务
 *          > Required_New  为自身`新建`事务，将调用者事务挂起(自身事务结束后，继续调用者事务)
 *          > support       自身支持调用者的事务(有则使用，无则不使用)
 *          > mandatory     强制自身支持调用者的事务(有则使用，无则抛出异常)
 *      > rollBackFor || rollBackForClassName : 当出现指定异常后才回滚
 *      > noRollBackFor || noRollBackForClassName : 出现指定异常后不回滚
 *      > readOnly : 事务只读
 *      > timeout: 超时时间，默认-1不超时
 *  > TransactionStatus
 *      > flush() 刷新事务
 *      > hasSavePoint() 是否有回滚点
 *      > isRollbackOnly() \ setRollBackOnly() 测试SQL语句，但不对数据库进行提交
 *
 * 二、Spring事务配置流程
 *  > 1.管理器Bean，根据数据源选择。jbdc数据源为：DataSourceTransactionManager
 *  > 2.事务通知：<tx:advice --> tx:attribute (definition) --> tx:method
 *      > 通知方法commit\rollback的通知类型由Spring管理
 *      > 用户配置切入点方法method，及其事务属性Definition
 *  > 3.aop事务切面：<aop:config --> aop:pointcut && aop:advisor(advice-ref = 通知)
 *
 * 三、原理：
 *  > 事务管理器doBegin()从连接池中获取连接并且改变连接属性，将设置后的连接传递执行SQl语句
 *  > 使用AOP思想的事务的关键点 completed\exception时进行commit\rollback
 */
public class SpringTransaction {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("A10_Transaction/SpringTx.xml");
        AccountService accountService = ctx.getBean("accountService", AccountService.class);

        accountService.transfer("aaa","bbb",500.0);
    }
}
