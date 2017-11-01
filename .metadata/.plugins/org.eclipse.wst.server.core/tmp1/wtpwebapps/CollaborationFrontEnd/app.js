var myapp = angular.module("myprojct", [ 'ngRoute' , 'ngCookies']);

myapp.constant('RESTURL','http://localhost:8183/CollaborationRestServices/');

//myapp.config.$inject = ['$routeProvider', '$locationProvider'];

myapp.config(function($routeProvider,$locationProvider) {

	$routeProvider.when('/', {

		templateUrl : 'c_user/sign_in_sign_up.html',
		controller:'UserController',
		controllerAs:'userCtrl'
	})
	
	.when('/home',{
		templateUrl : 'home/home.html',
		controller:'UserController',
		controllerAs:'userCtrl'
	})
	
	.when('/blog',{
		templateUrl : 'c_blog/blog.html',
		controller:'BlogController',
		controllerAs:'blogCtrl'
	})
	
	.when('/blogsadmin', {
		templateUrl : 'c_blog/BlogAdmin.html',
	    controller : 'BlogController',
		controllerAs : 'blogCtrl'
	})
	
	.when('/job',{
		templateUrl : 'c_job/job.html',
		controller:'JobController',
		controllerAs:'jobCtrl'
	})
	
	.when('/about',{
		templateUrl : 'about/about.html'
	})
	
	.when('/contact_us',{
		templateUrl : 'contact_us/contact_us.html'
	})
	.otherwise({ redirectTo: '/' });
	
});

myapp.run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
myapp.run(function($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.currentUser = $cookieStore.get('$rootScope.currentUser') || {};
    if ($rootScope.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser;
    }
});
myapp.run();