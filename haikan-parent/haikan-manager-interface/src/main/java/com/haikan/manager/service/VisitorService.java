package com.haikan.manager.service;

import entity.PageResult;

/**
 * 访客服务层接口
 * @author Administrator
 *
 */
public interface VisitorService {

	/**
	 * 分页查询访客信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);
	
	/**
	 * 添加访客信息
	 * @param idCard
	 */
	public void save(String idCard);
}
