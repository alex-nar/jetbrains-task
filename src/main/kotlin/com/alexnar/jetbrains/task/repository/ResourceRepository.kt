package com.alexnar.jetbrains.task.repository

import java.net.URI

interface ResourceRepository {
    fun getResourceContent(resourceId: String): String
}
