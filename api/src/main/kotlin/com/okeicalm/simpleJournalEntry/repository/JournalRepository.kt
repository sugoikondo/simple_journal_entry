package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Journal
import com.okeicalm.simpleJournalEntry.entity.JournalId

interface JournalRepository {
    fun findAll(): List<Journal>

    fun findById(id: JournalId): Journal?

    fun create(journal: Journal): JournalId
}
