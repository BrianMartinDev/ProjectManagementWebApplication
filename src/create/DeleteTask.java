package create;

import com.module5.TaskData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteTask {

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
}