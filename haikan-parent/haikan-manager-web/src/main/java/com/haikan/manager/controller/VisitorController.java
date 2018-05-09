package com.haikan.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haikan.manager.service.VisitorService;

import entity.PageResult;
import entity.Result;

/**
 * 访客信息控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/visitor")
public class VisitorController {

	@Reference
	private VisitorService visitorService;
	
	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum,int pageSize){
		PageResult result = visitorService.findPage(pageNum, pageSize);
		return result;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		
		try {
			visitorService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
	
	/**
	 * 保存访客信息
	 * @param idCard
	 */
	@RequestMapping("/save")
	public void save(String idCard){
		visitorService.save(idCard);
	}
}
