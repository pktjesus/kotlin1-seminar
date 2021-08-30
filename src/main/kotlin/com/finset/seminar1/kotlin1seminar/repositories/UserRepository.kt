package com.finset.seminar1.kotlin1seminar.repositories

import com.finset.seminar1.kotlin1seminar.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): User?
}