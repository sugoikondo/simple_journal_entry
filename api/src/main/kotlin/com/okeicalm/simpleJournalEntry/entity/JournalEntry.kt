package com.okeicalm.simpleJournalEntry.entity

import com.okeicalm.simpleJournalEntry.tables.pojos.JournalEntries

/**
 * 仕訳における各レコード : Each record of journal
 *
 * @param id
 * @param journalId
 * @param side 借方および貸方 : Debit or Credit
 * @param accountId
 * @param value 金額 : amount of money
 */
data class JournalEntry(
    val id: JournalEntryId = JournalEntryId(0),
    val journalId: JournalId,
    val side: Byte,
    val accountId: AccountId,
    val value: Int,
) {
    constructor(journalEntry: JournalEntries) : this(
        JournalEntryId(journalEntry.id),
        JournalId(journalEntry.journalId),
        journalEntry.side,
        AccountId(journalEntry.accountId),
        journalEntry.value,
    )
}

@JvmInline
value class JournalEntryId(val value: Long)
