package com.alexnar.jetbrains.task.service

import com.alexnar.jetbrains.task.repository.ResourceRepository
import com.alexnar.jetbrains.task.repository.exception.ResourceNotFoundException
import com.alexnar.jetbrains.task.service.dto.FileQueryRq
import com.alexnar.jetbrains.task.service.exception.QueryException
import com.fasterxml.jackson.databind.node.BaseJsonNode
import org.springframework.stereotype.Service
@Service
class QueryService(
        private val resourceRepository: ResourceRepository,
        private val jsonFilter: JsonFilter
) {
    fun query(query: FileQueryRq): BaseJsonNode {
        val resourceContent = handleResourceReceiving(query)
        return jsonFilter.filter(resourceContent, query.query)
    }

    private fun handleResourceReceiving(query: FileQueryRq): String {
        try {
            return resourceRepository.getResourceContent(query.resourceId)
        } catch (e: ResourceNotFoundException) {
            throw QueryException(e.message)
        }
    }
}

