app.service('monitoredService',function($http){
	
	this.add=function(imageUrl){
		return $http.get('../monitored/add.do?imageUrl='+imageUrl);
	}
	
	this.update=function(entity){
		return $http.post('../monitored/update.do',entity);
	}
	
	//分页查询
	this.findPage=function(pageNum,pageSize){
		return $http.get('../monitored/findPage.do?pageNum='+pageNum+'&pageSize='+pageSize);
	}
	
	//根据id查询监控信息
	this.findOne=function(id){
		return $http.get('../monitored/findOne.do?id='+id);
	}
	
	//批量删除
	this.dele=function(ids){
		return $http.get('../monitored/delete.do?ids='+ids);
	}
});