package com.ig.bc

class ApplicationTagLib {

    static namespace = "ls"

     def unreadItems={attrs->

         Integer max = attrs.int('max')

         User user=User.findByEmail(session.userEmail)
         List list=Readingitem.findAllByUserAndIsread(user, false,[max: max])
         List viewdate=list.user.dateCreated
         out<<render(template: '/user/unreadtable',model: [list:list,viewdate:viewdate])

         }

     def subscribedTopics={attrs->

         User user=User.findByEmail(session.userEmail)

         List<Subscription> subslist=Subscription.findAllBySubscriber(user)
         List<Topic> topicList = subslist.topic as List<Topic>

         out<<render(template: '/user/subscribedtopics',model: [topicList:topicList])


     }

    def ownedTopics={

        User user=User.findByEmail(session.userEmail)

        List<Topic> ownerList=Topic.findAllByOwner(user)
        out<<render(template: '/user/subscribedtopics',model: [topicList: ownerList])
    }

    def markAsRead={attrs->

          Readingitem item= Readingitem.get(attrs.long('itemId'))
    out<<"""<a href="${createLink(action: "markRead",controller:"readingitem",id: item.id)}">Mark Read</a>"""

               }
//    def formattedDate={attrs->
//
//        out << """Date: ${attrs.date.format("MM dd yyyy")}"""
//    }

}
