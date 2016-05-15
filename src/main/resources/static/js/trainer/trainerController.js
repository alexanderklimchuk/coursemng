
angular.module('courseApp.trainerControllers',['courseApp.trainerServices']).controller('TrainerListController', function($scope,popupService,$window,Trainer){
    $scope.trainers=Trainer.query();

    $scope.deleteTrainer=function(trainer){
        if(popupService.showPopup('Really delete this?')){
            trainer.$delete(function(){
            	$scope.trainers=Trainer.query();
            	//$state.go('trainers');
            });
        }
    }

}).controller('TrainerViewController',function($scope,Trainer){

    $scope.trainer=Trainer.get({id:$stateParams.id});

		}).controller('TrainerCreateController',
		function($scope, Trainer) {

			$scope.trainer = new Trainer();

			$scope.addTrainer = function() {
				$scope.trainer.$save(function() {
					//$state.go('trainers');
				});
			}

		}).controller('TrainerEditController',function($scope,$stateParams,Trainer, Course){
	
    $scope.updateTrainer=function(trainer){
    	$scope.trainer.$Update(function(){
            //$state.go('trainers');
        });
 
    };

    $scope.loadTrainer=function(){
        $scope.trainer=Trainer.get({id:$stateParams.id});
    };
    $scope.courses=Course.query();

    $scope.loadTrainer();
});