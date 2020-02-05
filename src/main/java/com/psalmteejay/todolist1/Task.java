
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalmteejay.todolist1;

/**
 *
 * @author Omali
 */
import java.util.Date;

public class Task {

    //variable name suggestions
    private String name;
    private Date deadLine;
    private String employee;
    private boolean isDone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //create get and set methods for the DeadLine and Employee
    //similar to how get and set Name are created
    //pay attention to how teh datatype of the variables are declared

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Task name = " + name + " , employee = " + employee + " , deadline = " + deadLine + ", Done = " + isDone;
    }

}
