package A3_RequestParameters;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * SpringMVC可以映射ServletAPI至Handler方法的形参
 * > HttpServletRequest
 * > HttpServletResponse
 * > HttpSession
 *
 * > java.security.Principal
 * > Local 国际化
 *
 * > InputStream / OutputStream
 * > Reader / Writer
 */
@Controller
public class A3_ServletAPIAsParam {
    @RequestMapping("/ServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("MappingServletAPI\n" +
                "HttpServletRequest:" + request +
                "\nHttpServletResponse:" + response);
        out.write("Writer: hello ServletAPI");
    }
}
