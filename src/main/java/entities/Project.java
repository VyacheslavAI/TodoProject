package entities;

import java.util.Date;
import java.util.List;


//TODO: initialize list

public class Project {
    private String id;

    private Client client;

    private ResponsiblePerson person;

    private String description;

    private Date created;

    private Date deadline;

    private List<Task> tasks;

    private List<Assignee> assignees;

    public Project(String id, Client client, ResponsiblePerson person, String description) {
        this.id = id;
        this.client = client;
        this.person = person;
        this.description = description;
        created = new Date();
    }

    public Project(String id, Client client, ResponsiblePerson person, String description, Date deadline) {
        this(id, client, person, description);
        this.deadline = deadline;
    }

    public Project(String id, Client client, ResponsiblePerson person, String description, List<Assignee> assignees) {
        this(id, client, person, description);
        this.assignees = assignees;
    }

    public Project(String id, Client client, ResponsiblePerson person, String description, Date deadline, List<Assignee> assignees) {
        this(id, client, person, description);
        this.deadline = deadline;
        this.assignees = assignees;
    }

    public String getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public ResponsiblePerson getPerson() {
        return person;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreated() {
        return created;
    }

    public Date getDeadline() {
        return deadline;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPerson(ResponsiblePerson person) {
        this.person = person;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
