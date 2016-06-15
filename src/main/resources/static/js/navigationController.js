angular.module('courseApp.navigationControllers', []).controller(
		'NavigationController', function($scope, $http, $location, $state) {

			var self = this;

			self.tab = function(route) {
				return $state.current && route === $state.current.controller;
			};

			var authenticate = function(credentials, callback) {

				var headers = credentials ? {
					authorization : "Basic "
							+ btoa(credentials.username + ":"
									+ credentials.password)
				} : {};

				$http.get('user', {
					headers : headers
				}).then(function(response) {
					if (response.data.name) {
						$scope.authenticated = true;
					} else {
						$scope.authenticated = false;
					}
					callback && callback($scope.authenticated);
				}, function() {
					$scope.authenticated = false;
					callback && callback(false);
				});

			}

			authenticate();

			self.credentials = {};
			self.login = function() {
				authenticate(self.credentials, function(authenticated) {
					if (authenticated) {
						console.log("Login succeeded")
						$location.path("/");
						self.error = false;
						$scope.authenticated = true;
					} else {
						console.log("Login failed")
						$location.path("/login");
						self.error = true;
						$scope.authenticated = false;
					}
				})
			};

			self.logout = function() {
				$http.post('logout', {}).finally(function() {
					$scope.authenticated = false;
					$location.path("/");
				});
			}

		}).controller('home', function($http) {
	var self = this;
/*
 * $http.get('/resource/').then(function(response) { self.greeting =
 * response.data; })
 */
			
			
			
			
		});