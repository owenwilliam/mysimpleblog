package com.owen.mysimpleblog.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.owen.mysimpleblog.service.BlogService;

/**
 * 获取所有的博客
 * @author OwenWilliam
 * @Date 2016-11-13
 * @version 1.0.0
 *
 */
@WebServlet(urlPatterns="/getAllBlogsByPage")
public class GetAllBlogsByPageServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// 获取分页的请求参数
		String start = request.getParameter("start");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		Map<String , Object> result = new HashMap<>();
		// 获取Spring容器
		ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
		BlogService bs = (BlogService)ctx.getBean("blogService");
		// 调用业务逻辑组件的方法，获取数据，并设置成data属性
		result.put("data" , bs.getAllBlogByPage(Integer.parseInt(page)
			, Integer.parseInt(limit)));
		result.put("total" , bs.getBlogCount());
		// 准备输出服务器响应
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}