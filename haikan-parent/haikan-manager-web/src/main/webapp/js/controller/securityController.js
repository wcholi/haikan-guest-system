app.controller('securityController',function($scope,$controller,securityService){
	
	//继承
	$controller('baseController',{$scope:$scope});
	
	//分页查询
	$scope.findPage=function(pageNum,pageSize){
		securityService.findPage(pageNum,pageSize).success(
			function(response){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;
			}		
		);
	}
	
	//定义时间段列表数据
	$scope.timeList={data:[]};
	
	$scope.selectTimeList=function(){
		securityService.selectTimeList().success(
			function(response){
				$scope.timeList={data:response};
			}
		);
	}
	
	//保存报警对象信息
	$scope.save=function(){
		var serviceObject;
		if($scope.entity.id!=null){
			serviceObject = securityService.update($scope.entity);
		}else{
			serviceObject = securityService.add($scope.entity);
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
	
	//根据id查询报警对象信息
	$scope.findOne=function(id){
		securityService.findOne(id).success(
			function(response){
				$scope.entity=response;
				//从数据库查询出来的是字符串，需要将其转换为json对象才能实现信息的回显
				$scope.entity.dutyTime=JSON.parse($scope.entity.dutyTime);
			}
		);
	}
	
	//批量删除
	$scope.dele=function(){
		securityService.dele($scope.selectIds).success(
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