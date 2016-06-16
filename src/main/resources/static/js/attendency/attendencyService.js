angular.module('courseApp.attendencyServices', []).factory('Attendency',
		function($resource) {
			return $resource('/attendency/:id', {
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
