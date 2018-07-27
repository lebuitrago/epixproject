angular.module('epixApp.controllers.channel', [])

	.controller('ChannelListController',
			['$scope', '$state', '$stateParams', 'ChannelResource',
			function($scope, $state, $stateParams, ChannelResource) {
    			  $scope.channels = ChannelResource.channels.query(
    		  		    {},
    					// SUCCESS
    					function(data){
                            console.log('Success: Successfully retrieved list of channels');
    					},
    					// ERROR
    					function(error){
    						console.log('Error: fetching list of channels --> ', error);
    					});
			}
	]);