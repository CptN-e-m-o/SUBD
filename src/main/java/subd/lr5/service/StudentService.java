package subd.lr5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.lr5.models.Groupuni;
import subd.lr5.models.Student;

import java.util.List;
import java.util.Scanner;

public class StudentService {
    public void StudentMenu(SessionFactory sf) {
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
            System.out.println("Input Studentname:");
            String studentname = scanner.next();
            System.out.println("Input if of group:");
            int groupid = scanner.nextInt();
            Student student = new Student(studentname, session.get(Groupuni.class, groupid));
            session.save(student);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Student> students = session.createQuery("SELECT c from Student c", Student.class).getResultList();
        System.out.println(students);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of student:");
            int id = scanner.nextInt();
            System.out.println("Input Studentname:");
            String studentname = scanner.next();
            System.out.println("Input if of group:");
            int groupid = scanner.nextInt();
            Student student = session.get(Student.class, id);
            student.setStudentname(studentname);
            student.setGroupuni(session.get(Groupuni.class, groupid));
            session.save(student);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of student:");
            int id = scanner.nextInt();
            Student student = session.get(Student.class, id);
            session.delete(student);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input studentname of student:");
            String studentname = scanner.next();
            List<Student> students = session.createQuery("SELECT c from Student c WHERE studentname = \'" + studentname + "\'", Student.class).getResultList();
            System.out.println(students);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
