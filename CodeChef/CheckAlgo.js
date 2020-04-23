function CheckAlgo(str)
{
    var compstring ='';
    for(var i =0; i<str.length;i++ )
    {var Currentletter= str[i];
    var counter=1;
    while(Currentletter==str[i+1])
    {
        counter++;
        i++;
    }
    compstring += Currentletter + counter;
}

if (compstring.length >=str.length )
return str;
else    
return compstring;
}
var out = CheckAlgo("aabbccdddee");
console.log(out);