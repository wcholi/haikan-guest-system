package com.haikan.manager.service;

import java.util.List;

import com.haikan.pojo.TbAdmin;

import entity.PageResult;

/**
 * 管理员服务层接口
 * @author Administrator
 *
 */
public interface AdminService {

	/**
	 * 查询全部
	 * @return
	 */
	public List<TbAdmin> findAll();
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	/**
	 * 增加管理员
	 * @param admin
	 */
	public void add(TbAdmin admin);
	
	/**
	 * 根据id查询管理员信息
	 * @param id
	 * @return
	 */
	public TbAdmin findOne(Long id);
	
	/**
	 * 修改管理员信息
	 * @param admin
	 */
	public void update(TbAdmin admin);
	
	/**
	 * 批量删除管理员
	 * @param ids
	 */
	public void delete(Long[] ids);
}
