package it.feio.kotlin.sitepreviewer.ws

import it.feio.kotlin.sitepreviewer.config.Constants.WEBSITE_ENDPOINT
import it.feio.kotlin.sitepreviewer.service.CacheService
import org.springframework.http.MediaType
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.*
import java.io.BufferedInputStream
import java.io.IOException

@RestController
@RequestMapping(WEBSITE_ENDPOINT)
class WebsiteController(val cacheService: CacheService) {

    @ResponseBody
    @GetMapping("{url}", produces = [MediaType.IMAGE_JPEG_VALUE])
    @Throws(IOException::class)
    fun peek(
        @PathVariable url: String,
        @RequestParam(required = false) width: Int?,
        @RequestParam(required = false) height: Int?
    ): ByteArray {
        val screenshot = cacheService.peek(url, width, height)
        return FileCopyUtils.copyToByteArray(BufferedInputStream(screenshot.inputStream()))
    }

    @DeleteMapping("{url}")
    @Throws(IOException::class)
    suspend fun evict(
        @PathVariable url: String
    ) {
        cacheService.evict(url)
    }

}