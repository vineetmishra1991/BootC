dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect // must be set for transactions to work!
    username = "root"
    password = "igdefault"
    formatSql = true
    //configure DBCP
    properties {
        maxActive = 50
        maxIdle = 25
        minIdle = 1
        initialSize = 1
        minEvictableIdleTimeMillis = 60000
        timeBetweenEvictionRunsMillis = 60000
        numTestsPerEvictionRun = 3
        maxWait = 10000
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = false

        validationQuery = "SELECT 1"
    }
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://127.0.0.1:3306/taglib_dev?autoReconnect=true&useUnicode=yes&characterEncoding=utf8"
        }
    }
    gautam{
   }

}
