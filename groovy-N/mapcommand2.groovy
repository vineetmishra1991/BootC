/*def myMap=[name:"vineet","your name": 30] xyz,,my
myMap.each{println it}

myMap.getClass().name
myMap.getClass().name */

/* class Person{
static sayHello(){
println this
}
}
 
Person.sayHello() */

/* class Person {
String getName() {"vineet"}
}

Person p=new Person()
p.getName() //or p.name
;
*/

void showme(x,y=10)
{
println x+y
}

//showme(12)
//shome(12,5)

/* showme 12
showme 12,5  // this has become optional in groovy ie the paranthesis
*/
class MyClass
{
int x
MyClass plus(MyClass other) {
  new MyClass(x:this,x+other.x)
  }
  }
  
  MyClass m=new MyClass(x:2)

groovyc -j Country.groovy World.java