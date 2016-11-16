'use strict';

angular.module('orderSystemApp')
    .controller('SearchCtrl', ['$scope', '$location',function($scope, $location){
    	$scope.firstname = '';
    	$scope.lastname =  '';
    	$scope.submit = function(){
    		$location.path("/summary/" +$scope.firstname+"_"+$scope.lastname);
    	}
    }])
    
    .controller('DetailCtrl', ['$scope',  'orderFactory','$routeParams', function($scope, orderFactory,$routeParams){
    	$scope.orders={};
    	var first_name  = $routeParams.person.split('_')[0];
    	var last_name   = $routeParams.person.split('_')[1];
    	orderFactory.getOrderSummery(first_name, last_name)
    		.then(function(res){
    			$scope.orders = res.data;
//    			console.log(res);
    		});
    }])
