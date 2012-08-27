package com.ig.bc



class SendMailJob {
    def inviteLogService
    static triggers = {
        simple repeatInterval: 500000l // execute job once in 5 seconds
    }

    def execute() {

        inviteLogService.sendMailReminder()
    }

}
