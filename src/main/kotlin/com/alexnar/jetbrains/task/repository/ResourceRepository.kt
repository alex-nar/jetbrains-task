package com.alexnar.jetbrains.task.repository

interface ResourceRepository {
    fun getResourceContent(resourceId: String): String
}
