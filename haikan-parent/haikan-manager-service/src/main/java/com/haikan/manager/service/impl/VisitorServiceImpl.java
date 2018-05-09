package com.haikan.manager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haikan.manager.service.VisitorService;
import com.haikan.mapper.TbVisitorMapper;
import com.haikan.pojo.TbVisitor;

import entity.PageResult;

/**
 * 访客信息服务层接口实现类
 * @author Administrator
 *
 */
@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private TbVisitorMapper tbVisitorMapper;
	
	/**
	 * 分页查询访客信息
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbVisitor> page = (Page<TbVisitor>) tbVisitorMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			tbVisitorMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 添加访客信息
	 */
	@Override
	public void save(String idCard) {
		TbVisitor visitor = tbVisitorMapper.selectByIdCard(idCard);
		if(visitor!=null){
			visitor.setTimes(visitor.getTimes()+1);
			visitor.setIdCard(idCard);
			tbVisitorMapper.updateByPrimaryKey(visitor);
		}else{
			TbVisitor v1 = new TbVisitor();
			v1.setIdCard(idCard);
			v1.setTimes(1);
			tbVisitorMapper.insert(v1);
		}		
	}
}
