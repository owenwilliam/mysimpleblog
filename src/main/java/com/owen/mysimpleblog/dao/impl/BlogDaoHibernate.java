package com.owen.mysimpleblog.dao.impl;

import java.util.List;

import com.owen.mysimpleblog.common.dao.impl.BaseDaoHibernate;
import com.owen.mysimpleblog.dao.BlogDao;
import com.owen.mysimpleblog.domain.Blog;

/**
 * 博客接口实现
 * @author OwenWilliam
 * @Date 2016-11-12
 * @version v1.0.0
 *
 */
public class BlogDaoHibernate extends BaseDaoHibernate<Blog> implements BlogDao
{
	/**
	 * 查询指定页的Blog
	 * @param pageNo 需要查询的页码
	 * @return 查询到的Blog集合
	 */
	public List findAllByPage(int pageNo , int pageSize)
	{
		//返回分页查询的结果
		return findByPage("select b from Blog b order by b.id desc"
			, pageNo , pageSize);
	}
}