console.log("loaded blog controller");
myapp.controller('BlogController', [ 'BlogService', '$http', '$scope',
		'$location', '$rootScope', function(BlogService, $http, $scope, $location, $rootScope) {
			var self = this;
			self.blog = {};
			self.bloglist = [];
			self.allBlogs=true;
			self.newBlog=false;
			self.myBlog=false;
			
			
			self.createBlog = function() {
				console.log('create new blog called');
				console.log('self.blog');
				self.blog.user = $rootScope.currentUser;
				console.log(self.blog);
				BlogService.addBlog(self.blog).then(function(response) {
					// console.log(response.data);
					self.blog = response.data;
					console.log($rootScope.currentUser);
					//$location.path('/createBlog');
					self.allBlogs=false;
					self.newBlog=true;
				}, function(error) {
					console.log(error);
				});
			}
			
			self.writeBlog = function() {
				self.allBlogs=false;
				self.newBlog=true;
				self.myBlog=false;
			}
			
			self.getMyBlogs = function(){
				self.allBlogs=false;
				self.newBlog=false;
				self.myBlog=true;
				console.log("getMyBlogs controller called");
				self.blog.user = $rootScope.currentUser;
				console.log(self.blog);
				BlogService.myBlogsList().then(function(response) {
					self.bloglist = response.data;
					console.log(self.bloglist);
				}, function(error) {
					console.log(error);
				});
			}
			
			self.getBlogList = function() {
				console.log("BlogList controller called");
				BlogService.listBlog().then(function(response) {
					self.bloglist = response.data;
					console.log(self.bloglist);
				}, function(error) {
					console.log(error);
				});
			}
			
			self.getBlogList();
		} ]);