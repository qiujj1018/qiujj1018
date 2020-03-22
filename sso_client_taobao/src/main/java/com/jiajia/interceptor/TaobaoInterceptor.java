package com.jiajia.interceptor;

import com.jiajia.utils.SSOClientUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TaobaoInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //1.判断是否已经登录
        HttpSession session = request.getSession();
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        if (isLogin!=null && isLogin){
            return true;
        }

        //2.判断token
        String token = request.getParameter("token");
        if(!StringUtils.isEmpty(token)){
            //验证token是否正确
        }

        //3.跳转到认证中心进行登录
        SSOClientUtil.redirectToCheckToken(request,response);
        return false;
    }
}
