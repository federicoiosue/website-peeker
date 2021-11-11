package it.feio.kotlin.sitepreviewer.ws

import it.feio.kotlin.sitepreviewer.config.Constants.CACHE_NAME
import it.feio.kotlin.sitepreviewer.config.Constants.WEBSITE_ENDPOINT
import it.feio.kotlin.sitepreviewer.service.WebDriverService
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.MediaType
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation.*
import java.io.BufferedInputStream
import java.io.IOException

@RestController
@RequestMapping(WEBSITE_ENDPOINT)
class WebsiteController(val webDriverService: WebDriverService) {

    @ResponseBody
    @GetMapping("{url}", produces = [MediaType.IMAGE_JPEG_VALUE])
    @Cacheable(CACHE_NAME, key = "#url")
    @Throws(IOException::class)
    suspend fun peek(
        @PathVariable url: String,
        @RequestParam(required = false) width: Int?,
        @RequestParam(required = false) height: Int?
    ): ByteArray {
        val screenshot = webDriverService.peek(url, width, height)
        return FileCopyUtils.copyToByteArray(BufferedInputStream(screenshot.inputStream()))
    }

}