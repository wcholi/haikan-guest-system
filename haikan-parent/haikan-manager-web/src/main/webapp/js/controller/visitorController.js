app.controller('visitorController',function($scope,$controller,visitorService){
	//继承
	$controller('baseController',{$scope:$scope});
	
	//分页查询
	$scope.findPage=function(pageNum,pageSize){
		visitorService.findPage(pageNum,pageSize).success(
			function(response){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;
			}
		);
	}
	
	//批量删除
	$scope.dele=function(){
		visitorService.dele($scope.selectIds).success(
			function(response){
				if(response.success){
					$scope.reloadList();
				}else{
					alert(response.message);
				}
			}
		);
	}
});