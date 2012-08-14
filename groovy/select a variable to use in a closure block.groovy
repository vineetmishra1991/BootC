def myclosure={String myVar->       // here we are defining that we want to use the myVar variable if we give the it variable inside thje closure it will show an error here we also declare that we want a string to be passed to the closure but if we pass an
                                       //integer it will show error
println myVar                 
}

myclosure(10);