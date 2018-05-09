package com.haikan.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haikan.manager.service.MonitoredService;
import com.haikan.mapper.TbMonitoredMapper;
import com.haikan.pojo.TbMonitored;

import entity.PageResult;
import entity.Result;

/**
 * 受监控对象服务层接口实现类
 * @author Administrator
 *
 */
@Service
public class MonitoredServiceImpl implements MonitoredService {

	@Autowired
	private TbMonitoredMapper monitoredMapper;
	
	/**
	 * 添加受监控对象信息
	 */
	@Override
	public void add(TbMonitored tbMonitored) {
		monitoredMapper.insert(tbMonitored);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbMonitored> page = (Page<TbMonitored>) monitoredMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 根据id查询受监控对象信息
	 */
	@Override
	public TbMonitored findOne(Long id) {
		TbMonitored monitored = monitoredMapper.selectByPrimaryKey(id);
		return monitored;
	}

	/**
	 * 修改受监控对象信息
	 */
	@Override
	public void update(TbMonitored tbMonitored) {
		monitoredMapper.updateByPrimaryKey(tbMonitored);		
	}

	/**
	 * 批量删除受监控对象信息
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			monitoredMapper.deleteByPrimaryKey(id);
		}
	}

}
