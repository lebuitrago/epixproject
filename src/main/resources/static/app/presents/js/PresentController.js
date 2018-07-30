angular.module('epixApp.controllers.present', [])

	.controller('PresentController',
			['$scope', '$state', '$stateParams', 'PresentResource',
			function($scope, $state, $stateParams, PresentResource) {
    			  $scope.show = PresentResource.show.get(
    			  {id: $stateParams.id},
    			  // SUCCESS
    			  function(data){
    			  },
    			  // ERROR
    			  function(error){
    			    console.log('Error: fetching show for presentation --> ', error);
    			  });
			}
	])
	;