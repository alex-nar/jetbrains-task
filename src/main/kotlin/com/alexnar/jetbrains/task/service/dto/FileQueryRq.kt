package com.alexnar.jetbrains.task.service.dto

data class FileQueryRq(
        val query: String,
        var resourceId: String = "default.json"
)