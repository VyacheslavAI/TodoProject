package ru.ivanov.studyproject.entities;

import java.util.UUID;

public class Client {

    private String id;

    private String relationId;

    private String companyName;

    public Client() {
        id = UUID.randomUUID().toString();
    }

    public Client(String companyName) {
        this();
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
}
