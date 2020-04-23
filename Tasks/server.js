var http = require ("http");
var port= 3000;
http.createServer(function(req,res){
   res.writeHead(200,{"Content-Type":"text/plain"});
   res.end("node js sends get request on 200")
}).listen(port); 
console.log("server is hosted on port ",port);
   
