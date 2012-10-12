package domaintest

import com.ig.bc.Nose
import com.ig.bc.Author

class Auth_Nose {

    static belongsTo = [nose: Nose]
    static constraints = {
    }
}
