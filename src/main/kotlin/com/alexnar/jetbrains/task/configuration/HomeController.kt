package com.alexnar.jetbrains.task.configuration

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "index"
    }
}