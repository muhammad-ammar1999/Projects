var express = require("express");
var app = express();
var mysql = require("mysql");
var connection = mysql.createConnection({
host:"localhost",
user: "root",
password: "",
database: "ShopMS"
});
connection.connect(function(error){
    if(error){
        console.log(error);
    }else{
        console.log("connected to DataBase ShopMS");
    }
});
connection.query('SELECT * FROM outlet', (err,rows) => {
    if(err) throw err;
  
    console.log('Data received from inventory:');
    console.log(rows);
  });
 app.get("/",function(req,resp){
    connection.query(" SELECT * FROM inventory" ,function(error,row,fields)
     {
      if(error){
         console.log("query failed");
     }else{
         console.log("qurey succes");
         console.log(row.TOJSON);
         resp.send("hello"+row.TOJSON);
     }
    });
 })
 app.listen(1337);