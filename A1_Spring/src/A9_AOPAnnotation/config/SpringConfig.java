package A9_AOPAnnotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *  Spring配置类
 */
@Configuration
@ComponentScan("A9_AOPAnnotation")
@EnableAspectJAutoProxy
public class SpringConfig {
}
