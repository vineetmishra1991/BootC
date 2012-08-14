class Person
{
 def name;
 def age;
}
Person p=new Person(name:"vineet",age:20);
println p.name
println p.age

0.upto(3){println it + " "}
0.upto(3,{println it + " "})  // the code block which we are passing in the upto function is a closure ie closure is passed as a parameter to the function.

def myclosure={ println "hello"; // defining a closure and another way of doing the above.
      it;}
0.upto(3,myclosure); 

myclosure("vineet");  //callin the closure 'myclosure'
//myclosure(x:10,y:20);    

def myclosure={myVar->
    println "hello"
     println it   
     }
