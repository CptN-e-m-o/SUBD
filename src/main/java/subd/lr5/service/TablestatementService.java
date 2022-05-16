package subd.lr5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.lr5.models.*;

import java.util.List;
import java.util.Scanner;

public class TablestatementService {
    public void TablestatementMenu(SessionFactory sf) {
        System.out.println("Input a number to choose the action:"
                + "\n1) Create" + "\n2) Read" + "\n3) Update" + "\n4) Delete" + "\n5) Filter");
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();

        Session session = null;
        session = sf.getCurrentSession();
        session.beginTransaction();

        try {
            switch (input){
                case 1:
                    Create(session);
                    break;
                case 2:
                    Read(session);
                    break;
                case 3:
                    Update(session);
                    break;
                case 4:
                    Delete(session);
                    break;
                case 5:
                    Filter(session);
                    break;
            }
            session.getTransaction().commit();
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }


    private void Create(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input mark");
            int mark = scanner.nextInt();
            System.out.println("Input id of subject");
            int subjectid = scanner.nextInt();
            System.out.println("Input id of student");
            int studentid = scanner.nextInt();
            System.out.println("Input id of teacher");
            int teacherid = scanner.nextInt();

            Tablestatement tableStatement = new Tablestatement(mark,
                    session.get(Subject.class, subjectid), session.get(Student.class, studentid), session.get(Teacher.class, teacherid));
            session.save(tableStatement);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Tablestatement> tablestatements = session.createQuery("SELECT c from Tablestatement c", Tablestatement.class).getResultList();
        System.out.println(tablestatements);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of tableStatement:");
            int id = scanner.nextInt();
            System.out.println("Input mark");
            int mark = scanner.nextInt();
            System.out.println("Input id of subject");
            int subjectid = scanner.nextInt();
            System.out.println("Input id of student");
            int studentid = scanner.nextInt();
            System.out.println("Input id of teacher");
            int teacherid = scanner.nextInt();

            Tablestatement tableStatement = session.get(Tablestatement.class, id);
            tableStatement.setMark(mark);
            tableStatement.setSubject(session.get(Subject.class, subjectid));
            tableStatement.setStudent(session.get(Student.class, studentid));
            tableStatement.setTeacher(session.get(Teacher.class, teacherid));
            session.save(tableStatement);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of tableStatement:");
            int id = scanner.nextInt();
            Tablestatement tableStatement = session.get(Tablestatement.class, id);
            session.delete(tableStatement);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input mark:");
            int mark = scanner.nextInt();
            List<Tablestatement> tablestatements = session.createQuery("SELECT c from Tablestatement c WHERE mark = " + mark , Tablestatement.class).getResultList();
            System.out.println(tablestatements);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
