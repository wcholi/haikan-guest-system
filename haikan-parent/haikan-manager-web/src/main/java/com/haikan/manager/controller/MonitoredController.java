package com.haikan.manager.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haikan.manager.service.MonitoredService;
import com.haikan.pojo.TbMonitored;

import entity.PageResult;
import entity.Result;

/**
 * 受监控对象信息控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/monitored")
public class MonitoredController {

	@Reference
	private MonitoredService monitoredService;
	
	/**
	 * 添加受监控对象信息
	 * @param imageUrl
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(String imageUrl){
		try {
			TbMonitored monitored = new TbMonitored();
			monitored.setImage(imageUrl);
			monitoredService.add(monitored);
			return new Result(true,"添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"添加失败");
		}
	}
	
	/**
	 * 分页查询受监控对象信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum,int pageSize){
		PageResult result = monitoredService.findPage(pageNum, pageSize);
		return result;
	}
	
	/**
	 * 根据id查询受监控对象信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbMonitored findOne(Long id){
		return monitoredService.findOne(id);
	}
	
	/**
	 * 修改受监控对象信息
	 * @param monitored
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbMonitored monitored){
		try {
			monitoredService.update(monitored);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		try {
			monitoredService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
}
