/**
 * controller.js
 */

/** product controller*/
app.controller("productController", ['$scope', '$modal', 'productService',
		function($scope, $modal, productService) {
			productService.queryProduct($scope);

			$scope.search = function(ev) {
				var brandId = $scope.searchBrandId;
				productService.searchClickEnvent(brandId, $scope);
			};

			$scope.open = function(product) {
				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'myModalContent.html',
					controller : 'ModalInstanceCtrl',
					size : '',
				});
				modalInstance.product = product;
			};

		}]);

/**create review controller*/
app.controller('ModalInstanceCtrl', ['$scope', '$modalInstance',
		'reviewService', function($scope, $modalInstance, reviewService) {
			$scope.product = $modalInstance.product;
			$scope.ok = function() {
				//validate input
				if($scope.inputEmail==undefined||$scope.inputEmail==''){
					$scope.emailErrorMsg = 'input must be email format';
					setTimeout(function(){document.getElementById("userEmail").focus();}, 100);
					return;
				}
				$scope.formData = {
					useremail : $scope.inputEmail,
					productid : $scope.product.id,
					rating : $scope.x,
					comment : ($scope.inputComment==undefined)?'':$scope.inputComment
				};
				reviewService.createReview($scope, $modalInstance);
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};

			$scope.isReadonly = false;
			$scope.hoveringOver = function(value) {
				$scope.x=value;
			};

			$scope.ratingStates = [{
				stateOn : 'glyphicon-ok-sign',
				stateOff : 'glyphicon-ok-circle'
			}, {
				stateOn : 'glyphicon-star',
				stateOff : 'glyphicon-star-empty'
			}, {
				stateOn : 'glyphicon-heart',
				stateOff : 'glyphicon-ban-circle'
			}, {
				stateOn : 'glyphicon-heart'
			}, {
				stateOff : 'glyphicon-off'
			}];
			
		}]);
