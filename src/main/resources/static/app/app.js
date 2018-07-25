/* When adding a new css file
 * 1) Add the bower_component directory location to index.html for this new CSS file
 * 2) Add to gulpfile.js in 'minify-css' section
 * */

/* When adding a new library/module
 * 1) Bower install
 * 2) Add to module below
 * 3) Add to gulpfile.js
 * 4) Add to karma.conf.js
 * */

/* When adding a new Service
 * 1) Create new XXXServices.js in static/app/xxx/js/yyy
 * 2) Add to module below
 * 3) Add to index.html
 */

var app = angular.module('epixApp', [
	'ui.router',
	'ngResource'
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
            // you can set this to no template if you just want to use the html in the page
            .state('home', {
                url: "/",
                templateUrl: "app/home.html",
                data: {
                    pageTitle: 'Home'
                }
            })
            ;
		}
]);