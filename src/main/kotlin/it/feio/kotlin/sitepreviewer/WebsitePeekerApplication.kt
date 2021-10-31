package it.feio.kotlin.sitepreviewer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebsitePeekerApplication

fun main(args: Array<String>) {
	runApplication<WebsitePeekerApplication>(*args)
}
