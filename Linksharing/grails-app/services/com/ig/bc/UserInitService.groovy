package com.ig.bc

class UserInitService {

    def serviceMethod() {

    }

    def userInit() {

        User usr1 = new User(firstname: 'vineet', lastname: 'mishra', address: 'pvihar', password: 'vineet', confirmPassword: 'vineet', email: 'vnt.mshra@gmail.com', male: true)
        User usr2 = new User(firstname: 'john', lastname: 'saxena', address: 'pvihardd', password: 'john', confirmPassword: 'john', email: 'john.saxena@gmail.com', male: true)
        User usr3 = new User(firstname: 'Admin', lastname: 'company', address: 'noida', password: 'admin', confirmPassword: 'admin', email: 'admin@intelligrape.com', male: true)
        User usr4 = new User(firstname: 'Ashish', lastname: 'mishra', address: 'delhi', password: 'ash', confirmPassword: 'ash', email: 'ash@gmail.com', male: true)
        User usr5 = new User(firstname: 'Ron', lastname: 'sharma', address: 'mumbai', password: 'ronw', confirmPassword: 'ronw', email: 'ron@gmail.com', male: true)
        User usr6 = new User(firstname: 'harry', lastname: 'singh', address: 'delhi', password: 'harryp', confirmPassword: 'harryp', email: 'harry@gmail.com', male: true)

        usr1.save(failOnError: true)
        usr2.save(failOnError: true)
        usr3.save(failOnError: true)
        usr4.save(failOnError: true)
        usr5.save(failOnError: true)
        usr6.save(failOnError: true)
    }
}
