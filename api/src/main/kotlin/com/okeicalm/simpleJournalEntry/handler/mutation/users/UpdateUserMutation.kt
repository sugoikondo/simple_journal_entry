package com.okeicalm.simpleJournalEntry.handler.mutation.users

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.UserType
import com.okeicalm.simpleJournalEntry.usecase.user.UpdateUserUseCase
import com.okeicalm.simpleJournalEntry.usecase.user.UserUpdateUseCaseInput
import org.springframework.stereotype.Component

@Component
class UpdateUserMutation(private val updateUserUseCase: UpdateUserUseCase): Mutation {
    fun update(name: String): UserType {
        val output = updateUserUseCase.update(UserUpdateUseCaseInput(name))
        return UserType(output.user)
    }
}