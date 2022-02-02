package com.okeicalm.simpleJournalEntry.handler.mutation.users

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.UserType
import com.okeicalm.simpleJournalEntry.usecase.user.UpdateUserUseCase
import com.okeicalm.simpleJournalEntry.usecase.user.UserUpdateUseCaseInput
import org.springframework.stereotype.Component

data class UpdateUserInput(
    val id: ID,
    val name: String,
)

@Component
class UpdateUserMutation(private val updateUserUseCase: UpdateUserUseCase): Mutation {
    fun updateUser(input: UpdateUserInput): UserType {
        val output = updateUserUseCase.update(UserUpdateUseCaseInput(input.id, input.name))
        return UserType(output.user)
    }
}