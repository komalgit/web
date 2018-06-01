/* app.js */

var net = require('net');

var HOST = 'localhost';
var PORT = 6969;

net.createServer(function(sock) {
	// Receives a connection - a socket object is associated to the connection automatically console.log('CONNECTED: ' + sock.remoteAddress +':'+ sock.remotePort);

	console.log('Connected: ' + sock.remoteAddress + "on port : " + sock.remotePort + new Date());

	sock.on('data', function(data){
		sock.write(data);

	});


	sock.on('close', function(data) {
		console.log('CLOSED : ' + sock.remoteAddress + "port: " + sock.remotePort);
	});


}).listen(PORT, HOST);

console.log('Server started on ' + HOST + "port : " + PORT);