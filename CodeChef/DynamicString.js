var Frequencies={};
function Frequency(str)
{

for (var i in str)
{

    if(Frequencies[str[i]]==undefined)
{
Frequencies[str[i]]=1;
}
else 
{
Frequencies[str[i]]=Frequencies[str[i]]+1;
}}

return Frequencies;
}
   

function Dynamic(Frequencies)
{
   // console.log("yes");
//var i =26;
//var str;
for ( var i in Frequencies)
{
    console.log(Frequencies[i]);
console.log(Frequencies+1);
console.log(Frequencies+2);
    //  if( i==(i+1)+(i+2))
// {
    // console.log("yes");
// }
// else 
// {
    // console.log("NO");
// }
}
}

var a = "aaaabbcc"
var b = Frequency(a);
Dynamic(b);