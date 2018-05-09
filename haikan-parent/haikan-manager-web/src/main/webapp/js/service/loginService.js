app.service('loginService',function($http){
	//查询登录后的用户名
	this.showLoginName=function(){
		return $http.get('../login/name.do');
	}
});