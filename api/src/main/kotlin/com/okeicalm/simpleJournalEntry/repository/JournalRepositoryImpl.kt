package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.*
import com.okeicalm.simpleJournalEntry.tables.JournalEntries.JOURNAL_ENTRIES
import com.okeicalm.simpleJournalEntry.tables.Journals.JOURNALS
import com.okeicalm.simpleJournalEntry.tables.pojos.Journals
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class JournalRepositoryImpl(private val dslContext: DSLContext) : JournalRepository {
    override fun findAll(): List<Journal> {
        val result = dslContext
            .select()
            .from(JOURNALS)
            .join(JOURNAL_ENTRIES)
            .on(JOURNALS.ID.eq(JOURNAL_ENTRIES.JOURNAL_ID))
            .fetch()
            .into(Journals::class.java)
        return result.map { Journal(it, null) }
    }

    override fun findById(id: JournalId): Journal? {
        val journal = dslContext
            .fetchOne(JOURNALS, JOURNALS.ID.eq(id.value))
            ?.into(Journals::class.java)

        return journal?.let { Journal(it, emptyList()) }
    }

    override fun create(journal: Journal): JournalId {
        dslContext
            .newRecord(JOURNALS)
            .setIncurredOn(journal.incurredOn)
            .store()
        return JournalId(dslContext.lastID().toLong())
    }
}
