'use strict';

angular.module('orderSystemApp', ['ngRoute'])
.config(function($routeProvider) {
	$routeProvider
	.when('/',{
		templateUrl: 'partial/search.html',
		controller: 'SearchCtrl'   
	})
	.when('/summary/:person', {
		templateUrl: 'partial/summary.html',
		controller: 'DetailCtrl'
	})
	.when('/orders/:id', {
		templateUrl: 'partial/detail.html',
		controller: ''
	})
	.otherwise('/');
});
