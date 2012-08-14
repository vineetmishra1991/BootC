package com.ig.bc

import org.apache.commons.beanutils.converters.IntegerArrayConverter
import org.apache.commons.beanutils.converters.LongArrayConverter

class User {
    String name;
    String age;

    static constraints = {
        age(nullable: true)
        name(nullable: false)
    }
}