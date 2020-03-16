package A3_RequestParameters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** POJO封装请求体数据
 * > Spring可直接映射请求参数至POJO对象
 *  > SpringMVC 会按请求参数名和 POJO 属性名进行自动匹配，自动为该对象填充属性值
 *      支持级联属性，但级联类 modifiers 必须= public
 *  > 请求参数名需要和POJO属性名完全一致(POJO基本)
 *
 * 二、使用：处理方法形参中直接声明POJO对象
 */

@Controller
public class A2_Pojo {
    @RequestMapping("/POJO")
    public void pojo(User user, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("pojo user info:");
        System.out.println(user);

//        req.getRequestDispatcher("WEB-INF/views/success.jsp").forward(req,res);
        res.getWriter().write("HandlerMethod 使用 Servlet参数");
    }
}

// POJO封装类
class User {
    private String username;
    private String password;
    private String email;
    private String gender;
    private Address addr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", addr=" + addr +
                '}';
    }
}
