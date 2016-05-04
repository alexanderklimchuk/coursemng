/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('courseApp.services', []).factory('Trainer',
		function($resource) {
			return $resource('/trainer/:id', 
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