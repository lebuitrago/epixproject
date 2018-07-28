angular.module('epixApp.services.show', [])

.factory('ShowResource', ['$resource',
    function($resource) {
		'use strict';

		return {
			shows: $resource('/api/v1/shows/:id',
					{ id: '@id' },
					{
						'update' 	: 	{
							method: 'PUT'
						}
					}
			)
	   };
	}
]);