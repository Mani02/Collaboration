console.log("loaded blog controller");
myapp.controller('BlogController', [ 'BlogService', '$http', '$scope',
		'$location', '$rootScope', '$cookieStore','$routeParams', function(BlogService, $http, $scope, $location, $rootScope, $cookieStore,$routeParams) {
			var self = this;
			self.blog = {};
			self.bloglist = [];
			self.mybloglist = [];
			self.selectedBlog = {};
			self.commentlist = [];
			//self.allBlogs=true;
			self.newBlog=false;
			self.myBlog=false;
			self.comments=false;
			//self.editbyadmin=true;
			self.blog.user =$rootScope.currentUser;
			
			
			self.blog.moniUser=$cookieStore.get('currentUser');
			self.createBlog = function() {
				console.log('create new blog called');
				self.blog.user =$rootScope.currentUser;
				self.blog.status="New";
				console.log('self.blog');
				console.log(self.blog);
				console.log(self.blog.user);
				BlogService.addBlog(self.blog).then(function(response) {
					// console.log(response.data);
					self.blog = response.data;
					console.log($rootScope.currentUser);
					alert("Your blog is posted successfully and waiting for admin's approval..!!!!")
					//$location.path('/createBlog');
					self.allBlogs=false;
					self.newBlog=true;
					self.myBlog=false;
					self.comments=false;
				}, function(error) {
					console.log(error);
				});
			}
			
			self.writeBlog = function() {
				self.allBlogs=false;
				self.newBlog=true;
				self.myBlog=false;
				self.comments=false;
			}
			
			self.getMyBlogs = function(){
				self.allBlogs=false;
				self.newBlog=false;
				self.myBlog=true;
				self.comments=false;
				console.log("getMyBlogs controller called");
				console.log(self.blog.user);
				self.buId=$cookieStore.get('currentUser').userId;
  				console.log(self.buId);
				BlogService.myBlogsList(self.buId).then(function(response) {
					self.mybloglist = response.data;
					console.log(self.mybloglist);
				}, function(error) {
					console.log(error);
				});
			}
			
			self.getBlogList = function() {
				console.log("All Blogs controller called");
				self.allBlogs=true;
				self.newBlog=false;
				self.myBlog=false;
				self.comments=false;
				console.log(self.blog.user);
				BlogService.listBlog().then(function(response) {
					self.bloglist = response.data;
					console.log(self.bloglist);
					
					self.getBlogParams();
				}, function(error) {
					console.log(error);
				});
			}
			
			self.getBlogParams = function() {
  				if($routeParams.blogId){
  				self.selectedBlogId = $routeParams.blogId;
  				console.log($routeParams.blogId);
  				console.log(self.bloglist);		
  				console.log("Get Param for Blog called")
  				console.log(self.selectedBlogId );
  				for (var i = 0; i < self.bloglist.length; i++) {
  					if (self.bloglist[i].blogId == self.selectedBlogId ) {
  						self.blogs = self.bloglist[i];
  					}
  				}
  			}
                 console.log(self.blogs);
  			}
			
			self.showComments = function(blg) {
				console.log("Blog Comments controller called");
				console.log(blg);
				self.selectedBlog = blg;
				console.log(self.selectedBlog);
				self.comments=true;
				self.allBlogs=false;
				self.newBlog=false;
				self.myBlog=false;
				self.commentlist = self.selectedBlog.blogComments;
				console.log(self.commentlist);
				self.addComments = function(){
					console.log("Add Blog Comments controller called");
//					console.log(blg);
//					self.selectedBlog = blg;
					console.log(self.selectedBlog);
					self.comments=true;
					self.allBlogs=false;
					self.newBlog=false;
					self.myBlog=false;
					
					self.blgComments.blog={blogId:self.selectedBlog.blogId};
					console.log('self.blgComments.blog');
					console.log(self.blgComments.blog);
					
					self.blgComments.user = $rootScope.currentUser;
					console.log('self.blgComments.user');
					console.log(self.blgComments.user);
					
					BlogService.addComment(self.blgComments).then(function(response) {
						alert("Comment posted successfully!!")
						console.log(response.data);
						self.blgComments = response.data;

					}, function(error) {
						console.log(error);
					});
				}
			}
			
			
			 self.getBlogListAdmin = function() {
           	  //self.allblogs=true;
     			  //self.editbyadmin=false;
					
 				console.log("BlogList Admin controller called");
 				BlogService.listBlogAdmin().then(function(response) {
 					self.bloglist = response.data;
 					console.log(self.bloglist);
 					$location.path("/blogsadmin");
 				}, function(error) {
 					console.log(error);
 				});
 			}
             
             self.getAdminBlogList = function(blg) {
//          	  self.allblogs=false;
//   			self.editbyadmin=true;
   			
 				console.log("Admin BlogList controller called");
 				self.selectedBlog=blg;
 				console.log(self.selectedBlog);
 			}
             
             self.updateBlog = function() {
 				
 				console.log("Update Blog controller called");
 				
 				BlogService.updateblog(self.selectedBlog).then(function() {
 					
 					//self.blog = response.data;
 					alert("Update is posted successfully..!!!!")
 					$location.path("/gettoallblogs");
 					
 				}, function() {
 					console.log();
 				});
 			}
			
			self.getBlogList();
		
} ]);