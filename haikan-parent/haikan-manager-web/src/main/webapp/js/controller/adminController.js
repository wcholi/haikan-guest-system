//管理员控制层
app.controller('adminController',function($scope,$controller,adminService){
	//继承
	$controller('baseController',{$scope:$scope});
	
	$scope.findAll=function(){
		adminService.findAll().success(
			function(response){
				$scope.list=response;
			}		
		);
	}
	
	//分页查询
	$scope.findPage=function(pageNum,pageSize){
		adminService.findPage(pageNum,pageSize).success(
			function(response){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;
			}		
		);
	}
	
	//增加管理员
	$scope.save=function(){
		var serviceObject;
		if($scope.entity.id!=null){
			serviceObject = adminService.update($scope.entity);
		}else{
			serviceObject = adminService.add($scope.entity);
		}
		serviceObject.success(
			function(response){
				if(response.success){
					$scope.reloadList();
				}else{
					alert(response.message);
				}
			}		
		);
	}
	
	//根据管理员id查询管理员信息
	$scope.findOne=function(id){
		adminService.findOne(id).success(
			function(response){
				$scope.entity=response;
			}		
		);
	}
	
	
	//批量删除
	$scope.dele=function(){
		adminService.dele($scope.selectIds).success(
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