package com.example.springfilter.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

//@Component
//@Order(1)
public class GlobalFilter
//        implements Filter
{
//
//    @Value("${jwt.header-name}")
//    private String HEADER_NAME;
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HashMap<String, String> mapRoleAndUri = new HashMap<>();
//
//        mapRoleAndUri.put("A", "/a");
//        mapRoleAndUri.put("B", "/b");
//        mapRoleAndUri.put("C", "/c");
//
//        HttpServletRequest hRequest = (HttpServletRequest) request;
//        HttpServletResponse hResponse = (HttpServletResponse) response;
//
//        String uri = hRequest.getRequestURI();
//        String headerValue = hRequest.getHeader(HEADER_NAME);
//
//        if(!headerValue.isEmpty()) {
//            String role = "";
//            String[] headerValueList = headerValue.split(",");
//
//            for (String value : headerValueList) {
//                if (value.contains("role")) {
//                    role = value.replace("role=", "");
//                }
//            }
//
//            if(mapRoleAndUri.containsKey(role)) {
//                if (mapRoleAndUri.get(role).equals(uri)) {
//                    chain.doFilter(request, response);
//                } else {
//                    hResponse.sendError(404 );
//                }
//            } else {
//                hResponse.sendError(404);
//            }
//        }
//    }
}
