package create;

import com.module5.TaskData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateTask {
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
}
