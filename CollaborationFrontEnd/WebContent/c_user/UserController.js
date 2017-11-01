console.log("loaded user controller");
myapp.controller('UserController', ['UserService', '$http', '$scope',
		'$location', '$rootScope', '$cookieStore',function(UserService, $http, $scope, $location, $rootScope, $cookieStore) {
			var self = this;
			self.user = {};
			self.guest = {};
			/*
			 * this.addUser=function(){ UserService.addUser() .then(
			 * function(response) { console.log(response.data);
			 * $location.path('/user'); }, function(error){
			 * console.log(error);})}
			 */
			self.moniUser=$cookieStore.get('currentUser');
			self.validateUser = function() {
				console.log('validate user called');
				console.log('self.guest');
				console.log(self.guest);
				UserService.validate(self.guest).then(function(response) {
					console.log(response.data);
					self.user = response.data;
					$rootScope.currentUser =self.user;
					$cookieStore.put('currentUser',response.data );
					console.log($rootScope.currentUser);
					console.log('user ');
					console.log(self.user);
					$location.path('/home');
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
					self.guest.fullname={};
					self.guest.username={};
					self.guest.role={};
					self.guest.password={};
					self.guest.emailId={};
					self.guest.status={};
					self.guest.gender={};
					self.guest.isOnline={};
					self.guest.birthDay={};
					self.guest.address={};
					self.guest.mobile={};
					//$location.path('/#');
				}, function(error) {
					console.log(error);
				});
			}

		} ])