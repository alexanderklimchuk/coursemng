angular.module('courseApp.courseControllers', ['courseApp.courseServices']).controller(
		'CourseListController', function($scope, $window, Course) {
			$scope.courses = Course.query();
			$scope.deleteCourse = function(course) {
				course.$delete(function() {
					$scope.courses = Course.query();
					$state.go('courses');
				});
			}

		}).controller('CourseCreateController',
		function($scope, $state, $stateParams, Course) {

			$scope.course = new Course();

			$scope.addCourse = function() {
				$scope.course.$save(function() {
					$state.go('courses');
				});
			}
		}).controller('CourseEditController',
		function($scope, $state, $stateParams, Course) {

			$scope.updateCourse = function(course) {
				$scope.course.$update(function() {
					$state.go('courses');
				});

			};

			$scope.loadCourse = function() {
				$scope.course = Course.get({
					id : $stateParams.id
				});
			};

			$scope.loadCourse();
		}).controller('CourseViewController',
		function($scope, $stateParams, Course) {
			$scope.course = Course.get({
				id : $stateParams.id
			});
		});
