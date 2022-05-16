package subd.lr5.service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.lr5.models.*;

import java.util.List;

public class ZaprosService {
    public void work (SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Student> students = session.createQuery("SELECT c FROM Student c", Student.class).getResultList();
        System.out.print("~Students~");
        for (int i = 0; i < students.size(); i++) {
            System.out.format("\nFull name: %s, Groupuniid: %s;", students.get(i).getStudentname(),
                    students.get(i).getGroupuni());
        }
        session.getTransaction().commit();
    }
}
