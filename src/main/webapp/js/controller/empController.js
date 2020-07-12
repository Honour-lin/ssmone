app.controller("empController",function($scope,$controller,empService){
	//继承
	$controller("baseController",{
		$scope:$scope
	});
	$scope.findPage = function (page,size) {
		empService.findPage(page,size).success(function (response) {
	       $scope.userList = response.rows;
		   // console.log(response.rows)
	       $scope.paginationConf.totalItems = response.total;
	    })
	}
	$scope.add = function () {
		console.log($scope.emp)
		empService.add($scope.user).success(function (response) {
			$scope.reloadList();
			if (!response.success){
				alert("添加失败！");
			}
		})
	}
	// 定义搜索对象
	$scope.searchEntity = {};
	// 搜索
	$scope.search = function(page,size){
		console.log(11)
		empService.search(page,size,$scope.searchEntity).success(
			function(response){
				$scope.userList=response.rows;
				$scope.paginationConf.totalItems=response.total;
			}
		);
	}
	//查询所有
	$scope.findAll = function () {
		empService.findAll().success(function (response) {
			$scope.users = response;
		})
	}
	$scope.delete = function (id) {
		console.log(id)
		empService.delete(id).success(function (response) {
			if (response.success){
				alert("删除成功！");
				$scope.reloadList();
			}
		})
	}
});