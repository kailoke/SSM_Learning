package A11_TransactionAnnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring注解配置类
 */
@Configuration
@ComponentScan("A11_TransactionAnnotation")
@Import({JdbcConfiguration.class,TransactionManager.class})
@EnableTransactionManagement
public class SpringConfiguration {

}
