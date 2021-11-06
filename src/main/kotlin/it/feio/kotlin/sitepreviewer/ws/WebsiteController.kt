package it.feio.kotlin.sitepreviewer.ws

import it.feio.kotlin.sitepreviewer.service.WebDriverService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("website")
class WebsiteController(val webDriverService: WebDriverService) {

    @GetMapping("{url}")
    fun peek(@RequestParam url: String, @RequestParam width: Int, @RequestParam height: Int) {
        @PathVariable url: String,
        @RequestParam(required = false) width: Int?,
        @RequestParam(required = false) height: Int?
    ) {
        webDriverService.peek(url, width, height)
    }

}