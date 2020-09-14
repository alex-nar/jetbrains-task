package com.alexnar.jetbrains.task.configuration

import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.ParseContext
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean

@Configuration
open class JsonPathLibConfig {

    @Bean
    fun jsonParseParseContext(): ParseContext {
        return JsonPath.using(jsonPathConfiguration())
    }

    @Bean
    fun jsonPathConfiguration(): com.jayway.jsonpath.Configuration {
        return com.jayway.jsonpath.Configuration
                .builder()
                .jsonProvider(JacksonJsonNodeJsonProvider())
                .build()
    }
}