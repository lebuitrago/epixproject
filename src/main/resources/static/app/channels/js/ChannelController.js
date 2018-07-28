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
	])
	.controller('ChannelViewController',
			['$scope', '$state', '$stateParams', 'ChannelResource',
			function($scope, $state, $stateParams, ChannelResource) {
    			  $scope.channel = ChannelResource.channels.get(
    			  {id: $stateParams.id},
    			  // SUCCESS
    			  function(data){
    			  },
    			  // ERROR
    			  function(error){
    			    console.log('Error: fetching channel --> ', error);
    			  });
			}
	])
	;