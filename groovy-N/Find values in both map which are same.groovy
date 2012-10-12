Map m=['name':"Vineet",'age':"20"]

Map n=['name':"Vineet",'age':"25"]

Map p=[:]

def i=0;

m.each{key,value->

if(n.containsKey(key))
{
   if(n.containsValue(value)){
   
   p.put(key,value)
  
   }
   
}
}
println p

