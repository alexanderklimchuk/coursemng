angular.module('courseApp.courseServices',['ngResource']).factory('Course',
		function($resource) {
			return $resource('/course/:id', 
					{id : '@id'},
			{
				'update' : {
					method : 'PUT'
				},
				'delete' : {
					method: 'DELETE'
				}
			});
		}).service('popupService', function($window) {
	this.showPopup = function(message) {
		return $window.confirm(message);
	}
});