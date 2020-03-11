package A7_AOPAnnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *  Spring配置类
 */
@Configuration
@ComponentScan("A7_AOPAnnotation")
@EnableAspectJAutoProxy
public class SpringConfig {
}
