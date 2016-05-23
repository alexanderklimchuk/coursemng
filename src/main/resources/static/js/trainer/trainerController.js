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
		function($scope, $state, $stateParams, Trainer, Course) {

			$scope.trainer = new Trainer();

			$scope.courses = Course.query();

			$scope.trainerDobPopup = {
				opened : false
			};

			$scope.openTrainerDobPopup = function() {
				$scope.trainerDobPopup.opened = true;
			};
			$scope.dateOptions = {
				formatYear : 'yy',
				maxDate : new Date(),
				minDate : new Date(1955, 5, 22),
				startingDay : 1
			};

			$scope.addTrainer = function() {

				// $scope.trainer.courses = $scope.trainer.courses0;
				$scope.trainer.$save(function() {
					$state.go('trainers');
				});
			}

		}).controller('TrainerEditController',
		function($scope, $state, $stateParams, Trainer, Course) {
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

			$scope.courses = Course.query();
			$scope.loadTrainer();

			$scope.trainerDobPopup = {
				opened : false
			};

			$scope.openTrainerDobPopup = function() {
				$scope.trainerDobPopup.opened = true;
			};
			$scope.dateOptions = {
				formatYear : 'yy',
				maxDate : new Date(),
				minDate : new Date(1955, 5, 22),
				startingDay : 1
			};
		});