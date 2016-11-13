package com.owen.mysimpleblog.dao;

import java.util.List;

import com.owen.mysimpleblog.common.dao.BaseDao;
import com.owen.mysimpleblog.domain.Comment;

/**
 * 评论接口
 * @author OwenWilliam
 * @Date 2016-11-12
 * @version v1.0.0
 *
 */
public interface CommentsDao extends BaseDao<Comment>
{

	/**
	 * 根据Blog、和页码来查找评论
	 * @param b 评论所对应Blog文章的ID
	 * @param pageNo 查找指定页的Blog
	 * @param pageSize 每页显示的评论数量
	 * @return 查找到的评论集合
	 */
	List<Comment> findByBlogAndPage(int blogId , int pageNo , int pageSize);

	/**
	 * 根据Blog文件来获取它关联的评论总数
	 * @param blogId 指定Blog文章的ID
	 * @return 指定Blog文章所关联的评论的总数
	 */
	long findCountByBlog(int blogId);
}
