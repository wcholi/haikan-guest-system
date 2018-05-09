package com.haikan.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haikan.manager.service.AdminService;
import com.haikan.pojo.TbAdmin;

import entity.PageResult;
import entity.Result;

/**
 * 管理员控制层
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Reference
	private AdminService adminService;
	
	/**
	 * 查询所有管理员信息
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAdmin> findAll(){
		return adminService.findAll();
	}
	
	/**
	 * 分页查询管理员信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum,int pageSize){
		return adminService.findPage(pageNum, pageSize);
	}
	
	/**
	 * 增加管理员
	 * @param admin
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbAdmin admin){
		try {
			adminService.add(admin);
			return new Result(true,"添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"添加失败");
		}
	}
	
	/**
	 * 根据id查询管理员信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbAdmin findOne(Long id){
		return adminService.findOne(id);
	}
	
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbAdmin admin){
		try {
			adminService.update(admin);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	
	/**
	 * 批量删除管理员
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		try {
			adminService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
}
