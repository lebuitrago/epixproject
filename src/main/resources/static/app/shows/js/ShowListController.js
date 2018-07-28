angular.module('epixApp.controllers.show', [])

	.controller('ShowListController',
			['$scope', '$state', '$stateParams', 'ShowResource',
			function($scope, $state, $stateParams, ShowResource) {
    			  $scope.shows = ShowResource.shows.query(
    		  		    {},
    					// SUCCESS
    					function(data){
                            console.log('Success: Successfully retrieved list of shows');
    					},
    					// ERROR
    					function(error){
    						console.log('Error: fetching list of shows --> ', error);
    					});
			}
	]);