package com.owen.mysimpleblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.owen.mysimpleblog.dao.BlogDao;
import com.owen.mysimpleblog.dao.CommentsDao;
import com.owen.mysimpleblog.domain.Blog;
import com.owen.mysimpleblog.domain.Comment;
import com.owen.mysimpleblog.exception.BlogException;
import com.owen.mysimpleblog.service.BlogService;
import com.owen.mysimpleblog.vo.BlogBean;
import com.owen.mysimpleblog.vo.CommentsBean;

/**
 * Blog组件接口的实现
 * @author OwenWilliam
 * @Date 2016-11-13
 * @version 1.0.0
 *
 */
public class BlogServiceImpl implements BlogService
{

	private BlogDao blogDao;
	private CommentsDao commentDao;

	// 依赖注入业务逻辑组件所必须的setter方法
	public void setBlogDao(BlogDao blogDao)
	{
		this.blogDao = blogDao;
	}
	public void setCommentDao(CommentsDao commentDao)
	{
		this.commentDao = commentDao;
	}

	/**
	 * 创建一篇新的Blog
	 * @param title Blog的标题
	 * @param content Blog的内容
	 * @return 新创建Blog的主键,如果创建失败，返回-1。
	 */
	public int createBlog(String title , String content)
	{
		try
		{
			Blog b = new Blog();
			b.setTitle(title);
			b.setContent(content);
			b.setAddTime(new Date());
			blogDao.save(b);
			return b.getId();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("保存Blog文章出错");
		}
	}

	/**
	 * 创建一个评论
	 * @param user 发表评论的用户
	 * @param email 发表评论用户的的Email
	 * @param url 发表评论用户的的url
	 * @param content 发表评论的内容
	 * param blogId 发表评论所对应的Blog Id
	 * @return 新发表评论的主键
	 */
	public int createComment(String user, String email, String url
		, String content, int blogId)
	{
		Blog b = blogDao.get(Blog.class , blogId);
		if (b == null)
		{
			return -1;
		}
		try
		{
			Comment c = new Comment();
			c.setUser(user);
			c.setEmail(email);
			c.setUrl(url);
			c.setContent(content);
			c.setAddTime(new Date());
			c.setBlog(b);
			commentDao.save(c);
			return c.getId();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("保存文章评论出错");
		}
	}

	/**
	 * 返回指定页的Blog列表
	 * @param pageNo 指定页面
	 * @param pageSize 每页显示的Blog数量
	 * @return 指定页的Blog列表
	 */
	@SuppressWarnings("rawtypes")
	public List<BlogBean> getAllBlogByPage(int pageNo , int pageSize)
	{
		List<BlogBean> result = new ArrayList<BlogBean>();
		try
		{
			List bl = blogDao.findAllByPage(pageNo , pageSize);
			for (Object o : bl)
			{
				Blog b = (Blog)o;
				result.add(new BlogBean(b.getId() ,
					b.getTitle() , null , null));
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("获取文章标题列表出错");
		}
	}
	/**
	 * 返回Blog文章的总数
	 * @return Blog文章的总数
	 */
	public long getBlogCount()
	{
		try
		{
			return blogDao.findCount(Blog.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("获取Blog文章总数出错");
		}
	}

	/**
	 * 返回指定Blog,指定页所对应的评论
	 * @param blogId 指定Blog的ID
	 * @param pageNo 指定页面
	 * @param pageSize 每页显示的评论数
	 * @return 指定Blog，指定页码的所有评论
	 */
	public List<CommentsBean> getCommentsByBlogAndPage(int blogId
		, int pageNo , int pageSize)
	{
		try
		{
			List<Comment> cl = commentDao.findByBlogAndPage(blogId , pageNo
				, pageSize);
			List<CommentsBean> result = new ArrayList<CommentsBean>();
			for (Comment c : cl)
			{
				result.add(new CommentsBean(c.getUser() , c.getEmail() ,
					c.getUrl() , c.getContent() , c.getAddTime()));
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("获取文章评论列表出错");
		}
	}

	public long getCommentCountByBlog(int blogId)
	{
		try
		{
			return commentDao.findCountByBlog(blogId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("根据Blog文章获取评论总数出错");
		}
	}


	/**
	 * 返回指定Blog文章
	 * @param blogId 需要查询的Blog文章的id
	 * @return blogId对应的Blog文章
	 */
	public BlogBean getBlog(int blogId)
	{
		try
		{
			Blog b = blogDao.get(Blog.class , blogId);
			return new BlogBean(b.getId() , b.getTitle() ,
				b.getContent() ,  b.getAddTime());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new BlogException("获取指定Blog文章出错");
		}
	}
}
