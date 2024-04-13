package com.timnjonjo.cards.persistence;

public enum Status {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private String desc;

    Status(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
