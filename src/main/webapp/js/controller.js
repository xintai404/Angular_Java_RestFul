'use strict';

angular.module('orderSystemApp')
    .controller('SearchCtrl', ['$scope', '$location', 'nameFactory' ,function($scope, $location, nameFactory){
    	$scope.firstname = '';
    	$scope.lastname =  '';
    	$scope.firstnameList = null;
    	$scope.lastnameList = null;
    	$scope.submit = function(){
    		$location.path("/summary/" +$scope.firstname+"_"+$scope.lastname);
    	}
    	
    	//$scope.states =["Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Dakota", "North Carolina", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"];
    	nameFactory.getAllFirstNames()
    		.then(function(res){
    			$scope.firstnameList = res.data;
    		})
    		
    	nameFactory.getAllLastNames()
    		.then(function(res){
    			$scope.lastnameList = res.data;
    		})
    	
    }])
    
    .controller('SummaryCtrl', ['$scope',  'orderFactory','$routeParams', function($scope, orderFactory,$routeParams){
    	$scope.orders={};
    	var first_name  = $routeParams.person.split('_')[0];
    	var last_name   = $routeParams.person.split('_')[1];

    	orderFactory.getOrderSummery(first_name, last_name)
    		.then(function(res){
    			$scope.orders = res.data;
    		});
    }])
    
    .controller('DetailCtrl',['$scope', 'orderFactory', '$routeParams', function($scope, orderFactory, $routeParams){
    	$scope.orderDetials ={};
    	var order_number = $routeParams.id;
    	
    	orderFactory.getOrderDetail(order_number)
	    	.then(function(res){
	    		$scope.orderDetails = res.data;
	    	});
    }])
