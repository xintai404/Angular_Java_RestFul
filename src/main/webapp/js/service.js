'use strict';

angular.module("orderSystemApp")
	.constant('baseURL', '/OrderSystem')
    .factory("orderFactory",['$http', 'baseURL', function($http,baseURL){
    	
    	var orderfac = {};

    	orderfac.getOrderSummery= function(first_name, last_name){
        	return $http({
                method  : 'GET',
                url     : baseURL+'/rest/orders',
                headers : {'Content-Type': 'application/json'},
                params  : {
                	first_name: first_name,
                	last_name : last_name
                }
            });

    	};
    	
    	orderfac.getOrderDetail = function(order_number){
    		return $http({
    			method : 'GET',
    			url    : baseURL +'/rest/orders/'+order_number,
    			headers:{'Content-Type' : 'application/json'}
    		});
    	}
    	
    	
    	return orderfac;
    }]);