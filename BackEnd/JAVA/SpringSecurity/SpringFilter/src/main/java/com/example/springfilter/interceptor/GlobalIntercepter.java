package com.example.springfilter.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class GlobalIntercepter implements HandlerInterceptor {

    private String HEADER_NAME = "xing";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HashMap<String, String> mapRoleAndUri = new HashMap<>();

        mapRoleAndUri.put("A", "/a");
        mapRoleAndUri.put("B", "/b");
        mapRoleAndUri.put("C", "/c");

        String uri = request.getRequestURI();
        System.out.println(uri);
        System.out.println(HEADER_NAME);
        String headerValue = request.getHeader(HEADER_NAME);
        System.out.println(headerValue);

        if(headerValue != null) {
            String role = "";
            String[] headerValueList = headerValue.split(",");

            for (String value : headerValueList) {
                if (value.contains("role")) {
                    role = value.replace("role=", "");
                    System.out.println(role);
                }
            }

            if(mapRoleAndUri.containsKey(role)) {
                if (mapRoleAndUri.get(role).equals(uri)) {
                    return true;
                } else {
                    response.setStatus(404);
                    return false;
                }
            } else {
                response.sendRedirect("/boards");
                return false;
            }
        } else {
            response.sendRedirect("/boards");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
