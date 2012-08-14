/*
"touch /home/intelligrape/abc/myFile.txt".execute().text
File newFile= new File("/home/intelligrape/abc/myFile.txt")
File dir = new File("/home/intelligrape/abc/")
dir.eachFile {
    if (it.isFile())
        newFile.append(new File("$it").text)
}

*/
/*
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


li.groupBy{

it.age>20
}
*/

/*
def a={String a,String b->
println "$a,$b";
}
*/
//List p=[12,3,4]
//String t="hey"
//a("hey","there")


/*def myclosure={Strin,,43g name,int age ->
      println "hello, ${name}"
      println "roll no is ${age}"
      }
      
      myclosure("vineet",20)
      
      1.upto(4,name:"vineet",age:21)  //since upto can take two variables one is a an integer and the second can only be a closure with one argument only.
      
     */
     
     List<String> x=[1,2,3,"vineet",false]
     
    /* x.each{
    println it.getClass()
     }
     */
     def myclosure={myVar->
    println "hello"
     println it   
     }
     
     myclosure("was")