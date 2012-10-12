class Student
{
String name
int age
int classStudying
String toString(){
return name
}
/*
int hashCode() {
this.name.hashCode()
}
boolean equals(Object other) {
this.name==other.name
}
*/
}

Student s1=new Student(name:"Vineet",age:21,classStudying:16)
Student s2=new Student(name:"Vineet",age:22,classStudying:17)
Student s3=new Student(name:"Sachin",age:23,classStudying:18)
Student s4=new Student(name:"Himanshu",age:24,classStudying:19)
Student s5=new Student(name:"seerat",age:25,classStudying:20)
Student s6=new Student(name:"Abdullah",age:16,classStudying:21)

Set<Student> students=[s1,s2,s3,s4,s5,s6] as Set<Student>

println "Age of students whose name is unique: " + "\n" + students.unique{
it.name
}.age

println ""

println "Name of students whose name starts with 's' or 'V' are : " + "\n" + students.findAll{
it.name.charAt(0)=='s'||it.name.charAt(0)=='V'
}

println ""

println  "Students having age greater than 21: " + "\n" + students.findAll{
it.age>21
}

println ""

println  "Students having age greater than 20 and less than 24 : " + "\n" + students.findAll{
(it.age>20 && it.age<24)
}

students.add(s2)

println ""

println "Name of students whose name is unique and having age greater than 20 and less than 24: " + "\n" + students.unique{
it.name
}.findAll{(it.age>20 && it.age<24)}


students.add(s2)

println ""

println "Name of student whose age is maximum: " + "\n" + students.max{
it.age
}

println ""

println "Name of students in ascending order (order by age): " + "\n" + students.sort{it.age}

println ""

println "Name of students in descending order (order by age): " + "\n" + students.sort{it.age}.reverse()

println ""

println "Name of students with age doubled: " 

List<Student> studentAgeDoubled = students.collect{
it.age=it.age*2
it
}
studentAgeDoubled.each{
println it.name + ":" + " " + it.age
} 

println ""

println "Printing name of students joined by a comma: " + "\n" +studentAgeDoubled*.name.join(',')

println ""

println "Checking if a file (/home/intelligrape/vineet/ts.html) exists or not: "
File myFile = new File("/home/intelligrape/vineet/ts.html")

if(myFile.exists())
{println "I do Exist"}
else 
{println "I Don't Exist"}

println ""

println "Checking if a file (/home/intelligrape/vineet/two.html) exists or not: "
File myFile1 = new File("/home/intelligrape/vineet/two.html")

if(myFile1.exists())
{println "I do Exist"}
else 
{println "I Don't Exist"}

println ""
 
println "Listing Files in a Directory (/home/intelligrape/vineet/): "
File dir = new File("/home/intelligrape/vineet/")
dir.eachFile {
    if(it.isFile())
    {
    println "$it"
    }
  }

println ""





