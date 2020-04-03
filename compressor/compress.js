var readstring ="gksdkgspdkgkdgkdfsk sdkdfkgdgkdg 1234214 &&&&&!@";
code=[] ,pat=''

function Frequency(str)
{
var Freq={};
for (var i in str)
{

    if(Freq[str[i]]==undefined)
{
Freq[str[i]]=1;
}
else 
{
Freq[str[i]]=Freq[str[i]]+1;
}
}

return Freq;
}

function sortfreq(Freq)
{
    var tuples=[];
    for( var let in Freq)
    {
    tuples.push([Freq[let],let]);
    }
    return tuples.sort();
    }
    
    a=Frequency(readstring);

    function buildtree(tuples)
    {
        while(tuples.length>1)
        {
        var leasttwo=[tuples[0][1],tuples[1][1]];
        var rest=tuples.slice(2,tuples.length);
        var combfreq=tuples[0][0]+tuples[1][0];
        tuples=rest;
        end=[combfreq,leasttwo];
        tuples.push(end)
        tuples.sort();
        }
        return tuples[0][1];
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



