angular.module('courseApp.courseServices', []).factory('Course',
		function($resource) {
			return $resource('/course/:id', {
				id : '@id'
			}, {
				Update : {
					method : 'PUT'
				},
				Delete : {
					method : 'DELETE'
				}
			});
		}).service('popupService1', function($window) {
	this.showPopup = function(message) {
		return $window.confirm(message);
	}
});
