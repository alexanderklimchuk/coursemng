angular.module('courseApp.trainerServices', ['ngResource']).factory('Trainer',
		function($resource) {
			return $resource('/trainer/:id', {
				id : '@id'
			}, {
				Update : {
					method : 'PUT'
				},
				Delete : {
					method : 'DELETE'
				}
			});
		}).service('popupService', function($window) {
	this.showPopup = function(message) {
		return $window.confirm(message);
	}
});