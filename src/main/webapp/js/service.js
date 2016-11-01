/**
 * service.js
 */

/**product service*/
app.factory('productService', ['$http', function($http) {
 var queryProduct = function(scope){
	   $http.get("/ecargo/product/query").then(function(response){
		   scope.products = response.data;
		   if(response.data.length==0){
			   scope.isEmpty = true;
		   }else{
			   scope.isEmpty = false;
		   }
		}, function(){
			alert("query product error occured!");
		});
 };
 var queryProductByBrandId = function(brandId,scope){
	   $http.get("/ecargo/product/query/"+brandId).then(function(response){
		   scope.products = response.data;
		   if(response.data.length==0){
			   scope.isEmpty = true;
		   }else{
			   scope.isEmpty = false;
		   }
		}, function(){
			alert("query product error occured!");
		});
 };
 var searchClickEnvent = function(brandId, scope){
		if(brandId==''||brandId==undefined){
			this.queryProduct(scope);
		}else{
			this.queryProductByBrandId(brandId, scope);
		}
 };
 return {queryProduct:queryProduct, 
	 	 queryProductByBrandId:queryProductByBrandId,
	 	 searchClickEnvent:searchClickEnvent};
 
}]);

/**user service*/
app.factory('userService', ['$http', function($http) {
 var getUserByUserEmail = function(scope, userEmail, callback){
	 $http.get("/ecargo/user/query?useremail="+userEmail).then(function(response){
		   scope.user = response.data;
		   callback();
		}, function(){
			alert("query user error occured!");
		});
 };
 return {getUserByUserEmail:getUserByUserEmail};
 
}]);

/** review service */
app.factory('reviewService', ['$http', '$httpParamSerializer', 'userService', function($http, $httpParamSerializer, userService) {
	var createReview = function(scope, modalInstance) {
		$http({
			method : 'POST',
			url : '/ecargo/review/create',
			data : $httpParamSerializer(scope.formData),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).then(function(response) {
			var ajaxResult = response.data;
			if(ajaxResult.code=='success'){
				modalInstance.dismiss('cancel');
				var refreshReviewCallback = function(){
					scope.product.review.rating = scope.formData.rating;
					scope.product.review.summary = scope.formData.comment;
					scope.product.review.userName = scope.user.name;
				};
				userService.getUserByUserEmail(scope,scope.formData.useremail, refreshReviewCallback);
			}else{
				scope.emailErrorMsg = ajaxResult.errorMsg;
				setTimeout(function(){document.getElementById("userEmail").focus();}, 100);
			}
		}, function() {
			alert("create review error occured, please contact manager!");
			scope.emailErrorMsg = "create review error occured!";
		});
	};
	return {
		createReview : createReview
	};
}]);