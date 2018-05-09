app.controller('monitoredController',function($scope,$controller,monitoredService,uploadService){
	//继承
	$controller('baseController',{$scope:$scope});
	
	/**
	 * 上传图片
	 */
	$scope.uploadFile=function(){	  
		uploadService.uploadFile().success(function(response) {        	
        	if(response.success){//如果上传成功，取出url
        		$scope.entity.image=response.message;//设置文件地址
        	}else{
        		alert(response.message);
        	}
        }).error(function() {           
        	     alert("上传发生错误");
        });        
    };    
    
    //分页查询
	$scope.findPage=function(pageNum,pageSize){
		monitoredService.findPage(pageNum,pageSize).success(
			function(response){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;
			}		
		);
	}
	
   //添加监控信息
    $scope.save=function(){
    	var serviceObject;
    	if($scope.entity.id != null){
    		serviceObject = monitoredService.update($scope.entity);
    	}else{
    		serviceObject = monitoredService.add($scope.entity.image);
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
    
    //根据id查询监控信息
    $scope.findOne=function(id){
    	monitoredService.findOne(id).success(
    		function(response){
    			$scope.entity=response;
    		}
    	);
    }
    
    //批量删除
    $scope.dele=function(){
    	monitoredService.dele($scope.selectIds).success(
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