angular.module('courseApp.paymentControllers', []).controller(
		'PaymentListController', function($scope, $state, $window, Payment) {

			$scope.payments = Payment.query();
			$scope.deletePayment = function(payment) {
				payment.$delete(function() {
					$scope.payments = Payment.query();
					$state.go('payments');
				});
			}
		}).controller('PaymentCreateController',
		function($scope, $state, $stateParams, Payment, Child, Course) {
			$scope.children = Child.query();
			$scope.courses = Course.query();
			$scope.payment = new Payment();
			$scope.addPayment = function() {
				$scope.payment.$save(function() {
					$state.go('payments');
				});
			}
		});