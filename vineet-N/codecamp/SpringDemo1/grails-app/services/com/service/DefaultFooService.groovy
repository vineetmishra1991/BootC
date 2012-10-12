package com.service

import apackage.Foo

class DefaultFooService {


    public Foo getFoo(String name, int age) {
        return new Foo(name, age);
    }

    public void businessService() throws NullPointerException{
        println("helllllllllllllllllllllllllllllllllllllll")
        throw new NullPointerException()
    }
}
