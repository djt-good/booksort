package com.wz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@WebServlet("/three")
public class threeServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("一对多的参数接受");
        String[] likes = request.getParameterValues("name");
        System.out.println(likes);
        System.out.println(Arrays.toString(likes));
        Arrays.stream(likes).forEach(System.out::print);

        System.out.println("获取所有的请求参数和参数值");
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        Set<String> keys = parameterMap.keySet();
        System.out.println(keys);
        Collection<String[]> values = parameterMap.values();
        for (String []arr :values){
            System.out.println(Arrays.toString(arr));
        }
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String,String[]> entry :entries){
            System.out.println(entry.getKey()+"---"+Arrays.toString(entry.getValue()));
        }
        request.getRequestDispatcher("/").forward(request,response);
    }
}
