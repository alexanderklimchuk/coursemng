angular.module('courseApp.services').factory('Course',function($resource){
    return $resource('/course/:id',{id:'@_id'},{
        update: {
            method: 'PUT'
        }
    });
})