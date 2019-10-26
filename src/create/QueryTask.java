package create;

import com.module5.TaskData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class QueryTask {
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

    private static void displayTodoList(@NotNull List<TaskData> todoTaskList) {
        for (TaskData tempList : todoTaskList) {
            System.out.println(tempList);
        }

    }
}
