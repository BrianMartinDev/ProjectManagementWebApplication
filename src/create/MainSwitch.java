package create;

import java.util.Scanner;

public class MainSwitch {

    public static void main(String[] args) {

        System.out.println("===== This is a database connection entry application written in Java. ===== ");
        System.out.println("Commands: ");
        System.out.println("    Enter (1) to Add a to-do item.");
        System.out.println("    Enter (2) to Delete a to-do item.");
        System.out.println("    Enter (3) to Query a to-do item.");
        System.out.println("    Enter (4) to Retrieve a to-do item by id.");

        do {
            System.out.println();
            System.out.print("Enter a command: ");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if (!command.matches("[0-9]+")) {
                System.out.println("Input does not exist try another command");
            }

            switch (command) {
                case "1": // to Add a to-do item.

                    CreateTask newTask = new CreateTask();
                    newTask.createMethod();

                    break;

                case "2": // to Delete a to-do item.

                    DeleteTask taskDelete = new DeleteTask();
                    taskDelete.deleteMethod();

                    break;

                case "3": // to Query a to-do item.

                    QueryTask taskQuery = new QueryTask();
                    taskQuery.queryTaskMethod();

                    break;

                case "4": // retrieve to do item based on the id: primary key

                    GetTask taskGet = new GetTask();
                    taskGet.getTaskMethod();

                    break;
                case "5": // update task

                    UpdateTask editTask = new UpdateTask();
                    editTask.updateMethod();
                    break;

                default:
                    System.out.println("Commands: ");
                    System.out.println("    Enter (1) to Add a to-do item.");
                    System.out.println("    Enter (2) to Delete a to-do item.");
                    System.out.println("    Enter (3) to Query a to-do item.");
                    System.out.println("    Enter (4) to Retrieve a to-do item by id.");
                    System.out.println("    Enter (5) to Update a to-do item.");

            }

        } while (true);

    }

}
