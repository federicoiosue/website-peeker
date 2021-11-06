package it.feio.kotlin.sitepreviewer.utils

import org.springframework.web.util.UriComponentsBuilder

fun fixUrl(url: String): String {
    return UriComponentsBuilder.newInstance().scheme("http").host(url).build().toUriString()
}