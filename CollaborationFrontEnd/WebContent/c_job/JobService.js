myapp.service('JobService', [ '$http', '$q', 'RESTURL',
		function($http, $q, RESTURL) {
	
	this.allJobs = function(){
		console.log("All Jobs of JobService called");
		var deferred = $q.defer();
		$http.get(RESTURL + '/getAllJob').then(function(response) {
			console.log(response.data);
			deferred.resolve(response);
		}, function(error) {
			deferred.reject(error);
		});
		return deferred.promise;
	}
	
	this.addNewJob = function(job){
		console.log("Create Job of JobService called");	
		console.log(job);
		var deferred = $q.defer();
		$http.post(RESTURL + '/createJob', job).then(function(response) {
			deferred.resolve(response.data);
		}, function(error) {
			deferred.reject(error);
		});
		return deferred.promise;
	}
	
	this.jobapply = function(data){
		console.log("Create JobApplied of JobService called");	
		console.log(data);
		var deferred = $q.defer();
		$http.post(RESTURL + '/newJobApplied',data).then(function(response) {
			deferred.resolve(response.data);
		}, function(error) {
			deferred.reject(error);
		});
		return deferred.promise;
	}
	
}]);