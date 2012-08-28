package com.ig.bc

class EmailEveryMorningJob {
    def emailInviteService
    static triggers = {
//        simple repeatInterval: 5000l // execute job once in 5 seconds
//        cron name: 'mySocialAccountTrigger', cronExpression: "0 0 08 ? * *"        //everyday 8:00 am

    }

    def execute() {

//        emailInviteService.sendReminderAccordingToDate()
    }
}
