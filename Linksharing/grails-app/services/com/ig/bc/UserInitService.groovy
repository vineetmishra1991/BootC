package com.ig.bc

class UserInitService {

    def serviceMethod() {

    }

    def userInit() {

        User usr1 = new User(firstname: 'vineet', lastname: 'mishra', address: 'pvihar', password: 'vineet', confirmPassword: 'vineet', email: 'vnt.mshra@gmail.com', dateOfBirth: new Date(), male: true)
        User usr2 = new User(firstname: 'john', lastname: 'saxena', address: 'pvihardd', password: 'john', confirmPassword: 'john', email: 'john.saxena@gmail.com', male: true, dateOfBirth: new Date())
        User usr3 = new User(firstname: 'Admin', lastname: 'company', address: 'noida', password: 'admin', confirmPassword: 'admin', email: 'admin@intelligrape.com', male: true, dateOfBirth: new Date())
        User usr4 = new User(firstname: 'Ashish', lastname: 'mishra', address: 'delhi', password: 'ash', confirmPassword: 'ash', email: 'ash@gmail.com', male: true, dateOfBirth: new Date())
        User usr5 = new User(firstname: 'Ron', lastname: 'sharma', address: 'mumbai', password: 'ronw', confirmPassword: 'ronw', email: 'ron@gmail.com', male: true, dateOfBirth: new Date())
        User usr6 = new User(firstname: 'harry', lastname: 'singh', address: 'delhi', password: 'harryp', confirmPassword: 'harryp', email: 'harry@gmail.com', male: true, dateOfBirth: new Date())
        User usr7 = new User(firstname: 'harryp', lastname: 'singha', address: 'delhi', password: 'harryp', confirmPassword: 'harryq', email: 'harry1@gmail.com', male: true, dateOfBirth: new Date())
        User usr8 = new User(firstname: 'harryq', lastname: 'singhb', address: 'assam', password: 'harryp', confirmPassword: 'harryq', email: 'harry2@gmail.com', male: true, dateOfBirth: new Date())
        User usr9 = new User(firstname: 'harryr', lastname: 'singhc', address: 'punjabb', password: 'harryp', confirmPassword: 'harryr', email: 'harry3@gmail.com', male: true, dateOfBirth: new Date())
        User usr10 = new User(firstname: 'harrys', lastname: 'singhd', address: 'delhi', password: 'harryp', confirmPassword: 'harrys', email: 'harry4@gmail.com', male: true, dateOfBirth: new Date())


        usr1.save(failOnError: true, flush: true)
        usr2.save(failOnError: true, flush: true)
        usr3.save(failOnError: true, flush: true)
        usr4.save(failOnError: true, flush: true)
        usr5.save(failOnError: true, flush: true)
        usr6.save(failOnError: true, flush: true)
        usr7.save(failOnError: true, flush: true)
        usr8.save(failOnError: true, flush: true)
        usr9.save(failOnError: true, flush: true)
        usr10.save(failOnError: true, flush: true)
    }
}
