package com.alexnar.jetbrains.task.service

import com.alexnar.jetbrains.task.service.exception.QueryException
import com.fasterxml.jackson.databind.node.BaseJsonNode
import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPathException
import com.jayway.jsonpath.ParseContext
import org.springframework.stereotype.Service

/**
 * Solution based on https://github.com/json-path/JsonPath
 */
@Service
class JsonPathFilter(private val parseContext: ParseContext): JsonFilter {
    override fun filter(jsonContent: String, query: String): BaseJsonNode {
        val documentContext = handleJsonParse(jsonContent)
        return handleJsonQuery(documentContext, query)
    }

    private fun handleJsonParse(jsonContent: String): DocumentContext {
        try {
            return parseContext.parse(jsonContent)
        } catch (e: JsonPathException) {
            throw QueryException("Wrong json")
        }
    }

    private fun handleJsonQuery(documentContext: DocumentContext, query: String): BaseJsonNode {
        try {
            return documentContext.read(query)
        } catch (e: Exception) {
            throw QueryException("Wrong query: $query")
        }
    }
}