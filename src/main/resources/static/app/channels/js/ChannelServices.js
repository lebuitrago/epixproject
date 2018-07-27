angular.module('epixApp.services.channel', [])

.factory('ChannelResource', ['$resource',
    function($resource) {
		'use strict';

		return {
			channels: $resource('/api/v1/channels/:id',
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