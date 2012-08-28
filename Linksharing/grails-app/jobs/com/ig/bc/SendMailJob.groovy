package com.ig.bc

class SendMailJob {
    def emailInviteService
    static triggers = {
//        simple repeatInterval: 500000l // execute job once in 5 seconds
//        cron name: 'mySocialAccountTrigger', cronExpression: "0 10 13 * * ? *"   // Fire at 16:45 every day
    }

    def execute() {
//         inviteLogService.sendMailReminder()
    }

}
