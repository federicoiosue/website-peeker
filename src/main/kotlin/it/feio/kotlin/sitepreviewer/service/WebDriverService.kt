package it.feio.kotlin.sitepreviewer.service

import java.io.File

interface WebDriverService {
    fun peek(url: String, width: Int?, height: Int?): File
}