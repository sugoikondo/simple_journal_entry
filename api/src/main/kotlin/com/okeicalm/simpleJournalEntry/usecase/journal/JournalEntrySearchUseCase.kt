package com.okeicalm.simpleJournalEntry.fetcher

import com.okeicalm.simpleJournalEntry.entity.JournalEntry
import com.okeicalm.simpleJournalEntry.entity.JournalId
import com.okeicalm.simpleJournalEntry.repository.JournalEntryRepository
import com.okeicalm.simpleJournalEntry.repository.JournalEntrySearchParams
import org.springframework.stereotype.Component

data class JournalEntrySearchUseCaseParams(val journalID: JournalId?, val journalIDs: List<JournalId>?) : JournalEntrySearchParams {
    override val journalId: JournalId? = null
    override val journalIds: List<JournalId>? = null
}

@Component
class JournalEntrySearchUseCase(private val journalEntryRepository: JournalEntryRepository) {
    fun call(params: JournalEntrySearchUseCaseParams): List<JournalEntry> {
        return journalEntryRepository.search(params)
    }
}
