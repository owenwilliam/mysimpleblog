package com.owen.mysimpleblog.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;

import org.json.JSONObject;
import org.springframework.web.context.support.*;
import org.springframework.context.*;

import com.owen.mysimpleblog.service.BlogService;
/**
 * 添加博客
 * @author OwenWilliam
 * @Date 2016-11-13
 * @version 1.0.0
 *
 */
@WebServlet(urlPatterns="/addBlog")
public class AddBlogServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// 获取请求参数
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Map<String , Object> result = new HashMap<>();
		// 获取Spring容器
		ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
		BlogService bs = (BlogService)ctx.getBean("blogService");
		// 调用业务逻辑组件的方法来添加评论
		int blogId = bs.createBlog(title, content);
		result.put("success", true);
		if(blogId > 0)
			result.put("msg" ,  "恭喜您，新文章发表成功！");
		else
			result.put("msg" ,  "对不起，新文章发表失败！");
		// 准备输出服务器响应
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}