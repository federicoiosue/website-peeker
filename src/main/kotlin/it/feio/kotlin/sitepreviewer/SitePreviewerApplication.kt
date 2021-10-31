package it.feio.kotlin.sitepreviewer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SitePreviewerApplication

fun main(args: Array<String>) {
	runApplication<SitePreviewerApplication>(*args)
}
