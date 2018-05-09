package com.haikan.manager.service;

import com.haikan.pojo.TbMonitored;

import entity.PageResult;
import entity.Result;

/**
 * 受监控对象服务层接口
 * @author Administrator
 *
 */

public interface MonitoredService {

	/**
	 * 添加受监控对象信息
	 * @param tbMonitored
	 */
	public void add(TbMonitored tbMonitored);

	/**
	 * 分页查询
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	/**
	 * 根据id查询受监控对象信息
	 * @param id
	 */
	public TbMonitored findOne(Long id);
	
	/**
	 * 修改受监控对象信息
	 * @param tbMonitored
	 * @return
	 */
	public void update(TbMonitored tbMonitored);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);
}
