package create;

import com.module5.TaskData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class Crud {

    /**
     * Creates a task
     */
    public void createMethod() {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(TaskData.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        System.out.println("===== Enter a task then press enter ===== ");
        System.out.println("To-do item: ");

        Scanner inputTask = new Scanner(System.in);
        // Console inputs for a to do task
        System.out.println("Enter Task");
        String todo = inputTask.nextLine();

        System.out.println("Enter Description");
        String description = inputTask.nextLine();

        System.out.println("todo " + " | " + "description");
        System.out.println("__________________________________");
        System.out.println(todo + " | " + description + " | ");
        try {

            try {
                // create a task object
                System.out.println("Creating new task object...");
                System.out.println(" Inserting --" + todo + "| AND |" + description);
                TaskData todoTaskItem = new
                        TaskData(todo, description);
                System.out.println(todo + description);
                System.out.println(todoTaskItem);

                // start a transaction
                session.beginTransaction();

                // save the task object
                System.out.println("Saving the task...");
                session.save(todoTaskItem);

                // commit transaction
                session.getTransaction().commit();


                System.out.println("Done!");

            } catch (Exception e) {
                e.printStackTrace();
            }


        } finally {
            factory.close();
        }
    }

    /***
     * Gets a task from database
     */
    public void queryTaskMethod() {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(TaskData.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        try {

            try {

                // start a transaction
                session.beginTransaction();

                // query task
                List<TaskData> todoTaskList = session.createQuery("from TaskData").list();

                // display the task
                displayTodoList(todoTaskList);

                // query to_do_items: lastName='Doe'
                todoTaskList = session.createQuery("from TaskData s where s.todo='new'").list();

                // display the task
                System.out.println("\n\nTaskData items who have last name of Doe");
                displayTodoList(todoTaskList);

                // query to_do_items: lastName='Doe' OR firstName='Daffy'
                todoTaskList =
                        session.createQuery("from TaskData s where"
                                + " s.todo='new' OR s.todo='hbjh'").list();

                System.out.println("\n\nTaskData items who have last name of Doe OR first name Daffy");
                displayTodoList(todoTaskList);

//                            // query to do item where email LIKE '%gmail.com'
//                            todoTaskList = session.createQuery("from TaskData s where"
//                                    + " s.email LIKE '%gmail.com'").list();

                System.out.println("\n\n TaskData items whose email ends with gmail.com");
                displayTodoList(todoTaskList);


                // commit transaction
                session.getTransaction().commit();

                System.out.println("Done!");

            } catch (Exception e) {
                e.printStackTrace();
            }


        } finally {
            factory.close();
        }

    }

    /***
     *  List tat displays data in the database
     * @param todoTaskList
     */
    private static void displayTodoList(@NotNull List<TaskData> todoTaskList) {
        for (TaskData tempList : todoTaskList) {
            System.out.println(tempList);
        }

    }

    /**
     *  Updates data in the database
     */
    public void updateMethod() {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(TaskData.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 20;

            // now get a new session and start transaction

            session.beginTransaction();

            // retrieve task based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            TaskData myStudent = session.get(TaskData.class, studentId);

            System.out.println("Updating student...");
            myStudent.setTodo("fefef");

            // commit the transaction
            session.getTransaction().commit();

            // NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            // update task
            System.out.println("Update email for all students");

            session.createQuery("update TaskData set todo='foo'")
                    .executeUpdate();

            // commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    /**
     *  Deletes the data from the database
     */
    public void deleteMethod() {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(TaskData.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            try {


                System.out.println("Enter task id to delete");
                Scanner selectedItemId = new Scanner(System.in);
                int todoItemId = selectedItemId.nextInt();


                // now get a new session and start transaction
                session = factory.getCurrentSession();
                session.beginTransaction();

                // retrieve task based on the id: primary key
                System.out.println("\nGetting task with id: " + todoItemId);

                TaskData deleteTaskItem = session.get(TaskData.class, todoItemId);

                //delete the task
                System.out.println("Deleting task: " + deleteTaskItem);
                session.delete(deleteTaskItem);

//                            // delete to do items id=2
//                            System.out.println("Deleting to_do_items id=2");
//
//                            session.createQuery("delete from to_do_items where id=2").executeUpdate();

                // commit the transaction
                session.getTransaction().commit();

                System.out.println("Done!");

            } catch (Exception e) {
                e.printStackTrace();
            }


        } finally {
            factory.close();
        }
    }

    /**
     *  Retrieves a single task by id
     */
    public void getTaskMethod() {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(TaskData.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // create a task object
            System.out.println("Creating new task object...");
            TaskData taskItem = new TaskData("task", "desc");

            // start a transaction
            session.beginTransaction();

            // save the task object
            System.out.println("Saving the task...");
            System.out.println(taskItem);
            session.save(taskItem);

            // commit transaction
            session.getTransaction().commit();

            // MY NEW CODE

            // find out the task's id: primary key
            System.out.println("Saved task. Generated id: " + taskItem.getId());

            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve task based on the id: primary key
            System.out.println("\nGetting task with id: " + taskItem.getId());

            TaskData toDoTaskItem = session.get(TaskData.class, taskItem.getId());

            System.out.println("Get complete: " + toDoTaskItem);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }


}
