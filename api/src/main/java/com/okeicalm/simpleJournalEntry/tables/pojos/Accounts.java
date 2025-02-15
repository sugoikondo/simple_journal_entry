/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long    id;
    private final String  code;
    private final String  name;
    private final Integer elementType;

    public Accounts(Accounts value) {
        this.id = value.id;
        this.code = value.code;
        this.name = value.name;
        this.elementType = value.elementType;
    }

    public Accounts(
        Long    id,
        String  code,
        String  name,
        Integer elementType
    ) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.elementType = elementType;
    }

    /**
     * Getter for <code>simple_journal_entry_db.accounts.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>simple_journal_entry_db.accounts.code</code>.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Getter for <code>simple_journal_entry_db.accounts.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>simple_journal_entry_db.accounts.element_type</code>.
     */
    public Integer getElementType() {
        return this.elementType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Accounts (");

        sb.append(id);
        sb.append(", ").append(code);
        sb.append(", ").append(name);
        sb.append(", ").append(elementType);

        sb.append(")");
        return sb.toString();
    }
}
