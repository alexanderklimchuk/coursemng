/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('courseApp',['ui.router','ngResource','courseApp.controllers','courseApp.services']);

angular.module('courseApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('trainers',{
        url:'/trainers',
        templateUrl:'partials/trainers.html',
        controller:'TrainerListController'
    }).state('viewTrainer',{
       url:'/trainers/:id/view',
       templateUrl:'partials/trainer-view.html',
       controller:'TrainerViewController'
    }).state('newTrainer',{
        url:'/trainers/new',
        templateUrl:'partials/trainer-add.html',
        controller:'TrainerCreateController'
    }).state('editTrainer',{
        url:'/trainers/:id/edit',
        templateUrl:'partials/trainer-edit.html',
        controller:'TrainerEditController'
    }).state('courses',{
        url:'/courses',
        templateUrl:'partials/courses.html',
        controller:'CourseListController'
    });
}).run(function($state){
   $state.go('trainers');
});