angular.module('courseApp.childControllers', []).controller(
		'ChildListController', function($scope, $state, $window, Child) {
			$scope.children = Child.query();
			$scope.deleteChild = function(child) {

				child.$delete(function() {
					$scope.children = Child.query();
					$state.go('children');
				});
			}
		}).controller('ChildCreateController',
		function($scope, $state, $stateParams, Child, Parent) {

			$scope.child = new Child();
			$scope.parents = Parent.query();
			
			$scope.addChild = function() {
				$scope.child.$save(function() {
					$state.go('children');
				});
			}
		}).controller('ChildViewController',
		function($scope, $stateParams, Child) {

			$scope.child = Child.get({
				id : $stateParams.id
			});

		}).controller('ChildEditController',
		function($scope, $state, $stateParams, Child) {

			$scope.updateChild = function(child) {
				$scope.child.$Update(function() {
					$state.go('children');
				});

			};

			$scope.loadChild = function() {
				$scope.child = Child.get({
					id : $stateParams.id
				});
			};

			$scope.loadChild();
		});