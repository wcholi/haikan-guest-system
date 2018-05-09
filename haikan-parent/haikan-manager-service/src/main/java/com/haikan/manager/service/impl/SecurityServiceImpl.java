package com.haikan.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haikan.manager.service.SecurityService;
import com.haikan.mapper.TbSecurityMapper;
import com.haikan.mapper.TbTimeMapper;
import com.haikan.pojo.TbSecurity;

import entity.PageResult;

/**
 * 报警对象服务层接口实现类
 * @author Administrator
 *
 */
@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private TbSecurityMapper tbSecurityMapper;
	@Autowired
	private TbTimeMapper tbTimeMapper;
	
	/**
	 * 分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbSecurity> page = (Page<TbSecurity>) tbSecurityMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 查询值班时间段列表
	 */
	@Override
	public List<Map> selectTimeList() {
		return tbTimeMapper.selectTimeList();
	}

	/**
	 * 添加报警对象信息
	 */
	@Override
	public void add(TbSecurity tbSecurity) {
		tbSecurityMapper.insert(tbSecurity);
	}

	/**
	 * 根据id查询报警对象信息
	 */
	@Override
	public TbSecurity findOne(Long id) {
		TbSecurity security = tbSecurityMapper.selectByPrimaryKey(id);
		return security;
	}

	/**
	 * 修改报警对象信息
	 */
	@Override
	public void update(TbSecurity tbSecurity) {
		tbSecurityMapper.updateByPrimaryKey(tbSecurity);
	}

	/**
	 * 批量删除报警对象信息
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			tbSecurityMapper.deleteByPrimaryKey(id);
		}
	}

}
