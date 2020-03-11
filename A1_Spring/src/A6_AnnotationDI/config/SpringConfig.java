package A6_AnnotationDI.config;

import org.springframework.context.annotation.*;

/**
 * 三、@ComponentScan：注解开启组件扫描，配置base-packages
 *
 * 四、@Configuration：将修饰类作为Spring的配置类，更改ClassPathXmlApplicationContext(String,Class)的根路径
 *
 * 五、@Import: 导入其他配置类的字节码，其他配置类不需要注明@Configuration
 *              > 可能是运行时动态加载字节码
 */
@Import(JdbcConfig.class)
@Configuration
@ComponentScan("A6_AnnotationDI")
public class SpringConfig {

}
