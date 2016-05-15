/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('courseApp', [ 'ui.router', 'ngResource',
		'courseApp.trainerControllers', 'courseApp.trainerServices',
		'courseApp.courseServices', 'courseApp.courseControllers',
		'courseApp.childControllers', 'courseApp.childServices',
		'courseApp.parentControllers', 'courseApp.parentServices' ]);

angular.module('courseApp').config(function($stateProvider, $httpProvider) {
	$stateProvider.state('trainers', {
		url : '/trainers',
		templateUrl : '/views/trainers.html',
		controller : 'TrainerListController'
	}).state('viewTrainer', {
		url : '/trainers/:id/view',
		templateUrl : 'views/trainer-view.html',
		controller : 'TrainerViewController'
	}).state('newTrainer', {
		url : 'trainer/views/new',
		templateUrl : 'views/trainer-add.html',
		controller : 'TrainerCreateController'
	}).state('editTrainer', {
		url : '/trainers/:id/edit',
		templateUrl : 'views/trainer-edit.html',
		controller : 'TrainerEditController'
	}).
	// //////////////Courses/////////////////////////
	state('courses', {
		url : '/courses',
		templateUrl : 'views/courses.html',
		controller : 'CourseListController'
	}).state('addCourse', {
		url : '/course/views/new',
		templateUrl : 'views/course-add.html',
		controller : 'CourseCreateController'
	}).state('editCourse', {
		url : '/courses/:id/edit',
		templateUrl : 'views/course-edit.html',
		controller : 'CourseEditController'
	}).
	// ///////////////Child/////////////////////
	state('newChild', {
		url : '/children/views/new',
		templateUrl : 'views/child/add.html',
		controller : 'ChildCreateController'
	}).state('children', {
		url : '/children',
		templateUrl : '/views/child/all.html',
		controller : 'ChildListController'
	}).state('viewChild', {
		url : '/children/:id/view',
		templateUrl : '/views/child/view.html',
		controller : 'ChildViewController'
	}).state('editChild', {
		url : '/children/:id/edit',
		templateUrl : 'views/child/edit.html',
		controller : 'ChildEditController'
	}).
	// ////////////////Parents/////////////////////
	state('parents', {
		url : '/parents',
		templateUrl : '/views/parent/all.html',
		controller : 'ParentListController'
	}).state('addParent', {
		url : '/parent/views/new',
		templateUrl : 'views/parent/add.html',
		controller : 'ParentCreateController'
	}).state('viewParent', {
		url : '/parent/:id/view',
		templateUrl : '/views/parent/view.html',
		controller : 'ParentViewController'
	}).state('editParent', {
		url : '/parent/:id/edit',
		templateUrl : '/views/parent/edit.html',
		controller : 'ParentEditController'
	})
}).run(function($state) {
	$state.go('trainers');
});