def myclosure={String name,int age ->
      println "hello, ${name}"
      println "roll no is ${age}"
      }
      
      myclosure("vineet",20)
      
      1.upto(4,name:"vineet",age:21)  //since upto can take two variables one is a an integer and the second can only be a closure with one argument only.