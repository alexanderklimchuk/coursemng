angular.module('courseApp.controllers').controller('CourseListController',function($scope,$state,$window,Course){

    $scope.courses=Course.query();
})