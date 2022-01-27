package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Account
import com.okeicalm.simpleJournalEntry.entity.AccountId
import com.okeicalm.simpleJournalEntry.tables.Accounts
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AccountRepositoryImpl @Autowired constructor(private val dslContext: DSLContext) : AccountRepository {
    override fun findAll(): List<Account> {
        val result = dslContext.select()
            .from(Accounts.ACCOUNTS)
            .fetch()
            .into(com.okeicalm.simpleJournalEntry.tables.pojos.Accounts::class.java)

        return result.map { r -> Account(r) }
    }

    override fun findById(id: AccountId): Account? {
        val accountPOJO: com.okeicalm.simpleJournalEntry.tables.pojos.Accounts? = dslContext
            .fetchOne(Accounts.ACCOUNTS, Accounts.ACCOUNTS.ID.eq(id.value))
            ?.into(com.okeicalm.simpleJournalEntry.tables.pojos.Accounts::class.java)

        return accountPOJO?.let { Account(it) }
    }

    override fun create(account: Account): AccountId {
        dslContext
            .newRecord(Accounts.ACCOUNTS)
            .setName(account.name)
            .setCode(account.code)
            .setElementType(account.elementType)
            .store()
        return AccountId(dslContext.lastID().toLong())
    }

    override fun update(id: AccountId, account: Account): AccountId {
        dslContext
            .update(Accounts.ACCOUNTS)
            .set(Accounts.ACCOUNTS.CODE, account.code)
            .set(Accounts.ACCOUNTS.NAME, account.name)
            .set(Accounts.ACCOUNTS.ELEMENT_TYPE, account.elementType)
            .where(Accounts.ACCOUNTS.ID.eq(id.value))
            .execute()
        return id
    }

    override fun delete(id: AccountId): AccountId {
        dslContext
            .delete(Accounts.ACCOUNTS)
            .where(Accounts.ACCOUNTS.ID.eq(id.value))
            .execute()
        return id
    }
}
