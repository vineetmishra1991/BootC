package com.ig.bc

class ApplicationTagLib {

    static namespace = "ls"

    def unreadItems = {attrs ->

        Integer max = attrs.int('max')

        User user = User.findByEmail(session.userEmail)
        List list = ReadingItem.findAllByUserAndIsRead(user, false, [max: max])
        out << render(template: '/user/unreadtable', model: [list: list])

    }

    def subscribedTopics = {attrs ->

        User user = User.findByEmail(session.userEmail)

        List<Subscription> subslist = Subscription.findAllBySubscriber(user)
        List<Topic> topicList = subslist.topic

        out << render(template: '/user/subscribedtopics', model: [topicList: topicList])


    }

    def ownedTopics = {attrs ->

        User user = User.findByEmail(session.userEmail)

        List<Topic> ownerList = Topic.findAllByOwner(user)
        out << render(template: '/user/ownedtopics', model: [ownerList: ownerList])
    }

    def markAsRead = {attrs ->

        ReadingItem item = ReadingItem.get(attrs.long('itemId'))
        out << """<a href="${createLink(action: "markRead", controller: "readingItem", id: item.id)}">Mark Read</a>"""

    }
    def highestSubscribedPublicTopics = {attrs ->

        def subscription = Subscription.createCriteria().list() {
            projections {
                groupProperty('topic')
                count('topic', 's')
// above can also be done as count('''subscriber','s')
            }
            'topic' {
                'eq'("visibility", Visibility.PUBLIC)
            }
            order('s', 'desc')
            maxResults 3
        }

        out << render(template: '/user/highestSubsPublicTopics', model: [subscriberList: subscription])
    }

    def mostReadItemsForTopicsSubscribedByUser = {attrs ->

        User user = User.findByFirstname('Vineet')
        List<Topic> topicsList = user.subscriptions*.topic
        def readingItem = []
        if (topicsList) {
            readingItem = ReadingItem.createCriteria().list() {
                projections {
                    groupProperty('resourceItem')
                    count('resourceItem')
                }

                'resourceItem' {
                    'in'("topic", topicsList)
                }

                'eq'("isRead", true)
            }
        }
        out << render(template: '/user/mostreaditems', model: [readingItemsList: readingItem])

    }
}
//    def formattedDate={attrs->
//
//        out << """Date: ${attrs.date.format("MM dd yyyy")}"""
//    }


