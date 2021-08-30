package com.finset.seminar1.kotlin1seminar.domain

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null,
    var email: String? = null,
    var pwd: String? = null,
) : UserDetails {
    var role = ROLE_TYPE.MEMBER

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableListOf<GrantedAuthority>()

        when(role) {
            ROLE_TYPE.ADMIN -> authorities.add(SimpleGrantedAuthority("ROLE_ADMIN"))
            ROLE_TYPE.MEMBER -> authorities.add(SimpleGrantedAuthority("ROLE_MEMBER"))
        }

        return authorities
    }

    override fun getPassword(): String = pwd!!

    override fun getUsername(): String = name!!

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}