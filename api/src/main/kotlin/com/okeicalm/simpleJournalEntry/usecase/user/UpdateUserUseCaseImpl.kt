package com.okeicalm.simpleJournalEntry.usecase.user

import com.expediagroup.graphql.generator.scalars.ID
import com.okeicalm.simpleJournalEntry.entity.user.User
import com.okeicalm.simpleJournalEntry.entity.user.UserId
import com.okeicalm.simpleJournalEntry.entity.user.UserName
import com.okeicalm.simpleJournalEntry.repository.users.UserRepository
import org.springframework.stereotype.Component

data class UserUpdateUseCaseInput(val id: ID, val name: String)
data class UserUpdateUseCaseOutput(val user: User)

interface UpdateUserUseCase {
    fun update(input: UserUpdateUseCaseInput): UserUpdateUseCaseOutput
}

@Component
class UpdateUserUseCaseImpl(
    private val userRepository: UserRepository
) : UpdateUserUseCase {
    override fun update(input: UserUpdateUseCaseInput): UserUpdateUseCaseOutput {
        val user = User(name = UserName(input.name))
        userRepository.update(User(id = UserId(input.id.value.toLong()), name = UserName(input.name)))
        return UserUpdateUseCaseOutput(user)
    }
}