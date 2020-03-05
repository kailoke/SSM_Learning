package A8_Json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/** Spring自动集成了 jackson
 *  > @ResponseBody 将方法的返回值转化成json字符串
 *
 * 一、核心接口 HttpMessageConverter<T>
 * > 作用：数据转换
 *  > 1. 将请求信息转换为一个对象<T>  HttpInputMessage请求报文
 *  > 2. 将对象<T>输出为响应信息         HttpOutputMessage响应报文
 * 二、由RequestMappingHandlerAdapter默认装配HMS_6个实现类对象
 *  > 若有Jackson.jar则额外装配jackson_converter
 *
 * 三、需要 <mvc:annotation-driven> 支持
 */

@Controller
public class A1_Jackson {

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
