package it.feio.kotlin.sitepreviewer.service

interface WebDriverService {
    fun peek(url: String, width: Int?, height: Int?)
}