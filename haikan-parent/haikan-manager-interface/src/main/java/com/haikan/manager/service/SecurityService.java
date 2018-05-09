package com.haikan.manager.service;

import java.util.List;
import java.util.Map;

import com.haikan.pojo.TbSecurity;

import entity.PageResult;

/**
 * 报警对象服务层接口
 * @author Administrator
 *
 */
public interface SecurityService {

	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	/**
	 * 查询时间列表
	 * @return
	 */
	public List<Map> selectTimeList();
	
	/**
	 * 添加报警对象信息
	 * @param tbSecurity
	 */
	public void add(TbSecurity tbSecurity);
	
	/**
	 * 根据id查询报警对象信息
	 * @param id
	 * @return
	 */
	public TbSecurity findOne(Long id);
	
	/**
	 * 修改报警对象信息
	 * @param tbSecurity
	 */
	public void update(TbSecurity tbSecurity);
	
	/**
	 * 批量删除报警对象信息
	 * @param ids
	 */
	public void delete(Long[] ids);
}
