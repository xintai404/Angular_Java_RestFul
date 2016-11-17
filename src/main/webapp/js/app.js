'use strict';

angular.module('orderSystemApp', ['ngRoute', 'ui.bootstrap'])
.config(function($routeProvider) {
	$routeProvider
	.when('/',{
		templateUrl: 'partial/search.html',
		controller: 'SearchCtrl'   
	})
	.when('/summary/:person', {
		templateUrl: 'partial/summary.html',
		controller: 'SummaryCtrl'
	})
	.when('/orders/:id', {
		templateUrl: 'partial/detail.html',
		controller: 'DetailCtrl'
	})
	.otherwise('/');
});
