package com.okeicalm.simpleJournalEntry.usecase.journal

import com.okeicalm.simpleJournalEntry.entity.AccountId
import com.okeicalm.simpleJournalEntry.entity.Journal
import com.okeicalm.simpleJournalEntry.entity.JournalEntry
import com.okeicalm.simpleJournalEntry.entity.JournalId
import com.okeicalm.simpleJournalEntry.repository.JournalEntryRepository
import com.okeicalm.simpleJournalEntry.repository.JournalEntrySearchParams
import com.okeicalm.simpleJournalEntry.repository.JournalRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

data class JournalEntryInputData(val side: Byte, val accountID: AccountId, val value: Int)
data class JournalCreateUseCaseInput(val incurredOn: LocalDate, val journalEntryInputDatum: List<JournalEntryInputData>)
data class JournalCreateUseCaseOutput(val journal: Journal, val journalEntries: List<JournalEntry>)

data class SearchParams(override val journalId: JournalId, override val journalIds: List<JournalId>?) : JournalEntrySearchParams

interface JournalCreateUseCase {
    fun call(input: JournalCreateUseCaseInput): JournalCreateUseCaseOutput
}

@Service
class JournalCreateUseCaseImpl(
    private val journalRepository: JournalRepository,
    private val journalEntryRepository: JournalEntryRepository
) : JournalCreateUseCase {
    @Transactional
    override fun call(input: JournalCreateUseCaseInput): JournalCreateUseCaseOutput {
        val journal = Journal(
            incurredOn = input.incurredOn,
            journalEntries = emptyList(),
        )

        val newJournalId = journalRepository.create(journal)
        val newJournal =
            journalRepository.findById(newJournalId) ?: throw Exception("JournalCreateUseCase: Something wrong...")

        val journalEntries = input.journalEntryInputDatum.map {
            JournalEntry(
                journalId = newJournalId,
                side = it.side,
                accountId = it.accountID,
                value = it.value,
            )
        }
        journalEntryRepository.bulkCreate(journalEntries)
        val newJournalEntries = journalEntryRepository.search(SearchParams(newJournalId, null))

        return JournalCreateUseCaseOutput(newJournal, newJournalEntries)
    }
}
