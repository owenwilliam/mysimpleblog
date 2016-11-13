package com.owen.mysimpleblog.dao;

import java.util.List;

import com.owen.mysimpleblog.common.dao.BaseDao;
import com.owen.mysimpleblog.domain.Blog;

/**
 * Blog 接口
 * @author OwenWilliam
 * @Date 2016-11-12
 * @version v1.0.0
 *
 */
public interface BlogDao extends BaseDao<Blog>
{

	/**
	 * 查询定页的Blog
	 * @param pageNo 需要查询的页码
	 * @param pageSize 每页显示的Blog数
	 * @return 查询到的Blog集合
	 */
	List findAllByPage(int pageNo, int pageSize);
}
