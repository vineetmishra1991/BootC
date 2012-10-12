class BootStrap {
    def bootStrapService
    def init = { servletContext ->

        bootStrapService.initializeData()
    }
    def destroy = {
    }
}
