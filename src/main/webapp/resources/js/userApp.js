var userApp = angular.module('userApp', []);

userApp.config(['$httpProvider', function ($httpProvider) {    
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
}]);

userApp.controller('UserCtrl', function($scope, $http) {
	$scope.nan = {
	        "username": "aaa",
	        "password": "123",
	        "enabled": true,
	        "userRole": [
	            {
	                "userRoleId": 5,
	                "role": "ROLE_USER"
	            }
	        ]
	    };
	
    $http.get("users/list")
    .success(function (response) {$scope.users = response;});
    
    $scope.deleteUser = function (userId) {
    	var data = 'username=' + userId;
    	$http.post("users/deleteByUsername",data);
    };
    
    $scope.createNewUser = function () {
    	var req = {
			method: 'POST',
			url: "users/create",
			headers: {'Content-Type': 'application/json'},
			data: $scope.nan
		};
		$http(req)
		.success(function () {alert("ok");})
		.error(function () {});
    };
});