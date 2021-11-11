package it.feio.kotlin.sitepreviewer.config

import it.feio.kotlin.sitepreviewer.config.Constants.CACHE_NAME
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableCaching
class CachingConfig {

    @Bean
    fun cacheManager(): CacheManager {
        val cacheManager = SimpleCacheManager()
        cacheManager.setCaches(listOf(ConcurrentMapCache(CACHE_NAME)))
        return cacheManager
    }

}