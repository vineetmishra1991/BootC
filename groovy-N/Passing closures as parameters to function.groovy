/*def sum={int a,int b->

int c=a+b;
println c

}

sum(5,6)
*/

// Passing closure as a parameter
def sum(int c,Closure doSum){

 c = c + doSum(5,6)
    println "Value of c is: "+c
}

sum(5,{int a,int b-> 
    println a
    println b
return a+b
})


/*
def sum(){
int c=0;
c=c+sum1(5,6)
println "Value of c is: "+c
}*/

/*def sum(int g,Closure abc){
a=a+abc(5,8)
println a
}

sum(5,{int a,int b-> println a;

println b;
println a+b;
return a+b
})*/
