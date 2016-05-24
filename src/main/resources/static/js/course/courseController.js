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
		function($scope, $stateParams,$resource, Course) {

			var Trainer = $resource('/course/:id/trainers', {
				id : $stateParams.id
			});
			
			var Child = $resource('/course/:id/children', {
				id : $stateParams.id
			});
			
			$scope.trainers = Trainer.query();
			$scope.children = Child.query();

			$scope.course = Course.get({
				id : $stateParams.id
			});
		})