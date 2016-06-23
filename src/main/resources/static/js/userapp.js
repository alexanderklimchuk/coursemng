/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('courseApp', [ 'ngMessages', 'ngAnimate', 'ngFileUpload',
		'ui.bootstrap', 'ui.router', 'ngResource',
		'courseApp.trainerControllers', 'courseApp.trainerServices',
		'courseApp.courseServices', 'courseApp.courseControllers',
		'courseApp.childControllers', 'courseApp.childServices',
		'courseApp.parentControllers', 'courseApp.parentServices',
		'courseApp.cardControllers', 'courseApp.cardServices',
		'courseApp.paymentControllers', 'courseApp.paymentServices',
		'courseApp.navigationControllers', 'courseApp.attendencyControllers',
		'courseApp.attendencyServices' ]);

angular.module('courseApp').config(function($stateProvider, $httpProvider) {
	$stateProvider.state('trainers', {
		url : '/trainers',
		templateUrl : '/views/userapp/trainers.html',
		controller : 'TrainerListController'
	}).state('viewTrainer', {
		url : '/trainers/:id/view',
		templateUrl : 'views/userapp/trainer-view.html',
		controller : 'TrainerViewController'
	}).
	// //////////////Courses/////////////////////////
	state('courses', {
		url : '/courses',
		templateUrl : 'views/userapp/courses.html',
		controller : 'CourseListController'
	}).state('viewCourse', {
		url : '/courses/:id/view',
		templateUrl : 'views/userapp/course-view.html',
		controller : 'CourseViewController'
	}).

	// ///////////////Child/////////////////////
	state('children', {
		url : '/children',
		templateUrl : '/views/userapp/child/all.html',
		controller : 'ChildListController'
	}).state('viewChild', {
		url : '/children/:id/view',
		templateUrl : '/views/userapp/child/view.html',
		controller : 'ChildViewController'
	})
}).run(function($state) {
	$state.go('trainers');
});