package create;

import com.module5.TaskData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class CreateTask {
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
}
