package com.ig.bc

class DeleteOnlyOwnerTopicFilters {

    def filters = {
        all(controller: 'topic', action: 'delete') {
            before = {
                def topicInstance = Topic.get(params.id)
                User user = User.findByEmail(session.userEmail)
                def owner = topicInstance.owner
                if (!(user == owner) && !(session.userEmail == "admin@intelligrape.com")) {

                    render "Not Allowed !!"
                    return false
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
