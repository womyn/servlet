package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class HelloServlet extends HttpServlet {


    //由于get
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //要获取下载文件的路径
        String realPath = this.getServletContext().getRealPath("/1/png");
        System.out.println("下载路径为" + realPath);
        //下载的文件名字
        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //设置想办法让浏览器能够支持我们下载需要的东西，中文文件名URLEncoding
        resp.setHeader("Content-Disposition", "attachment;filename" + URLEncoder.encode(filename,"UTF-8"));
       //获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //  创建缓冲区
        int len = 0;
        byte[] buffer = new byte[2014];
      //获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
      //将FileOutputStream流写入到缓冲区
        while (in.read(buffer) > 0) {
            out.write(buffer, 0, len);
        }
     //使用OutputStream将缓冲区中的数据输出到客户端
        in.close();
        out.close();
    }

}
