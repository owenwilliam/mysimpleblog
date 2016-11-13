package com.owen.mysimpleblog.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 博客实体
 * @author OwenWilliam
 * @Date 2016-11-12
 * @version 1.0.0
 *
 */
public class Blog
{
	//标题属性
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //添加时间
    private Date addTime;
    
    //该Blog关联的全部评论
    private Set<Comment> comments = new HashSet<Comment>();
    
    //无参数的构造器
	public Blog()
	{
	}
    
	//初始化全部成员变量的构造器
	public Blog(Integer id, String title, String content, Date addTime)
	{
		this.id = id;
		this.title = title;
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

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
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

	public Set<Comment> getComments()
	{
		return this.comments;
	}

	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}
    
    
}
