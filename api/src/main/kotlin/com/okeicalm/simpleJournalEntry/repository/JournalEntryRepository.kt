package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.JournalEntry
import com.okeicalm.simpleJournalEntry.entity.JournalEntryId
import com.okeicalm.simpleJournalEntry.entity.JournalId

interface JournalEntrySearchParams {
    val journalId: JournalId?
    val journalIds: List<JournalId>?
}

interface JournalEntryRepository {
    fun search(params: JournalEntrySearchParams): List<JournalEntry>

    fun create(journalEntry: JournalEntry): JournalEntryId

    fun bulkCreate(journalEntries: List<JournalEntry>): JournalEntryId
}
