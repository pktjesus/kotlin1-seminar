package com.finset.seminar1.kotlin1seminar.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeHtmlController {

    @GetMapping(value = ["/home"])
    fun homePage(): String = "form/home"
}