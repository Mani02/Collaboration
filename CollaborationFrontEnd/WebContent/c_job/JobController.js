console.log("loaded job controller");

myapp.controller('JobController', [ 'JobService', '$http', '$scope',
                             		'$location', '$rootScope' , '$cookieStore', function(JobService, $http, $scope, $location, $rootScope, $cookieStore) {
	var self = this;
	self.jobList = [];
	self.allJobs=true;
	self.newJob=false;
	self.job = {};
	self.selectedJob = {};
	self.job.user = $rootScope.currentUser;
	
	self.job.moniUser=$cookieStore.get('currentUser');
	self.getAllJobs = function(){
		console.log('All Jobs Controller called');
		self.allJobs=true;
		self.newJob=false;
		JobService.allJobs().then(function(response){
			self.jobList = response.data;
			console.log(self.jobList);
		}, function(error) {
			console.log(error);
		});
	}
	
	self.writeJob = function() {
		self.allJobs=false;
		self.newJob=true;
	}
	
	self.createJob= function(){
		console.log('Create New Job called');
//		self.allJobs=false;
//		self.newJob=true;
		JobService.addNewJob(self.job).then(function(response) {
			console.log(response.data);
			//self.job = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	
	self.applyForJob = function(j){
		console.log('New Job Apply called');
		console.log(j);
		var data={
				user:$rootScope.currentUser,
				job:j
		}
		
		JobService.jobapply(data).then(function(response){
			console.log(response.data);
			//self. = response.data;

		}, function(error) {
			console.log(error);
		});
	}
	
	self.getAllJobs();
	
}]);