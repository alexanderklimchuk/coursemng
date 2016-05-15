angular.module('courseApp.parentControllers', []).controller(
		'ParentListController', function($scope, $state, $window, Parent) {
			$scope.parents = Parent.query();
			$scope.deleteParent = function(parent) {
				parent.$delete(function() {
					$scope.parent = Parent.query();
					$state.go('parents');
				});
			}
		}).controller('ParentCreateController',
		function($scope, $state, $stateParams, Parent, Clientstatus) {

			$scope.statuses = Clientstatus.query();

			$scope.parent = new Parent();
			$scope.addParent = function() {
				$scope.parent.$save(function() {
					$state.go('parents');
				});
			}
		}).controller('ParentViewController',
		function($scope, $stateParams, Parent) {
			$scope.parent = Parent.get({
				id : $stateParams.id
			});
		}).controller('ParentEditController',
		function($scope, $state, $stateParams, Parent, Clientstatus) {

			$scope.statuses = Clientstatus.query();
			$scope.updateParent = function(parent) {
				$scope.parent.$Update(function() {
					$state.go('parents');
				});

			};

			$scope.loadParent = function() {
				$scope.parent = Parent.get({
					id : $stateParams.id
				});
			};

			$scope.loadParent();
		});