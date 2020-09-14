package com.alexnar.jetbrains.task.service

import com.fasterxml.jackson.databind.node.BaseJsonNode

interface JsonFilter {
    fun filter(jsonContent: String, query: String): BaseJsonNode
}