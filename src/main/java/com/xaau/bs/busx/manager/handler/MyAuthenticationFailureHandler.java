package com.xaau.bs.busx.manager.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:
 * 
 * @author Mr.Tsang
 * @date 2019/4/13
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        if ("Bad credentials".equals(exception.getMessage())){
            redirectStrategy.sendRedirect(request, response, "/login?error=user");
        }else if ("验证码不能为空！".equals(exception.getMessage())
                ||"验证码不存在！".equals(exception.getMessage())
                ||"验证码已过期！".equals(exception.getMessage())
                ||"验证码不正确！".equals(exception.getMessage())){
            redirectStrategy.sendRedirect(request, response, "/login?error=code");
        }else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(mapper.writeValueAsString(exception.getMessage()));
        }
    }
}
