app.controller('baseController',function($scope){
	//重新加载
	$scope.reloadList=function(){
		//切换页码
		$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	};
	
	//分页控件配置 
	$scope.paginationConf = {
		 currentPage: 1,
		 totalItems: 10,
		 itemsPerPage: 10,
		 perPageOptions: [10, 20, 30, 40, 50],
		 onChange: function(){
		       $scope.reloadList();//重新加载
		 }
	};
	
	$scope.selectIds=[];
	//获取选中的复选框
	$scope.updateSelections=function($event,id){
		if($event.target.checked){
			//如果是被选中的话，将id添加到selectIds中
			$scope.selectIds.push(id);
		}else{
			var idx = $scope.selectIds.indexOf(id);//获得取消选中的复选框id位置
			$scope.selectIds.splice(idx,1);        //将selectIds中位置为idx的值删掉
		}
	}
	
	//提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
	$scope.jsonToString=function(jsonString,key){
		var json=JSON.parse(jsonString);//将json字符串转换为json对象
		var value=json[key];
		return value;
	}

});