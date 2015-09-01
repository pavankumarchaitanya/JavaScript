

var response = serviceCall();

var redis = require('redis');
var client = redis.createClient();

client.on('connect', function() {
    console.log('connected');
});

client.set('framework', response, function(err, reply) {
	console.log("In call back function of set");
  console.log(reply);
});




client.get('framework', function(err, reply) {
    console.log("In call back function of get");
});



console.log(process._getActiveHandles());
console.log(process._getActiveRequests());

function serviceCall(){

return "Test Script, just looking for a long string to tryout persisting to redis and retrieve back";
}
