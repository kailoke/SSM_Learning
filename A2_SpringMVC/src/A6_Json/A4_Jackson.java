package A6_Json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/** Spring集成了 Jackson
 * 一、使用方式：@ResponseBody 将方法的返回值(对象)转化成json字符串
 *
 * 二、HttpMessageConverter<T>接口
 *  > 1. 将请求信息转换为一个对象<T>  HttpInputMessage
 *    请求报文 --> HttpInputMessage --> HttpMessageConverter --> SpringMVC
 *  > 2. 将对象<T>输出为响应信息      HttpOutputMessage
 *    SpringMVC --> HttpMessageConverter --> HttpOutputMessage --> 响应报文
 *
 * 二、由RequestMappingHandlerAdapter默认装配HMS_6个实现类对象
 *  > 若有Jackson.jar则额外装配jackson_converter
 *
 * 三、supports need
 *  > jackson-core jackson-databind jackson-annotation
 *  > <mvc:annotation-driven>
 */
@Controller
public class A4_Jackson {

    /**
     * 返回 json数据
     * @return 返回对象
     */
    @ResponseBody
    @RequestMapping(path = "JacksonTest")
    public Collection<User> jsonTest() {
        Collection<User> users = UserDao.getUsers();
        return users;
    }
}
