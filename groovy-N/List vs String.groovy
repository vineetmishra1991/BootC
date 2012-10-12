String s=new String("hey")
println s
def g=s as List

class Dog{def x;
Dog(){x="tommy";
}
String toString(){return x;}
}

g<<new Dog()

println g