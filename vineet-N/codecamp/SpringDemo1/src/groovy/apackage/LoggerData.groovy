package apackage;


import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.cache.annotation.CacheEvict

/**
 * Created with IntelliJ IDEA.
 * User: mohit
 * Date: 9/11/12
 * Time: 8:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("loggerData")
public class LoggerData {

    @Cacheable("shortTTLPartition")

    String getData(String abc) {
       System.out.print("----------------------------------------------------Data from class----------------------------------------------------");
        return "hello:::" + abc;
    }

    @CacheEvict("shortTTLPartition")
    void deleteCache(){
         println("cache deleted")
    }
}
