app.service('visitorService',function($http){
	
	//分页查询
	this.findPage=function(pageNum,pageSize){
		return $http.get('../visitor/findPage.do?pageNum='+pageNum+"&pageSize="+pageSize);
	}
	
	//批量删除
	this.dele=function(ids){
		return $http.get('../visitor/delete.do?ids='+ids);
	}
});