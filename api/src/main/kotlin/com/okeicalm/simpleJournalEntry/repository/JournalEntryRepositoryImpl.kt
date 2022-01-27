package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.JournalEntry
import com.okeicalm.simpleJournalEntry.entity.JournalEntryId
import com.okeicalm.simpleJournalEntry.entity.JournalId
import com.okeicalm.simpleJournalEntry.tables.JournalEntries.JOURNAL_ENTRIES
import com.okeicalm.simpleJournalEntry.tables.pojos.JournalEntries
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class JournalEntryRepositoryImpl(private val dslContext: DSLContext) : JournalEntryRepository {
    override fun search(params: JournalEntrySearchParams): List<JournalEntry> {
        val query = dslContext.select().from(JOURNAL_ENTRIES)
        if (params.journalId != null) {
            query.where(JOURNAL_ENTRIES.JOURNAL_ID.eq(params.journalId?.value))
        }

        return query
            .fetch()
            .into(JournalEntries::class.java)
            .map { JournalEntry(it) }
    }

    override fun create(journalEntry: JournalEntry): JournalEntryId {
        dslContext
            .newRecord(JOURNAL_ENTRIES)
            .setJournalId(journalEntry.journalId.value)
            .setSide(journalEntry.side)
            .setAccountId(journalEntry.accountId.value)
            .setValue(journalEntry.value)
            .store()
        return JournalEntryId(dslContext.lastID().toLong())
    }

    override fun bulkCreate(journalEntries: List<JournalEntry>): JournalEntryId {
        val queries = journalEntries.map {
            dslContext.insertInto(
                JOURNAL_ENTRIES,
                JOURNAL_ENTRIES.JOURNAL_ID,
                JOURNAL_ENTRIES.SIDE,
                JOURNAL_ENTRIES.ACCOUNT_ID,
                JOURNAL_ENTRIES.VALUE
            )
                .values(it.journalId.value, it.side, it.accountId.value, it.value)
        }
        dslContext.batch(queries).execute()

        // jOOQ では、まだ一括作成されたものの ID 一覧を取得してくることが難しいらしい...
        // ref: https://github.com/jOOQ/jOOQ/issues/3327
        return JournalEntryId(dslContext.lastID().toLong())
    }
}
