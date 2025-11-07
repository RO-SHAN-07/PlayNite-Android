package org.roshan.playnite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform