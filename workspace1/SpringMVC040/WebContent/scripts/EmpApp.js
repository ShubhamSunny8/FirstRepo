var empModule =angular.module("empModule",[]);

//This method is a boot strap method for module
empModule.run(
function($rootScope){
	
	$rootScope.title="Capgemini India Pvt. Ltd.";
	}
);

empModule.controller("empController",
		function ($scope,$http){
			$scope.pageHead="List OF Employees";
			
			refreshPage();
			function refreshPage(){
			$http({
				method :'GET',
				url: 'http://localhost:8088/SpringMVC040/rest/empList'
				
			}).success(function(data){
				
					$scope.empList = data;
				});
			}
	$scope.empDetails=function(empNo){
		$http({
			method :'GET',
			url: 'http://localhost:8088/SpringMVC040/rest/empDetails/'+empNo
			
		}).success(function(data){
			alert("c");
				$scope.emp = data;
			});
	}
	
		$scope.empDelete=function(empNo){
			$http({
				method :'GET',
				url: 'http://localhost:8088/SpringMVC040/rest/empDelete/'+empNo
				
			}).success(function(data){
				alert(data);
					refreshPage();
				});
		
		}
}
);