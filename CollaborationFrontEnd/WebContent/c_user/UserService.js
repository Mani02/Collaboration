
myapp.service('UserService', [
		'$http',
		'$rootScope',
		'$q',
		'RESTURL',
		function($http, $rootScope, $q, RESTURL) {

			
			 this.insertUser=function(guest){ 
				 console.log("user service called");
				 var deferred=$q.defer();
				 $http.post(RESTURL +'/registerUser',guest) .then(
			 function(response){ 
				 console.log(response.data);
				 deferred.resolve(response); 
			 },
			 function(error){ 
				 deferred.reject(error); 
			 }); return
			 deferred.promise; 
			 }
			 

			this.validate = function(guest) {
				console.log("user service called")
				var deferred = $q.defer();
				$http.post(RESTURL + '/login',guest).then(
						function(response) {
							console.log(response.data);
							deferred.resolve(response);
						}, function(error) {
							deferred.reject(error);
						});
				return deferred.promise;
			}
		}

])