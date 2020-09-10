const fs = require('fs')  
fs.readFile('string.txt', 'utf-8', (err, data) => { 
	if (err) throw err; 

	console.log(data); 
    fs.writeFileSync("encoded.txt",data)
})



