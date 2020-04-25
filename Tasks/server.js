// var http = require ("http");
// var port= 3000;
// http.createServer(function(req,res){
   // res.writeHead(200,{"Content-Type":"text/plain"});
   // res.end("node js sends get request on 200")
// }).listen(port); 
//console.log("server is hosted on port ");
var express = require("express");
var app= express();
var mysql = require("mysql");

var mysqlConnection=mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password:'',
    database:'FirstDataBase'
});
mysqlConnection.connect(function(error){
if(!error){
    console.log("error");
}else{
    console.log("Connected");
}
});
app.get("/",function(req,resp){
   mysqlConnection.query("SELECT * FROM FirstTable   ",function(error,row,fields)
   {
    if(!error){
        console.log("query failed");
    }else{
        console.log("qurey succes");
        console.log(row);
        resp.send("hello"+row);
    }
   }

   
);
})
app.listen(1337)

