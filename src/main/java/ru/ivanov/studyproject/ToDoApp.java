package ru.ivanov.studyproject;

import ru.ivanov.studyproject.controller.Controller;
import ru.ivanov.studyproject.dao.DataSource;
import ru.ivanov.studyproject.entities.*;

public class ToDoApp {

    public static void main(String[] args) throws Exception {
        DataSource.getDataSource().createOrUpdateEntity(new Project());
        DataSource.getDataSource().createOrUpdateEntity(new Task());
        DataSource.getDataSource().createOrUpdateEntity(new Assignee());
        DataSource.getDataSource().createOrUpdateEntity(new Teamlead());
        DataSource.getDataSource().createOrUpdateEntity(new Client());
        Controller controller = new Controller();
        controller.getMainView().selectSection();
    }
}
