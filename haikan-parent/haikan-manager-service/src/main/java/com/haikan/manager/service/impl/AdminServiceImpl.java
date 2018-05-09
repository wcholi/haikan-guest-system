package com.haikan.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haikan.manager.service.AdminService;
import com.haikan.mapper.TbAdminMapper;
import com.haikan.pojo.TbAdmin;

import entity.PageResult;

/**
 * 管理员服务层实现类
 * @author Administrator
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TbAdminMapper tbAdminMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbAdmin> findAll() {
		List<TbAdmin> list = tbAdminMapper.selectByExample(null);
		return list;
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbAdmin> page = (Page<TbAdmin>) tbAdminMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加管理员
	 */
	@Override
	public void add(TbAdmin admin) {
		tbAdminMapper.insert(admin);
	}

	/**
	 * 根据id查询管理员信息
	 */
	@Override
	public TbAdmin findOne(Long id) {
		TbAdmin admin = tbAdminMapper.selectByPrimaryKey(id);
		return admin;
	}

	/**
	 * 修改管理员信息
	 */
	@Override
	public void update(TbAdmin admin) {
		tbAdminMapper.updateByPrimaryKey(admin);
	}

	/**
	 * 批量删除管理员信息
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			tbAdminMapper.deleteByPrimaryKey(id);
		}
	}

}
