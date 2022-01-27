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
    val journalId: Long,
    val side: Byte,
    val accountId: Long,
    val value: Int,
) {
    constructor(journalEntry: JournalEntries) : this(
        JournalEntryId(journalEntry.id),
        journalEntry.journalId,
        journalEntry.side,
        journalEntry.accountId,
        journalEntry.value,
    )
}

@JvmInline
value class JournalEntryId(val value: Long)
