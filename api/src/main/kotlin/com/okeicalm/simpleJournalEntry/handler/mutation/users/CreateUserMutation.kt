package com.okeicalm.simpleJournalEntry.handler.mutation.users

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.UserType
import com.okeicalm.simpleJournalEntry.usecase.user.CreateUserUseCase
import com.okeicalm.simpleJournalEntry.usecase.user.UserCreateUseCaseInput
import org.springframework.stereotype.Component

data class CreateUserInput(
    val name: String
)

@Component
class CreateUserMutation(private val createUserUseCase: CreateUserUseCase): Mutation {
    fun createUser(input: CreateUserInput): UserType {
        val output = createUserUseCase.create(UserCreateUseCaseInput(input.name))
        return UserType(output.user)
    }
}