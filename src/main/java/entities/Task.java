package entities;

import java.util.Date;
import java.util.List;


//TODO: initialize list

public class Task {
    private final String id;

    private final Project project;

    private String description;

    private final Date created;

    private Date deadline;

    private List<Assignee> assignees;

    public Task(String id, Project project, String description) {
        this.id = id;
        this.project = project;
        this.description = description;
        created = new Date();
    }

    public Task(String id, Project project, String description, Date deadline) {
        this(id, project, description);
        this.deadline = deadline;
    }

    public Task(String id, Project project, String description, List<Assignee> assignees) {
        this(id, project, description);
        this.assignees = assignees;
    }

    public Task(String id, Project project, String description, Date deadline, List<Assignee> assignees) {
        this(id, project, description);
        this.deadline = deadline;
        this.assignees = assignees;
    }

    public String getId() {
        return id;
    }

    public Project getProject() {
        return project;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
