angular.module('epixApp.controllers.present', [])

	.controller('PresentController',
			['$scope', '$state', '$sce', '$stateParams', 'PresentResource',
			function($scope, $state, $sce, $stateParams, PresentResource) {
    			  $scope.show = PresentResource.show.get(
    			  {id: $stateParams.id},
    			  // SUCCESS
    			  function(data){
    			    // Build the video source URL on success response from service call
    			    $scope.getVideoSource = 'https://www.youtube.com/embed/' + data.video_code + '?rel=0';
    			  },
    			  // ERROR
    			  function(error){
    			    console.log('Error: fetching show for presentation --> ', error);
    			  });

                  $scope.trustSource = function(src) {
                    return $sce.trustAsResourceUrl(src);
                  };
			}
	])
	;