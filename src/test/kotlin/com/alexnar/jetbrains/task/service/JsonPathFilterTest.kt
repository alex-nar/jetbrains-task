package com.alexnar.jetbrains.task.service

import com.alexnar.jetbrains.task.service.config.parseContext
import com.alexnar.jetbrains.task.service.exception.QueryException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class JsonPathFilterTest {

    private val jsonPathFilter = JsonPathFilter(parseContext)

    @Test
    fun getConcreteValue() {
        val res = jsonPathFilter.filter(defaultJsonContent(), "\$.products[0].k1")
        assertEquals("\"v1\"", res.toString())
    }

    @Test
    fun getJsonArray() {
        val res = jsonPathFilter.filter(defaultJsonContent(), "\$.products")
        assertEquals("[{\"k1\":\"v1\"},{\"k1\":\"v11\",\"k2\":\"v22\"}]", res.toString())
    }

    @Test
    fun getJsonNode() {
        val res = jsonPathFilter.filter(defaultJsonContent(), "\$.products[0]")
        assertEquals("{\"k1\":\"v1\"}", res.toString())
    }

    @Test
    fun empty() {
        assertThrows(QueryException::class.java) {
            jsonPathFilter.filter(defaultJsonContent(), "")
        }

    }

    @Test
    fun wrongJson() {
        assertThrows(QueryException::class.java) {
            jsonPathFilter.filter("asfasfasfasf", "\$.products[0]")
        }
    }

    fun defaultJsonContent(): String = "{\n" +
            "  \"products\": [\n" +
            "    {\n" +
            "      \"k1\": \"v1\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"k1\": \"v11\",\n" +
            "      \"k2\": \"v22\"\n" +
            "    }\n" +
            "  ]\n" +
            "}\n"
}