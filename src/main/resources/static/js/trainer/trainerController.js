angular.module('courseApp.trainerControllers', []).controller(
		'TrainerListController',
		function($scope, $state, popupService, $window, Trainer) {
			$scope.trainers = Trainer.query();
			$scope.deleteTrainer = function(trainer) {
				if (popupService.showPopup('Really delete this?')) {
					trainer.$delete(function() {
						$scope.trainers = Trainer.query();
						$state.go('trainers');
					});
				}
			}
		}).controller('TrainerViewController',
		function($scope, $stateParams, Trainer) {

			$scope.trainer = Trainer.get({
				id : $stateParams.id
			});

		}).controller('TrainerCreateController',
		function($scope, $state, $stateParams, Trainer) {

			$scope.trainer = new Trainer();

			$scope.addTrainer = function() {
				$scope.trainer.$save(function() {
					$state.go('trainers');
				});
			}

		}).controller('TrainerEditController',
		function($scope, $state, $stateParams, Trainer) {

			$scope.updateTrainer = function(trainer) {
				$scope.trainer.$Update(function() {
					$state.go('trainers');
				});

			};

			$scope.loadTrainer = function() {
				$scope.trainer = Trainer.get({
					id : $stateParams.id
				});
			};

			$scope.loadTrainer();
		});