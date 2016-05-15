angular.module('courseApp.childServices', []).factory('Child',
		function($resource) {
			return $resource('/child/:id', {
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
