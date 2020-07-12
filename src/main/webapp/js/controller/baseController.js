app.controller("baseController",function($scope){
	//分页控件配置
	$scope.paginationConf = {
		currentPage: 1,
		// 总记录数：写的10是个假象，因为一进入页面分页插件就会
		// 被执行，一执行，就会从后台拿到总记录数，然后替换这个数字
		totalItems: 10,

		// 每页显示条数
		itemsPerPage: 5,

		perPageOptions: [3,5, 10, 20, 30],

		// 一进入页面， 以及当前页发生改变的时候执行
		onChange: function () {
			// findPage方法当整合了条件查询时，就过期了
			// 以后需要刷新列表的地方：就使用一个见名知意的方法 reloadList
			$scope.reloadList();
			
		}
	};
	// 刷新列表
	$scope.reloadList = function () {
		// $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
		// console.log($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
		$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
	}

});