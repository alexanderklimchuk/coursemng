/**
 * Created by Sandeep on 01/06/14.
 */
angular.module('courseApp.controllers',[]).controller('TrainerListController',function($scope,$state,popupService,$window,Trainer){

    $scope.trainers=Trainer.query();

    $scope.deleteTrainer=function(trainer){
        if(popupService.showPopup('Really delete this?')){
            trainer.$delete(function(){
            	$scope.trainers=Trainer.query();
            	$state.go('trainers');
            });
        }
    }

}).controller('TrainerViewController',function($scope,$stateParams,Trainer){

    $scope.trainer=Trainer.get({id:$stateParams.id});

}).controller('TrainerCreateController',function($scope,$state,$stateParams,Trainer){

    $scope.trainer=new Trainer();

    $scope.addTrainer=function(){
        $scope.trainer.$save(function(){
            $state.go('trainers');
        });
    }

}).controller('TrainerEditController',function($scope,$state,$stateParams,Trainer){

	
    $scope.updateTrainer=function(trainer){
   
/*    $scope.entry = Trainer.get({ id: $stateParams.id}, function() {
    		  // $scope.entry is fetched from server and is an instance of Entry
    		  $scope.entry.$Update(function() {
    		    //updated in the backend
    		  });
    		});*/
    	$scope.trainer.$Update(function(){
            $state.go('trainers');
        });
 
    };

    $scope.loadTrainer=function(){
        $scope.trainer=Trainer.get({id:$stateParams.id});
    };

    $scope.loadTrainer();
});