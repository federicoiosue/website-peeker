package it.feio.kotlin.sitepreviewer.ws

import it.feio.kotlin.sitepreviewer.service.WebDriverService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("website")
class WebsiteController(val webDriverService: WebDriverService) {

    @GetMapping
    fun peek(@RequestParam url: String) {
        webDriverService.peek(url)
    }
}