angular.module('courseApp.cardControllers', []).controller(
		'CardListController', function($scope, $state, $window, Card) {
			$scope.cards = Card.query();
		}).controller('CardViewController',
		function($scope, $stateParams, Card, $http) {

			$scope.card = Card.get({
				id : $stateParams.id
			});
			
			$scope.incrementTen = function(cardId) {
				$http.put("/discountCard/" + cardId +"/increment")
				  .then(function(response){ $scope.card = response.data; });
			};
			$scope.decrementTen = function(cardId) {
				
				$http.put("/discountCard/" + cardId +"/decrement")
				  .then(function(response){ $scope.card = response.data; });
			};
			
		});