package com.alexnar.jetbrains.task.controller

import com.alexnar.jetbrains.task.service.QueryService
import com.alexnar.jetbrains.task.service.dto.FileQueryRq
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.BaseJsonNode
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class QueryController(private val queryService: QueryService) {

    @PostMapping(value = [ "/query" ], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun queryFile(@RequestBody fileQueryRq: FileQueryRq): BaseJsonNode {
        return queryService.query(fileQueryRq)
    }
}