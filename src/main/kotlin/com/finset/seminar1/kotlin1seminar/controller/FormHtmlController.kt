package com.finset.seminar1.kotlin1seminar.controller

import com.finset.seminar1.kotlin1seminar.domain.User
import com.finset.seminar1.kotlin1seminar.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class FormHtmlController {

    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping(
        value = ["/form", "/form/{userid}"],
        method = [RequestMethod.GET],
    )
    fun getForm(
        @PathVariable("userid") userid: Long?,
        user: User?,
        model: Model,
    ): String {
        val user = if(userid === null) {
            User(null, null, null)
        } else {
            userRepository.findByIdOrNull(userid)
        }

        model.addAttribute("user", user)

        return "form/index"
    }

    @RequestMapping(
        value = ["/form"],
        method = [RequestMethod.POST],
    )
    fun postForm(
        user: User?,
        model: Model,
    ): String {
        user?.let {
//            println(user)
            val bcrypt = BCryptPasswordEncoder(11)
            it.pwd = bcrypt.encode(it.pwd)

            userRepository.save(it)
        }
        val _user = User()
        model.addAttribute("user", _user)

        return "form/login"
    }
}