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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ToDoList {

    private String topic;
    private HashMap<String, Task> tasks;

    public ToDoList(String topicName) {

        this.topic = topicName;
        this.tasks = new HashMap<>();
    }

    ToDoList() {}

    public String getTopic() {
        return topic;
    }

    //below, implement the methods provided in the UML diagram
    //I provided the task creation and the task creation methods
    //implement boolean method for assignTask, assignDeadLine
    //display, markAsDone, removeTask and renameTask
    public void assignTask(String taskName, String employee) {
        System.out.println("Assigning " + employee + " to " + taskName);
        if (this.tasks.containsKey(taskName)){
            this.tasks.get(taskName).setEmployee(employee);
        }else {
            System.out.println("No such task!");
        }
    }

    public void assignDeadLine(String taskName, Date dueDate) {
        System.out.println("Assigning " + dueDate + " to " + taskName);
        if (this.tasks.containsKey(taskName)){
            this.tasks.get(taskName).setDeadLine(dueDate);
        }else {
            System.out.println("No such task!");
        }
    }

    public void markAsDone(String taskName) {

        System.out.println("Marking " + taskName + " as completed");
        if (this.tasks.containsKey(taskName)){
            this.tasks.get(taskName).setDone(true);
        }else {
            System.out.println("No such task!");
        }
    }

    public void removeTask(String taskName) {
        if (this.tasks.containsKey(taskName)){
            System.out.println("Removing " + taskName);
            this.tasks.remove(taskName);
        }else {
            System.out.println("No such task!");
        }
    }

    public void renameTask(String oldTask, String newTask) {
        System.out.println("Renaming " + oldTask + " to " + newTask);
        if (this.tasks.containsKey(oldTask)){
            this.tasks.put(newTask, this.tasks.get(oldTask));
            this.tasks.remove(oldTask);
        }else {
            System.out.println("No such task!");
        }
    }

    public void display() {

        if(this.tasks.isEmpty()){
            System.out.println("Our Todo List for " + topic + "is currently empty!\n\n");
        }else {
            System.out.println("Here is our Todo List for " + topic + "\n");
            for (Map.Entry<String, Task> task : this.tasks.entrySet()) {
                if (task.getValue().isDone() == true) {
                    System.out.println("Task " + task.getKey() + " is complete");
                }else {
                    System.out.println("Task " + task.getKey() + " is not done");
                }
            }
            System.out.println("\n\n");
        }
    }

    public void createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name");
        String taskName = sc.nextLine();

        for(Map.Entry<String, Task> task : this.tasks.entrySet()) {
            if (task.getKey().equals(taskName)) {
                System.out.println("Task already exists. Try again");
                return;
            }
        }

        System.out.println("Please enter employee name");
        String empname = sc.nextLine();
        System.out.println("Please enter due date");
        System.out.println("Please enter your date in the format dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        Date d = null;
        try {
            d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Task t = new Task();
        t.setName(taskName);
        t.setDeadLine(d);
        t.setEmployee(empname);

        this.tasks.put(taskName, t);
        System.out.println("Task added successfully.\n\n");

    }

}
