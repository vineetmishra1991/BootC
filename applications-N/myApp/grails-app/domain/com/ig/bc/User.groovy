package com.ig.bc

import org.apache.commons.beanutils.converters.IntegerArrayConverter
import org.apache.commons.beanutils.converters.LongArrayConverter

class User {
    String name;
    String age;
    Integer num;

    static constraints = {
//        num(nullable: true)

//        age(nullable: false)

    }
}