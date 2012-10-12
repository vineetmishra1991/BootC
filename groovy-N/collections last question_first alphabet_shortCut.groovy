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
Employee e6 = new Employee(name:"Bman s", department:"English", age:22, salary: 7000,empn:21)

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

println "In English department employees are"+ " "+m.get("English")def d4=m3.get("A").age>20?m3.get("A").name:"no"

count{it}



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
}
println m1.get("Computer")
def d1=m1.get("Computer").name 
def d2=m1.get("Civil").name 
def d3=m1.get("English").name


 Map er= ["Computer":d1,"Civil":d2,"English":d3]
*/
Map m3=li.groupBy{

return it.name[0]

}

/*
List l4=m3.get("A")
List l5=[]
l4.each{
if(it.age>20)
{
l5.add(it)
}
}

List l6=m3.get("a")
List l7=[]
l6.each{
if(it.age>20)
{
l7.add(it)
}
}

List l8=m3.get("a")
List l9=[]
l8.each{
if(it.age>20)
{
l9.add(it)
}
}
*/
//Map newc=["A":l5,"a":l7,"B":l9]

/*println newc.get("A").name



println newc.get("a").name


println newc.get("B").name
*/

Map map=[:]
List l1=[]
m3.each{
l1=[]
it.value.each{value->
println value.age
if(value.age>20){
l1.add(value.name)
}
println l1
map=map+["${it.key}":l1]
}
}
map