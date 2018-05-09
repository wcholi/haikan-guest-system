package com.haikan.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haikan.manager.service.SecurityService;
import com.haikan.pojo.TbSecurity;

import entity.PageResult;
import entity.Result;

/**
 * 报警对象控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

	@Reference
	private SecurityService securityService;
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum,int pageSize){
		PageResult page = securityService.findPage(pageNum, pageSize);
		return page;
	}
	
	/**
	 * 查询时间段列表
	 */
	@RequestMapping("/selectTimeList")
	public List<Map> selectTimeList(){
		return securityService.selectTimeList();
	}
	
	/**
	 * 添加报警对象信息
	 * @param tbSecurity
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbSecurity tbSecurity){
		try {
			securityService.add(tbSecurity);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}
	
	/**
	 * 根据id查询报警对象信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbSecurity findOne(Long id){
		TbSecurity security = securityService.findOne(id);
		return security;
	}
	
	/**
	 * 修改报警信息
	 * @param tbSecurity
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSecurity tbSecurity){
		try {
			securityService.update(tbSecurity);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		try {
			securityService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
}
