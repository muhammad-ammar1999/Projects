
function CompressList(list)
{var i=0, num = "", dot = ".",output ="" ,s="";
num =list[i];
output +=num;
for(i=0;i<list.length-1;)
{
    num =list[i]+1;
if(num=== list[i+1])
{
num.toString().split(",");
i++; 
num = dot;
output +=num;

//console.log(dot);
}
else
{//console.log(list[i+1]);
    s=list[i+1];
    s.toString().split(",");
    output +=s;
    i++;
}
}
return output;
}
function DecompressList(CompressedList)
{var i=0, num = "", dot = ".",output ="" ,s="";
num =list[i];
output +=num;
for(i=0;i<list.length-1;)
{
    num =list[i]+1;
if(num=== list[i+1])
{
num.toString().split(",");
i++; 
dot = num;
output +=dot;

//console.log(dot);
}
else
{//console.log(list[i+1]);
    s=list[i+1];
    s.toString().split(",");
    output +=s;
    i++;
}
}
return output;
}

var list = [1,2,3,5,6,8,9,10,11,14,15,17];

var CompressedList = CompressList(list);
console.log(CompressedList);
List = DecompressList(CompressedList);
console.log(List);