package com.owen.mysimpleblog.exception;

/**
 * 错误处理
 * @author OwenWilliam
 * @Date 2016-11-13
 * @version 1.0.0
 *
 */
public class BlogException extends RuntimeException
{

	public BlogException()
	{
	}
	public BlogException(String msg)
	{
		super(msg);
	}
}
