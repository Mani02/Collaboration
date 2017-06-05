console.log("loaded user controller");
myapp.controller('UserController', ['UserService', '$http', '$scope',
		'$location', '$rootScope',function(UserService, $http, $scope, $location, $rootScope) {
			var self = this;
			self.user = {};
			self.guest = {};
			/*
			 * this.addUser=function(){ UserService.addUser() .then(
			 * function(response) { console.log(response.data);
			 * $location.path('/user'); }, function(error){
			 * console.log(error);})}
			 */

			self.validateUser = function() {
				console.log('validate user called');
				console.log('self.guest');
				console.log(self.guest);
				UserService.validate(self.guest).then(function(response) {
					console.log(response.data);
					self.user = response.data;
					$rootScope.currentUser =self.user;
					console.log($rootScope.currentUser);
					console.log('user ');
					console.log(self.user);
					$location.path('/blog');
				}, function(error) {
					console.log(error);
				});
			}

			self.insertUser = function() {
				console.log('insert user called');
				console.log('self.guest');
				console.log(self.guest);
				UserService.insertUser(self.guest).then(function(response) {
					self.user =response.data;
					$location.path('/#');
				}, function(error) {
					console.log(error);
				});
			}

		} ])