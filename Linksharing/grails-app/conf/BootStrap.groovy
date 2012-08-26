import com.ig.bc.User
import com.ig.bc.Topic
import com.ig.bc.Visibility
import com.ig.bc.Subscription
import com.ig.bc.Seriousness
import com.ig.bc.Linkresource
import com.ig.bc.Resource
import com.ig.bc.Readingitem

class BootStrap {

    def bootstrapService
    def init = { servletContext ->

        bootstrapService.initializeData()
    }
    def destroy = {

    }

}
