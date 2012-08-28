package com.ig.bc

class MailJob {
    def emailInviteService
    static triggers = {
//        simple repeatInterval: 5000l // execute job once in 5 seconds
//        cron name: 'mySocialAccountTrigger', cronExpression: "0 10 13 * * ? *"   // Fire at 1:10 every day
    }

    def execute() {
//        emailInviteService.sendMailReminder()
    }

}
