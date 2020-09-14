package com.alexnar.jetbrains.task.service

import com.fasterxml.jackson.databind.node.BaseJsonNode
import com.fasterxml.jackson.databind.node.ObjectNode

interface JsonFilter {
    fun filter(jsonContent: String, query: String): BaseJsonNode
}