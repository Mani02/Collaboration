myapp.service('BlogService', [ '$http', '$q', 'RESTURL',
		function($http, $q, RESTURL) {

			this.blogList = [];
			this.addBlog = function(blog) {
				console.log("Create Blog of Blogservice called");	
				console.log(blog)
				var deferred = $q.defer();
				$http.post(RESTURL + '/createBlog', blog).then(function(response) {
					deferred.resolve(response.data);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;
			}

			this.listBlog = function() {
				console.log("All Blogs of Blogservice called");
				var deferred = $q.defer();
				$http.get(RESTURL + '/getAllBlog').then(function(response) {
					/*
					 * this.blogList=response.data; console.log(this.blogList);
					 */
					console.log(response.data);
					deferred.resolve(response);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;
			}
			
			this.myBlogsList = function(userId){
				console.log("My Blogs of Blogservice called");
				var deferred = $q.defer();
				$http.get(RESTURL + '/getBlogByUserid/' + userId).then(function(response) {
				/*	this.myblogList=response.data; 
					console.log(this.myblogList);*/
					console.log(response.data);
					deferred.resolve(response);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;
			}
			
			this.listBlogAdmin=function(){
				console.log("Blogservice called");
				
				var deferred=$q.defer();
				$http.get(RESTURL + '/getAllBlog')
				.then(
				function(response){
					/*this.blogList=response.data;
					console.log(this.blogList);*/
					deferred.resolve(response);
					},
					function(error){
						deferred.reject(error);
					});
				return deferred.promise;
				}		
			
			this.addComment = function(blogComment) {
				console.log("Create BlogComment of Blogservice called");	
				console.log(blogComment)
				var deferred = $q.defer();
				$http.post(RESTURL + '/addComment', blogComment).then(function(response) {
					deferred.resolve(response.data);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;
			}
			
		}
])