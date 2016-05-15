angular.module('courseApp.courseControllers', []).controller(
		'CourseListController', function($scope, $state, $window, Course) {
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

		}).controller('CourseViewController',
		function($scope, $stateParams, Course) {

			$scope.trainer = Course.get({
				id : $stateParams.id
			});

		})