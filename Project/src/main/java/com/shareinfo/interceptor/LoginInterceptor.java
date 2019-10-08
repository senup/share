package com.shareinfo.interceptor;

import com.shareinfo.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zxx
 * @date 2019/7/10 10:27
 * @作用 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    /**
     * 表示该方法会在控制器方法前执行，若其返回值为true表示继续向下执行
     * 若为false直接终止操作
     * */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //获取请求的URL
        String url = httpServletRequest.getRequestURI();
        if (url.indexOf("/login") >= 0) {
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        // 判断Session中是否有用户数据 如果有返回true 继续向下执行 否则终止操作
        if (user != null) {
            return true;
        }

        return false;
    }

    @Override
    /**
     * 该方法会在控制器方法调用之后，且在解析视图之前执行
     * 可通过此方法对请求域中的模型和视图做出进一步的修改
     * */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    /**
     * 该方法会在整个请求完成，即视图渲染结束之后执行
     * 可以通过此方法实现一些资源的处理、记录日志信息等工作
     * */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
