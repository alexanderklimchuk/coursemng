angular.module('courseApp.childControllers', []).controller(
		'ChildListController',
		function($scope, $state, $window, Child, uibDateParser) {
			$scope.children = Child.query();
			$scope.deleteChild = function(child) {

				child.$delete(function() {
					$scope.children = Child.query();
					$state.go('children');
				});
			}
		}).controller('ChildCreateController',
		function($scope, $state, $stateParams, uibDateParser, Child, Parent) {

			$scope.open1 = function() {
				$scope.popup1.opened = true;
			};

			$scope.open2 = function() {
				$scope.popup2.opened = true;
			};

			$scope.popup1 = {
				opened : false
			};

			$scope.popup2 = {
				opened : false
			};
			$scope.open2 = function() {
				$scope.popup2.opened = true;
			};

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
		function($scope, $state, $stateParams, Child, Parent) {

			$scope.parents = Parent.query();
			
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
			
			/*$scope.open1 = function() {
				$scope.popup1.opened = true;
			};

			$scope.open2 = function() {
				$scope.popup2.opened = true;
			};

			$scope.popup1 = {
				opened : false
			};

			$scope.popup2 = {
				opened : false
			};
			$scope.open2 = function() {
				$scope.popup2.opened = true;
			};*/
		
		});