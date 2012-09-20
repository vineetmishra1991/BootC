package com.ig.bc

class ShowOnlyToAdminFilters {

    def filters = {
        all(controller: '*', action: 'show') {
            before = {
                if (!(session.userEmail == "admin@intelligrape.com")) {
                    render "Only Admin can Acess This Page !!"
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
