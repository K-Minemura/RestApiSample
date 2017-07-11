package jp.gr.java_conf.kmine27.spring.jiro.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RestErrorController implements ErrorController {

    @Autowired
    ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public Map<String, Object> error(HttpServletRequest request, HttpServletResponse response) {
        // エラー情報を取得する
        ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(servletRequestAttributes, false);
        return attributes;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}