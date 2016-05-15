angular.module('courseApp.parentServices', []).factory('Parent',
		function($resource) {
			return $resource('/parent/:id', {
				id : '@id'
			}, {
				Update : {
					method : 'PUT'
				},
				Delete : {
					method : 'DELETE'
				}
			});
		}).factory('Clientstatus', function($resource) {
	return $resource('/clientstatus/:id', {
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
