angular.module('courseApp.paymentServices', []).factory('Payment',
		function($resource) {
			return $resource('/payment/:id', {
				id : '@id'
			}, {
				Update : {
					method : 'PUT'
				},
				Delete : {
					method : 'DELETE'
				}
			});
		});
