myapp.service('BlogService', [ '$http', '$rootScope', '$q', 'RESTURL',
		function($http, $rootScope, $q, RESTURL) {

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
			
//			this.myBlogsList = function(){
//				console.log("My Blogs of Blogservice called");
//				var deferred = $q.defer();
//				$http.get(RESTURL + 'getBlogByUserid/{id}').then(function(response) {
//					/*
//					 * this.blogList=response.data; console.log(this.blogList);
//					 */
//					console.log(response.data);
//					deferred.resolve(response);
//				}, function(error) {
//					deferred.reject(error);
//				});
//				return deferred.promise;
//			}
		}
])