package plugindemo

class SchedulerJob {
    def mailService
    def asyncMailService


    static triggers = {

//        simple repeatInterval: 10000l // execute job once in 5 seconds

        cron name: 'mySocialAccountTrigger', cronExpression: "0 10 13 * * ? *"      // Fire at 16:45 every day

    }

    def execute() {
        asyncMailService.sendMail {
            to "vishal@intelligrape.com"
            subject "[Testing] Hello"
            body 'This is some random text.'
        }
    }
}
