package com.finset.seminar1.kotlin1seminar.controller

import com.finset.seminar1.kotlin1seminar.domain.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class LoginHtmlController {

    @GetMapping(value = ["/login"])
    fun loginPage(
        userid: Long?,
        user: User,
        model: Model,
    ): String {
        if(userid != null) {
            user.name = "Hell"
            user.email = "hell@abc.com"
            user.pwd = "heel"
        } else {
//            user = User(null, null, null)
        }
        model.addAttribute("user", user)

        return "form/login"
    }
}