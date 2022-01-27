package com.okeicalm.simpleJournalEntry.entity

import com.okeicalm.simpleJournalEntry.tables.pojos.JournalEntries
import com.okeicalm.simpleJournalEntry.tables.pojos.Journals
import java.time.LocalDate


/**
 * 仕訳 : Journal (in　bookkeeping)
 *
 * @param id
 * @param incurredOn
 * @param journalEntries
 */
data class Journal(

    val id: JournalId = JournalId(0),
    val incurredOn: LocalDate,
    val journalEntries: List<JournalEntry>?
) {
    constructor(journal: Journals, journalEntries: List<JournalEntries>?) : this(
        JournalId(journal.id),
        journal.incurredOn,
        journalEntries?.map { JournalEntry(it) }, // NOTE: ここが下の行に変わってコメントアウトされていた背景？
        // null,
    )
}

@JvmInline
value class JournalId(val value: Long)
