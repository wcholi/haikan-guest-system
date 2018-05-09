app.service('securityService',function($http){

	//分页查询
	this.findPage=function(pageNum,pageSize){
		return $http.get('../security/findPage.do?pageNum='+pageNum+'&pageSize='+pageSize);
	}
	
	//查询值班时间段列表
	this.selectTimeList=function(){
		return $http.get('../security/selectTimeList.do');
	}
	
	//增加报警对象信息
	this.add=function(entity){
		return $http.post('../security/add.do',entity);
	}
	
	//根据id查询报警对象信息
	this.findOne=function(id){
		return $http.get('../security/findOne.do?id='+id);
	}
	
	//修改报警对象信息
	this.update=function(entity){
		return $http.post('../security/update.do',entity);
	}
	
	//批量删除报警对象信息
	this.dele=function(ids){
		return $http.get('../security/delete.do?ids='+ids);
	}
	
});