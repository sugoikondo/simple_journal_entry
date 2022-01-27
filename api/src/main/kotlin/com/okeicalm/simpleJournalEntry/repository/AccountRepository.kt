package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.*

interface AccountRepository {
    fun findAll(): List<Account>

    fun findById(id: AccountId): Account?

    fun create(account: Account): AccountId

    fun update(id: AccountId, account: Account): AccountId

    fun delete(id: AccountId): AccountId
}
