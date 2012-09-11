package com.ig.bc

/**
 * Created with IntelliJ IDEA.
 * User: intelligrape
 * Date: 11/09/12
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
class UserVo {

    List<User> subscribers;
    Topic topic;
    User owner;

    String toString() {

        return "The owner of the topic ${topic} is ${owner.firstname} and the subcribers of this topic are ${subscribers*.firstname}"
    }
}


