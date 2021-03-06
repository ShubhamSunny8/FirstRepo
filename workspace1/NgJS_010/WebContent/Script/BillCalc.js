// A factory method . modulecreates a module object
var billModule= angular.module("billModule",[]);
billModule.controller("billController",function($scope){
	$scope.bill={
			'cost' 		:0,
			'qty'  		:1,
			'discount'  :0
	};


$scope.calcTotalBill =function(){
	return $scope.bill.cost * $scope.bill.qty;
};

$scope.calcDiscount =function(){
	return $scope.calcTotalBill() * $scope.bill.discount /100;
};

$scope.calcDiscountedBill =function(){
	return  $scope.calcTotalBill() - $scope.calcDiscount();
};
}
);