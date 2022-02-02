package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.entity.user.UserId
import com.okeicalm.simpleJournalEntry.handler.type.UserType
import com.okeicalm.simpleJournalEntry.repository.users.UserRepository
import org.springframework.stereotype.Component

@Component
class UserQuery(private val repository: UserRepository): Query {
    fun getUser(id: String): UserType? {
        return repository.findById(UserId(id.toLong()))?.let { UserType(it) }
    }

    fun allUsers(): List<UserType> {
        val users = repository.findAll()
        return users.map { UserType(it) }
    }
}