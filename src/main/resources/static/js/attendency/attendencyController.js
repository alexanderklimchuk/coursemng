angular.module('courseApp.attendencyControllers', []).controller(
		'AttendencyListController',
		function($scope, $state, $window, Attendency, Child, Course, uibDateParser) {
			$scope.attendencies = Attendency.query();
			$scope.courses = Course.query();
			$scope.children = Child.query();
			
			$scope.attendency = new Attendency();
			
			$scope.addAttendency= function() {
				$scope.attendency.$save(function() {
					$scope.attendencies = Attendency.query();
				});
			}
			
			
			
			$scope.childDobPopup = {
					opened : false
				};

				$scope.openChildDobPopup = function() {
					$scope.childDobPopup.opened = true;
				};
				$scope.dateOptions = {
					formatYear : 'yy',
					maxDate : new Date(),
					minDate : new Date(1989, 5, 22),
					startingDay : 1
				};

		}).controller('CardViewController2',
		function($scope, $stateParams, Card, $http) {

		});