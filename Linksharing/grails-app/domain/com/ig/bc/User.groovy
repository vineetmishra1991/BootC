package com.ig.bc

class User {
    String name;
    String address;



    static constraints = {
    }

    static transients = ['fullAddress']

    String getFullAddress() {

        return "$name $address"
    }
}
