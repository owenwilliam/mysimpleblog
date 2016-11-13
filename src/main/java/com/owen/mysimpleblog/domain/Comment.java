package com.owen.mysimpleblog.domain;

import java.util.Date;

/**
 * 文章评论
 * @author OwenWilliam
 * @Date 2016-11-12
 * @version v1.0.0
 *
 */
public class Comment
{

	//标识属性
	private Integer id;
	//发表评论的用法
	private String user;
	//发表评论的用户的E-mail
	private String email;
	//发表评论的用户的url
	private String url;
	//评论内容
	private String content;
	//评论添加时间
	private Date addTime;
	//评论关联的Blog
	private Blog blog;
	
	//无参数的构造数
	public Comment()
	{
	}
    
	//初始化全部成员变量的构造器
	public Comment(Integer id, String user, String email, String url,
			String content, Date addTime)
	{
		this.id = id;
		this.user = user;
		this.email = email;
		this.url = url;
		this.content = content;
		this.addTime = addTime;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public Blog getBlog()
	{
		return this.blog;
	}

	public void setBlog(Blog blog)
	{
		this.blog = blog;
	}
	
	
	
}
