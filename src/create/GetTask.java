package create;

import com.module5.TaskData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetTask {
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
