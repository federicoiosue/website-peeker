package it.feio.kotlin.sitepreviewer.service.impl

import it.feio.kotlin.sitepreviewer.config.Constants
import it.feio.kotlin.sitepreviewer.service.CacheService
import it.feio.kotlin.sitepreviewer.service.WebDriverService
import lombok.extern.slf4j.Slf4j
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.io.File


@Service
@Slf4j
class InMemoryCacheService(
    val webDriverService: WebDriverService,
    val cacheManager: CacheManager
) : CacheService {

    @Cacheable(Constants.CACHE_NAME, key = "#url")
    override fun peek(url: String, width: Int?, height: Int?): File {
        return webDriverService.peek(url, width, height)
    }

    override fun evict(url: String) {
        cacheManager.getCache(Constants.CACHE_NAME)?.evict(url)
    }


}