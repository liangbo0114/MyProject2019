package com.lb.service;

import com.alibaba.fastjson.JSON;
import com.lb.entity.CityEntity;
import com.lb.util.QueryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;

/**
 * @ Author     ：LB.
 * @ Date       ：Created in 2019/2/21
 * @ Description：
 * @ Modified By：
 */
@WebServlet(name = "queryServlet",value = "/queryServlet")
public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("====do get ====");
            resp.setCharacterEncoding("utf-8");
            String pid = req.getParameter("id");
            if(pid == null || "".equals(pid)){
                pid = "0";
            }
            System.out.println("pid:" + pid);
            List<CityEntity> cityEntityList = QueryUtil.queryCityEntity(Integer.parseInt(pid));
            String json = JSON.toJSONString(cityEntityList);
            PrintWriter printWriter = resp.getWriter();
            printWriter.println(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
