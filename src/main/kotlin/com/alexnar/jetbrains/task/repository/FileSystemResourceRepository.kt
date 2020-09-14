package com.alexnar.jetbrains.task.repository

import com.alexnar.jetbrains.task.repository.exception.ResourceNotFoundException
import com.alexnar.jetbrains.task.service.exception.QueryException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File

@Service
class FileSystemResourceRepository : ResourceRepository {
    @Value("\${content.path}")
    lateinit var contentPath: String

    override fun getResourceContent(resourceId: String): String {
        val file = File("$contentPath/$resourceId")
        if (!file.exists()) throw ResourceNotFoundException("File with id $resourceId not found")
        return file.readText()
    }
}