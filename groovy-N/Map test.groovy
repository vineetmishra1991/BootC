Range r=2..<9
println r

def map=[:]
map.put('name','Vineet')
map.get('name')
def map2=['age':10,'class':'engg']
map.putAll(map2)
assert map==['name':'Vineet','age':10,'class':'engg']

//println map.keySet()

/*map.every{key,value->
value instanceof String
}
*/

/*map.eachWithIndex{key,value,index->
println "${index}"
if(key=='age'){
if(value instanceof Integer){
println "I am integer with key as 'AGE' having index $index"
}
}
}*/
/*map.groupBy{key,value->
if(value instanceof String){return "I am String"}
else return "I am not a String"
}*/

/*map.any{key,value->
value instanceof Integer  //Will check if any element in the map satisfies the given condition inside the closure block whereas in every all elements in the map must satisfy the given condition
}*/

//map.sort()

 /*def newMap=map.toMapString()
 println newMap
 //println newMap.tokenize(':')
def mapNew=newMap.tokenize('[&]&:&,')
mapNew.each{println it}
*/





