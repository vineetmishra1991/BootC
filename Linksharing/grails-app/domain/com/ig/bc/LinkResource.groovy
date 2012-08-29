package com.ig.bc

class LinkResource extends Resource {

    String url

    String toString() {

        return url
    }

    static constraints = {
        url(url: true)
    }
}
