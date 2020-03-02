package A5_POJO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/** 将多个请求参数封装至POJO中
 * 请求参数名需要和POJO属性名完全一致，Spring可直接映射请求参数至POJO对象
 */

@Controller
public class A1_Pojo {
    @RequestMapping("/POJO")
    public void pojo(User user, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("pojo user info:");
        System.out.println(user);

//        req.getRequestDispatcher("WEB-INF/views/success.jsp").forward(req,res);
        res.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
        res.getWriter().write("HandlerMethod 使用 Servlet参数");
    }
}
