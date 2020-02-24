package A7_AnnotationIOC.config;

import org.springframework.context.annotation.*;

/**
 * > @ComponentScan：指定注解扫描的base-packages
 * > @Configuration：将修饰类作为Spring的配置类
 * > @Import: 导入类字节码，一同被解析
 */

@Import(JdbcConfig.class)
@Configuration
@ComponentScan("A7_AnnotationIOC")
public class SpringConfig {

}
