angular.module('courseApp.cardServices', []).factory('Card',
		function($resource) {
			return $resource('/discountCard/:id', {
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
