/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JournalEntries implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long    id;
    private final Long    journalId;
    private final Byte    side;
    private final Long    accountId;
    private final Integer value;

    public JournalEntries(JournalEntries value) {
        this.id = value.id;
        this.journalId = value.journalId;
        this.side = value.side;
        this.accountId = value.accountId;
        this.value = value.value;
    }

    public JournalEntries(
        Long    id,
        Long    journalId,
        Byte    side,
        Long    accountId,
        Integer value
    ) {
        this.id = id;
        this.journalId = journalId;
        this.side = side;
        this.accountId = accountId;
        this.value = value;
    }

    /**
     * Getter for <code>simple_journal_entry_db.journal_entries.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for
     * <code>simple_journal_entry_db.journal_entries.journal_id</code>.
     */
    public Long getJournalId() {
        return this.journalId;
    }

    /**
     * Getter for <code>simple_journal_entry_db.journal_entries.side</code>.
     */
    public Byte getSide() {
        return this.side;
    }

    /**
     * Getter for
     * <code>simple_journal_entry_db.journal_entries.account_id</code>.
     */
    public Long getAccountId() {
        return this.accountId;
    }

    /**
     * Getter for <code>simple_journal_entry_db.journal_entries.value</code>.
     */
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JournalEntries (");

        sb.append(id);
        sb.append(", ").append(journalId);
        sb.append(", ").append(side);
        sb.append(", ").append(accountId);
        sb.append(", ").append(value);

        sb.append(")");
        return sb.toString();
    }
}
