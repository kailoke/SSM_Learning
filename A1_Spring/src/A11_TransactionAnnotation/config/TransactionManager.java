package A11_TransactionAnnotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * TransactionManager配置类
 */
public class TransactionManager {
    @Bean(name = "transactionManager")
    public PlatformTransactionManager creatTransactionManager(DataSource  dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
