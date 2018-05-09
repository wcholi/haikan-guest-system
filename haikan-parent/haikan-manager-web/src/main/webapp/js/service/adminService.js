//管理员服务层
app.service('adminService',function($http){
	this.findAll=function(){
		return $http.get('../admin/findAll.do');
	}
	
	//分页查询
	this.findPage=function(pageNum,pageSize){
		return $http.get('../admin/findPage.do?pageNum='+pageNum+'&pageSize='+pageSize);
	}
	
	//增加管理员
	this.add=function(entity){
		return $http.post('../admin/add.do',entity);
	}
	
	//修改管理员
	this.update=function(entity){
		return $http.post('../admin/update.do',entity);
	}
	
	//根据id查询管理员信息
	this.findOne=function(id){
		return $http.get('../admin/findOne.do?id='+id);
	}
	
	//批量删除管理员信息
	this.dele=function(ids){
		return $http.get('../admin/delete.do?ids='+ids);
	}
	
});