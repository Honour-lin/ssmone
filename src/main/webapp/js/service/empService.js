app.service("empService",function($http){

	this.findPage = function(page,size){
		return $http.get("http://localhost:8080/user/page?page="+page+"&size="+size);
	}
	this.add = function (user) {
		return $http.post("http://localhost:8080/user/add",user);
	}
	this.search = function(page, size, searchEntity) {
		// post提交，page、size属性和之前相同，将searchEntity提交至后台@RequestBody对应的属性
		return $http.post('http://localhost:8080/user/search?page=' + page + '&size=' + size,
			searchEntity);
	}
	this.findAll = function () {
		return $http.get("http://localhost:8080/user/all");
	}
	this.delete = function (id) {
		return $http.get("http://localhost:8080/user/delete?id="+id);
	}
})