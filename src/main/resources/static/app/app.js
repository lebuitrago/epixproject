/* When adding a new css file
 * 1) Add the /js directory location to index.html for this new CSS file
 * 2) Add to gulpfile.js in 'minify-css' section - if using gulp
 * */

/* When adding a new library/module
 * 1) Bower install
 * 2) Add to module below
 * 3) Add to gulpfile.js     - if using gulp
 * 4) Add to karma.conf.js   - if using gulp
 * 5) Move *.js file to /js
 * 6) update index.html with correct /js path
 * */

/* When adding a new Service
 * 1) Create new XXXServices.js in static/app/xxx/js/yyy
 * 2) Add to module below
 * 3) Add to index.html
 */

var app = angular.module('epixApp', [
	'ui.router',
	'ngResource',
    'epixApp.controllers.channel',
    'epixApp.controllers.show',
    'epixApp.controllers.present',
    'epixApp.services.channel',
    'epixApp.services.show',
    'epixApp.services.present'
]);

// function for dynamic load with requirejs of a javascript module for use with a view
// in the state definition call add property `resolve: req('/views/ui.js')`
// or `resolve: req(['/views/ui.js'])`
// or `resolve: req('views/ui')`
function req(deps) {
    if (typeof deps === 'string') deps = [deps];
    return {
        deps: function ($q, $rootScope) {
            var deferred = $q.defer();
            require(deps, function () {
                $rootScope.$apply(function () {
                    deferred.resolve();
                });
                deferred.resolve();
            });
            return deferred.promise;
        }
    }
}

app.directive( 'updateTitle', ['$rootScope', '$timeout',
    function ($rootScope, $timeout) {
	    return {
	        link: function (scope, element) {
	            var listener = function (event, toState) {
	                var title = 'Project Name';
	                if (toState.data && toState.data.pageTitle) title = toState.data.pageTitle + ' - ' + title;
	                $timeout(function () {
	                    element.text(title);
	                }, 0, false);
	            };

	            $rootScope.$on('$stateChangeSuccess', listener);
	        }
	    };
	}
]);

app.config([ '$stateProvider', '$urlRouterProvider', '$locationProvider',
		function($stateProvider, $urlRouterProvider, $locationProvider) {
	 		// Removes the '#!' from the URL
			// Source: https://stackoverflow.com/questions/41214312/exclamation-mark-after-hash-in-angularjs-app
			$locationProvider.hashPrefix('');

			// For any unmatched url, send to /
			$urlRouterProvider.otherwise("/")

			$stateProvider
			/* **********	CHANNELS	********** */
            .state('channels', {
                url: 			'/channels',
                templateUrl: 	'app/channels/views/channels.html',
                controller: 	'ChannelListController'
            })
            .state('viewChannel', {
                url: 			'/channels/:id',
                templateUrl: 	'app/channels/views/channel-view.html',
                controller: 	'ChannelViewController'
            })
            .state('viewChannelShows', {
                url: 			'/channels/:id/shows',
                templateUrl: 	'app/channels/views/channel-shows-view.html',
                controller: 	'ChannelShowsViewController'
            })

			/* **********	SHOWS	********** */
            .state('shows', {
                url: 			'/shows',
                templateUrl: 	'app/shows/views/shows.html',
                controller: 	'ShowListController'
            })
            .state('viewShow', {
                url: 			'/shows/:id',
                templateUrl: 	'app/shows/views/show-view.html',
                controller: 	'ShowViewController'
            })

			/* **********	PRESENTATIONS	********** */
            .state('presents', {
                url: 			'/presents/show/:id',
                templateUrl: 	'app/presents/views/presents.html',
                controller: 	'PresentController'
            })
            ;
		}
]);