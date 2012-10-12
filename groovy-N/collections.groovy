/*List l=9([];
l[11] = "myelement"
println l[11]
println l.get(5)
println l
*/

/*
List lin=(0..9)
List l=lin.findAll {it%2==0 }
print l */

/*
List l=[1,2,3,3]
println l
//Set s = l as Set   //as Set creates a new Setr with the same elements of the list while unique alters the original list 
l.unique();
println l
//println s
*/

/*
List l1=[11,12,13,14]
List l2=[13,14,15]
l1.disjoint(l2);
//List l3=l2-l1
//l3<<13


//print l3


*/

/*
List l2=[];
List l1=[11,12,13,14]
l1.eachWithIndex{p,index->
if(index%2!=0)
l2.add(p)
}
l1=l1-l2
*/

/*
List l1=[1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]
l1.each{
println it.class
}
l1.get(6).get(9)
*/

/*
List l=[14,12, 11,10, 16, 15,12, 10, 99, 90, 14, 16, 35];
List l2=[];
l.sort();
l2=l.reverse(); // reverse doesnot change the original list
print l2
*/

/*String s = "this string needs to be split"
println s.tokenize(" ")
println s.tokenize()*/

/*String s = "this string needs to be split"
println s.split(" ")
println s.split(/\s/)*/

/*String s2 = "are.you.trying.to.split.me.mister?"
s2.tokenize(".")
s2.split(".")
*/

/* 
Range r=0..9;
r.from
r.first()
r.first().next()*/

/* List l=[1,2,3,4,5,6,7,8,9,10];
l.each{
println "2*$it =" + 2*it;
}*/

/* List l=[1,2,3,4,5,6,7,8,9,10];
l.each{
println "12*$it =" + 12*it;
} */

/*List l=[31,42,32,34,95]
l.max() */


/*
l = (0..9) as List
l+=4
println l
Set s = l as Set
println s
*/
/*
Range r='a'..'z';
Range t='a'..'j';
println r-t*/

/*
String s="hello there wattasay ya"
int cnt=0;
s.each{
if(it=='t')
cnt++;

}
print cnt
*/
/*
[1,2,3,4,5,6,7,8,9,10].groupBy{if(it%2)return "odd" else return "even"}
*/
/*
List l=(1..100)
l.each
{
if(it%15==0)
{
 println "FizzBuzz"
}
else if(it%3==0)
 {
 println "Fizz"
 }
else if(it%5==0)
{
  println "Buzz"
}
println it
}
*/

/* Map frns = ["Vineet":23, "Puneet": 30, "Gaurav":22, "Sid": 20]

frns*.key
 frns*.value
println ""
 frns.each{
 print it
 print " "}
 */

/* Map gg=['a':12, 'e':323, 'r':"dada"]
 gg.class
 */

/* 
 Map m = ['1' : 2, '2' : 3, '3' : 4, '2':5]
m['2']
*/


/* m.containsKey('1');
*/
/*
class Stack
{
List l=[];
 def push(Integer item)
 {
   l.add(item); 
 }
 def popl()
 {
 def g=l.pop();
 println g
 }
 String toString()
 {
    l;
 }
}
Stack s=new Stack();

s.push(5);
s.push(6);
s.popl();
print s 
*/
/*
class Employee {
    String name
    Integer age
    String department
    BigDecimal salary    
}

Employee e1 = new Employee(name:"Amit", department:"Computer", age:222, salary: 5000)
Employee e2 = new Employee(name:"Aman", department:"Computer", age:212, salary: 15000)
Employee e3 = new Employee(name:"Amsd", department:"Civil", age:222, salary: 35000)
Employee e4 = new Employee(name:"Amisd", department:"Civil", age:252, salary: 25000)
Employee e5 = new Employee(name:"aman s", department:"English", age:2, salary: 500)
Employee e6 = new Employee(name:"Bman s", department:"English", age:22, salary: 500)

List li = [e1,e2,e3,e4,e5,e6]
li.findAll{it.salary>5000}.name
//li.collect{it}

li.min{
it.age
}.name

li.max{
it.salary
}.name

li.collect{
it.name
}
*/

/*
Map m = [‘Computing’ : [‘Computing’ : 600, ‘Information_Systems’ : 300],‘Engineering’ : [‘Civil’ : 200, ‘Mechanical’ : 100],‘Management’ : [‘Management’ : 800] ]

 m.collect
{
it.key

}

m.each{
if(it.key=="‘Computing’")
{
Map x=it.value
//x*.key
//x.get("‘Computing’")
 println x*.key
}
}

m.each{
if(it.key=="‘Engineering’")
{
Map z=it.value
//x*.key
//x.get("‘Computing’")
println z.get("‘Civil’")

}
}
*/

class Employee {
    String name
    Integer age
    String department
    Integer empn
    BigDecimal salary    
}

Employee e1 = new Employee(name:"Amit", department:"Computer", age:19, salary: 5050,empn:21)
Employee e2 = new Employee(name:"Aman", department:"Computer", age:24, salary: 15000,empn:22)
Employee e3 = new Employee(name:"Amsd", department:"Civil", age:16, salary: 35000,empn:21)
Employee e4 = new Employee(name:"Amisd", department:"Civil", age:30, salary: 25000,empn:21)
Employee e5 = new Employee(name:"aman s", department:"English", age:14, salary: 500,empn:21)
Employee e6 = new Employee(name:"Bman s", department:"English", age:18, salary: 7000,empn:21)

List li = [e1,e2,e3,e4,e5,e6]

/*
li.groupBy{

if(it.salary<=5000) return "Salary between 0 to 5000"

if(it.salary>5000&&it.salary<10000) return "Salary between 5000 to 10000"

if(it.salary>10000) return "Salary more than 10000"

}

Map m=li.groupBy{

it.department

}

println "In Computer department employees are"+ " "+m.get("Computer").count{it}

println "In Civil department employees are"+ " "+m.get("Civil").count{it}

print "In English department employees are"+ " "+m.get("English").count{it}



Map ui=li.groupBy{

if(it.age>18&&it.age<35) return "Age between 18 to 35"

else return "Age more than 35"

}

List p=ui.get("Age between 18 to 35")
p.collect{
it.name
}

Map m1=li.groupBy{

it.department

}

m1.each{

z=it.value
y=it.key

def d1=m1.get("Computer").name 
def d2=m1.get("Civil").name 
def d3=m1.get("English").name


 Map er= ["Computer":d1,"Civil":d2,"English":d3]
*/

Map m3=li.groupBy{

it.name

}


    
     
