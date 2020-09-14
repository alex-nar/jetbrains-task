package com.alexnar.jetbrains.task.service.config

import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider

val jsonPathConfig: Configuration = Configuration
        .builder()
        .jsonProvider(JacksonJsonNodeJsonProvider())
        .build()

val parseContext = JsonPath.using(jsonPathConfig)
