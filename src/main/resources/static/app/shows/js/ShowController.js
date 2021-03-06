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

    			    $scope.setSelected = function() {
                            console.log("This row has been clicked!");
                        };
			}
	])
	.controller('ShowViewController',
			['$scope', '$state', '$stateParams', 'ShowResource',
			function($scope, $state, $stateParams, ShowResource) {
    			  $scope.show = ShowResource.shows.get(
    			        {id: $stateParams.id},
    			        // SUCCESS
    			        function(data){
    			         },
    			        // ERROR
    			        function(error){
    			            console.log('Error: fetching show --> ', error);
    			        });
			}
	])
	;