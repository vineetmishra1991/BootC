package demo


class Person {
    String firstName
    String lastName
    String email
    Long age
    String address


    static constraints = {
        firstName(nullable: true,blank: true)
        lastName(nullable: true,blank: true)
        email(nullable: true,blank: true,email: true)
        age(nullable: true,blank: true)
        address(nullable: true,blank: true)

    }
}
