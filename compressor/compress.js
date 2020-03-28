 function frequency(str){
    var freqs = {};
    for (var i = 0; i<=str.length;i++){
        if (str[i] in freqs){
            freqs[str[i]] ++;
        }
        else{
            freqs[str[i]] = 1;
        }
  
     }

 }
 console.log(" frequency");    
 
 function sortfreq(freqs){
    var letters = [];
    for (var ch in freqs){
        letters.push([freqs[ch],ch]);
    }
    return letters.sort();
 
 }
 console.log(sortfreq({'a': 3, 'c': 2, 'b': 1, 'e': 5, 'd': 1, 'g': 1, 'f': 2}));
 
 console.log("  sort frequency");
 
 
 function buildtree(letters){
 
    while(letters.length>1){
        var leasttwo = letters.slice(0,2);
        var therest = letters.slice(2,letters.length);
        var combfreq = letters[0][0] + letters[1][0];
        letters = therest;
        console.log(letters);
        var two = [combfreq,leasttwo];
        letters.push(two);
        console.log(letters);
        letters.sort();
        return letters[0];
 }
 }
 
 console.log("  tree created");
 
 function trimtree( tree)
 {
    var p = tree[1];
    if (typeof p === 'string'){
        return p;
 }
    else
 {
        return (Array(trimtree(p[0]),trimtree(p[1])));
 }
 }
 node = (trimtree(letters));
 console.log(node);
 console.log("tree trimed");
 
 var codes = {};  
 function assigncodes(node,pat){
    pat = pat || "";
    if(typeof(node) == typeof("")){
        codes[node] = pat;
    }
    else{
        assigncodes(node[0],pat+"0");
        assigncodes(node[1],pat+"1");
    }
    return codes;
 }
 console.log(assigncodes(node));
 
 
 console.log("assign code");
 
 
 
 function encode(str){
    var output = "";
    frequency(read_string);
   letters = sortfreq(freqs);
   letters = buildtree(letters);
   tree = trimtree(letters);
   node  = (trimtree(tree));
   codes = assigncodes(node,"1")
    for (var i=0;i<str.length;i++){
        output = output+codes[str[i]];
    }
    return output;
 }
 console.log(" encoded");
 
 
 
 
 function decode(tree,str){
    var output="";
    var p=tree;
    for (var i=0;i<str.length;i++){
        if(str[i] == '0'){
            p=p[0];
            }
        else{
            p=p[1];
        }
        if (typeof p === 'string'){
            output = output +p;
            p=tree;
            }
    }
    return  output;
    }
 
 var fs = require("fs");
 var read_string = fs.readFileSync("string.txt");
 console.log(read_string);
 
 fs.writeFileSync("encoded.txt",encode(read_string))
 //fs.writeFileSync("encoded.txt",frequency(read_string))
 
 
 read_string = fs.readFileSync("encoded.txt");
 
 console.log(decode(tree,read_string));
 fs.writeFileSync("string.txt",decode(tree,read_string));   
