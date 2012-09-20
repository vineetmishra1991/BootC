package com.ig.bc

class OnlyTopicCreateFilters {

    def filters = {
        all(controller: '*', action: 'create') {
            before = {
                if (params.controller != 'topic') {
                    if (!(session.userEmail == "admin@intelligrape.com")) {
                        render "Only Admin can Acess This Page !!"
                        return false
                    }
                }
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
