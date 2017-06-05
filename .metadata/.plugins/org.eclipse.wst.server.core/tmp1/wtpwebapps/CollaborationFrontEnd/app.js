var myapp = angular.module("myprojct", [ 'ngRoute' ]);

myapp.constant('RESTURL','http://localhost:9182/CollaborationRestServices');


myapp.config(function($routeProvider,$locationProvider) {

	$routeProvider.when('/', {

		templateUrl : 'c_user/sign_in_sign_up.html',
		controller:'UserController',
		controllerAs:'userCtrl'
	})
	
	.when('/blog',{
		templateUrl : 'c_blog/blog.html',
		controller:'BlogController',
		controllerAs:'blogCtrl'
	});
});