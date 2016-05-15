//angular.module('courseApp',['ui.bootstrap','ngRoute','ngResource','courseApp.controllers','courseApp.services']);

var app = angular.module('courseApp', [ 'ngRoute', 'courseApp.courseControllers',
		'courseApp.courseServices', 'courseApp.trainerControllers',
		'courseApp.trainerServices' ]).controller('MainController', function($scope, $route, $routeParams, $location) {
    $scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
}).config(function($routeProvider, $locationProvider){
    $routeProvider
      .when('/trainer/view',{
          templateUrl: '/views/trainers.html',
          controller: 'TrainerListController'
      }).when('/trainer/:id/view', {
		templateUrl : 'views/trainer-view.html',
		controller : 'TrainerViewController'
	}).when('trainer/new', {
		templateUrl : 'views/trainer-add.html',
		controller : 'TrainerCreateController'
	}).when('/trainer/:id/edit', {
		templateUrl : 'views/trainer-edit.html',
		controller : 'TrainerEditController'
	}).
	
	
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	when('/course/view', {
		templateUrl : 'views/courses.html',
		controller : 'CourseListController'
	}).when('course/new', {
		templateUrl : 'views/course-add.html',
		controller : 'CourseCreateController'
	}).when('/course/:id/view', {
		templateUrl : 'views/course-view.html',
		controller : 'CourseViewController'
	}).when('/course/:id/edit', {
		templateUrl : 'views/course-edit.html',
		controller : 'CourseEditController'
	})
      $locationProvider.html5Mode(true);
});



/*angular.module('courseApp').config(function($stateProvider, $httpProvider) {
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
	// ///////////////////////////////////////////////////////////////////////////////////////////////
	state('courses', {
		url : '/courses',
		templateUrl : 'views/courses.html',
		controller : 'CourseListController'
	}).state('newCourse', {
		url : 'course/views/new',
		templateUrl : 'views/course-add.html',
		controller : 'CourseCreateController'
	}).state('viewCourse', {
		url : '/courses/:id/view',
		templateUrl : 'views/course-view.html',
		controller : 'CourseViewController'
	}).state('editCourse', {
		url : '/courses/:id/edit',
		templateUrl : 'views/course-edit.html',
		controller : 'CourseEditController'
	})
}).run(function($state) {
	$state.go('trainers');
});*/