package it.feio.kotlin.sitepreviewer.service

import java.io.File

interface WebDriverService {
    suspend fun peek(url: String, width: Int?, height: Int?): File
}