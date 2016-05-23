angular.module('courseApp.cardControllers', []).controller(
		'CardListController', function($scope, $state, $window, Card) {
			$scope.cards = Card.query();
		}).controller('CardViewController',
		function($scope, $stateParams, Card) {

			$scope.card = Card.get({
				id : $stateParams.id
			});
		});