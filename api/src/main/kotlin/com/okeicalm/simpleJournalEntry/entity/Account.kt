package com.okeicalm.simpleJournalEntry.entity

import com.okeicalm.simpleJournalEntry.tables.pojos.Accounts

/**
 * 勘定科目: Account (in bookkeeping)
 *
 * @param id
 * @param code 勘定科目コード : Account code
 * @param name 勘定科目名 : Account name
 * @param elementType なんぞこれ
 */
data class Account(
    val id: AccountId = AccountId(0),
    val code: String,
    val name: String,
    val elementType: Int,
) {
    constructor(account: Accounts) : this(
        AccountId(account.id),
        account.code,
        account.name,
        account.elementType,
    )
}

@JvmInline
value class AccountId(val value: Long)
