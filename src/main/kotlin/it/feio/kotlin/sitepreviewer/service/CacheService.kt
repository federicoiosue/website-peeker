package it.feio.kotlin.sitepreviewer.service

import java.io.File

interface CacheService {
    fun peek(url: String, width: Int?, height: Int?): File
    fun evict(url: String)
}