//0.step(10,2) {print it+" "};
//3.times {print it} //loop

//"ls".execute().getText() //run the system commands like ls

//navigational operator or safe referential operator
//if(str!=null) str.reverse()but in groovy
/*String str=null
str?.reverse()  //this checks that if str is not null then call reverse function

def f=new File("abc.txt")
println f.getClass().getName()*/

/*def x=10
def y=x?x :20 */

//?: elvis operator

/*def x=10;
def y=x?:20;  //it will display value of x and elseif x is null then print 20 */
 
/* def x=[1,2,3,"vineet",false]
 x.each{println it.class.name}
 x<<30   //adding an element to the list
/*  List<String> x=[1,2,3,"vineet",false] //only String */
*/


def myMap=[name:"vineet","your name": 30]
myMap.each{println it}