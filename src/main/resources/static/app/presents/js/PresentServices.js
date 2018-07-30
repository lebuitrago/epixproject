angular.module('epixApp.services.present', [])

.factory('PresentResource', ['$resource',
    function($resource) {
		'use strict';

		return {
			show: $resource('/api/v1/shows/:id',
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