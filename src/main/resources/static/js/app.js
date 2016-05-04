/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('courseApp',['ui.router','ngResource','courseApp.controllers','courseApp.services']);

angular.module('courseApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('trainers',{
        url:'/trainers',
        templateUrl:'/views/trainers.html',
        controller:'TrainerListController'
    }).state('viewTrainer',{
       url:'/trainers/:id/view',
       templateUrl:'views/trainer-view.html',
       controller:'TrainerViewController'
    }).state('newTrainer',{
        url:'trainer/views/new',
        templateUrl:'views/trainer-add.html',
        controller:'TrainerCreateController'
    }).state('editTrainer',{
        url:'/trainers/:id/edit',
        templateUrl:'views/trainer-edit.html',
        controller:'TrainerEditController'
    }).state('courses',{
        url:'/courses',
        templateUrl:'partials/courses.html',
        controller:'CourseListController'
    });
}).run(function($state){
   $state.go('trainers');
});