import org.springframework.cache.ehcache.EhCacheFactoryBean

beans = {




    xmlns context: 'http://www.springframework.org/schema/context'
    context.'component-scan'('base-package': 'my.company.area')
    context.'component-scan'('base-package': 'my.company.process')

























    /*xmlns context: 'http://www.springframework.org/schema/context'
    context.'component-scan'('base-package': 'apackage')
    context.'component-scan'('base-package': 'net.thoughtforge.service')

    xmlns aop:"http://www.springframework.org/schema/aop"

    xmlns cache: "http://www.springframework.org/schema/cache"
    //anotherAspect(apackage.LoggerInterceptor)

    aop.config("proxy-target-class": true) {

    }



    pirateCache(EhCacheFactoryBean) { bean ->
        cacheManager = ref("springcacheCacheManager")
        cacheName = "pirateCache"
        // these are just examples of properties you could set
        eternal = false
        diskPersistent = false
        memoryStoreEvictionPolicy = "LRU"
    }*/

}