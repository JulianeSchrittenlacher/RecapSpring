package org.example.recapspring.model;

public enum Status {
    OPEN("OPEN"),
    DOING("DOING"),
    DONE("DONE");

    private final String name;
    Status(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}
