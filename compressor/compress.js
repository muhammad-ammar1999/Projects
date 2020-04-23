var readstring ="compressor is ready";
code=[] ,pat='';
console.log(readstring)
function Frequency(str)
{
var Frequencies={};
for (var i in str)
{

    if(Frequencies[str[i]]==undefined)
{
Frequencies[str[i]]=1;
}
else 
{
Frequencies[str[i]]=Frequencies[str[i]]+1;
}
}

return Frequencies;
}

function sortfreq(Frequencies)
{
    var Nodes=[];
    for( var let in Frequencies)
    {
    Nodes.push([Frequencies[let],let]);
    }
    return Nodes.sort();
    }
    
    a=Frequency(readstring);

    function buildtree(Nodes)
    {
        while(Nodes.length>1)
        {
        var leasttwo=[Nodes[0][1],Nodes[1][1]];
        var rest=Nodes.slice(2,Nodes.length);
        var combfreq=Nodes[0][0]+Nodes[1][0];
        Nodes=rest;
        end=[combfreq,leasttwo];
        Nodes.push(end)
        Nodes.sort();
        }
        return Nodes[0][1];
        }   
      tree=buildtree(sortfreq(a));   
      
      
      function assignCode(node,pat)  
      {  
          if(typeof(node)==typeof(""))  
               code[node]=pat;  
          else  
          {  
              assignCode( node[0], pat+'0');  
              assignCode( node[1], pat+'1');  
          }  
      }  
       assignCode(tree,pat);  

      
      function encode(string)  
      {  
          output='';  
          for(s in string)  
              output+=code[string[s]];  
          return output;  
      }  
     encoded=encode(readstring);  
      console.log("Encoded Form:",encoded);  
      

           
  function decode(tree,encoded)  
  {  
      output='';  
      p=tree;  
      for(bit in encoded)  
      {  
          if(encoded[bit]=='0')  
          p=p[0];  
          else  
              p=p[1];  

          if(typeof(p)==typeof(''))  
         {  
          output+=p;  
          p=tree;  

          }  
      }  
      return output;  
  }  

  decoded=decode(tree,encoded);  
 console.log("Decoded Form:",decoded);  



