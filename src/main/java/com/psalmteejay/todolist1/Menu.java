

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
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    //provide your ToDoList object
    //declare your ToDoList topic

    static ArrayList<ToDoList> topicTodoList = new ArrayList<>();

    public static void main(String[] args) {

        //The run function will start the menu on the output screen
        run();
    }

    //create your run function with the following menu items
    private static void run() {


        boolean quit = false;
        String mainMenu = "" + "1. Add a topic\n" + "2. Show topics\n" + "3. Assign Task\n" + "4. Assign deadline\n"
                + "5. Create a task \n" + "6. Mark as done\n" + "7. Remove task \n" + "8. Rename task\n"
                + "9. Display\n\n" + "10. Quit\n\n";
        while (!quit) {

            //The Scanner will input the user's choice
            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            int choice = input.nextInt();

            //you can any conditional statement (if/else or switch)
            //each case, will run the function
            switch (choice) {
                case 1:
                    addTopic();
                    break;
                //create a case for each menu option
                case 2:
                    showTopic();
                    break;
                case 3:
                    assignATask();
                    break;
                case 4:
                    assignADeadline();
                    break;
                case 5:
                    createATask();
                    break;
                case 6:
                    markitAsDone();
                    break;
                case 7:
                    removeATask();
                    break;
                case 8:
                    renameATask();
                    break;
                case 9:
                    displayATask();
                    break;
                case 10:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid entry try again");

            }
        }
        System.exit(0);

    }


    private static void showTopic() {
        if(topicTodoList.isEmpty()){
            System.out.println("Our Todo List is currently empty!\n\n");
        }else {
            System.out.println("Here is our Todo List topic(s)\n");
            int topic = 0;
            for(int i = 0; i < topicTodoList.size(); i++) {
                topic++;
                System.out.println("Topic" + topic + ": " + topicTodoList.get(i).getTopic());
            }
            System.out.println("\n");
        }
    }

    private static void assignATask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic");
        String todolistRename = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(todolistRename)) {
                System.out.println("Please enter the task name");
                String taskName = sc.nextLine();
                System.out.println("Please enter the employee name");
                String employeeName = sc.nextLine();

                topicTodoList.get(i).renameTask(taskName, employeeName);
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }
    }

    private static void assignADeadline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic");
        String deadline = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(deadline)) {
                System.out.println("Please enter task name");
                String tname = sc.nextLine();
                System.out.println("Please enter due date in the format dd/MM/yyyy");
                Scanner scanner2 = new Scanner(System.in);
                Date d2 = null;
                try {
                    d2 = new SimpleDateFormat("dd/MM/yyyy").parse(scanner2.nextLine());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                topicTodoList.get(i).assignDeadLine(tname, d2);
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }
    }

    private static void markitAsDone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic whose task to mark");
        String markAsDone = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(markAsDone)) {
                System.out.println("Please enter the Task name");
                String taskName = sc.nextLine();

                topicTodoList.get(i).markAsDone(taskName);
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }
    }

    private static void removeATask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic whose task to remove");
        String todolistRemove = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(todolistRemove)) {
                System.out.println("Please enter the Task name");
                String taskName = sc.nextLine();

                topicTodoList.get(i).removeTask(taskName);
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }
    }


    private static void renameATask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic to rename");
        String todolistRename = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(todolistRename)) {
                System.out.println("Please enter the Old name");
                String oldName = sc.nextLine();
                System.out.println("Please enter the New name");
                String newName = sc.nextLine();

                topicTodoList.get(i).renameTask(oldName, newName);
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }

    }


    private static void displayATask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic to display");
        String todolistDisplay = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(todolistDisplay)) {
                topicTodoList.get(i).display();
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }
    }

    private static void createATask() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the todo list topic to add task");
        String todolistTopic = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(todolistTopic)) {
                topicTodoList.get(i).createTask();
                return;

            } else {
                System.out.println("Topic does not exists. Try again");
            }
        }


    }
    //implement the method for each case.  I have provided example code
    //for the first option, addTopic.
    private static void addTopic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter topic name");
        String topicName = sc.nextLine();

        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).getTopic().equals(topicName)) {
                System.out.println("Topic already exists. Try again");
                return;
            }
        }

        topicTodoList.add(new ToDoList(topicName));
        System.out.println("Topic added successfully\n\n");

    }


}
