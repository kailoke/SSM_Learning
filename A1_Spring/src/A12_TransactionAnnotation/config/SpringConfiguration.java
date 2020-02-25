package A12_TransactionAnnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan("A12_TransactionAnnotation")
@Import({JdbcConfiguration.class,TransactionManager.class})
@EnableTransactionManagement
public class SpringConfiguration {

}