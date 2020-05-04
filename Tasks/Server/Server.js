
var express = require("express");
var app= express();
var mysql = require("mysql");
var connection = mysql.createConnection({
host:"localhost",
user: "root",
password: "",
database: "articals"
});
connection.connect(function(error){
    if(error){
        console.log(error);
    }else{
        console.log("connected to DataBase articals");
    }
});
connection.query('SELECT * FROM vowels', (err,rows) => {
    if(err) throw err;
  
    console.log('Data received from Db:');
    console.log(rows);
  });
