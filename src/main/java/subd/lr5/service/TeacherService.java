package subd.lr5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.lr5.models.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherService {
    public void TeacherMenu(SessionFactory sf) {
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
            System.out.println("Input name of teacher:");
            String nameteacher = scanner.next();
            System.out.println("Input start contract date:");
            String sd = scanner.next();
            java.sql.Date startcontract = java.sql.Date.valueOf(sd);
            System.out.println("Input end contract date:");
            String ed = scanner.next();
            java.sql.Date endcontract = java.sql.Date.valueOf(ed);
            Teacher teacher = new Teacher(nameteacher, startcontract, endcontract);
            session.save(teacher);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Teacher> teachers = session.createQuery("SELECT e from Teacher e", Teacher.class).getResultList();
        System.out.println(teachers);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of teacher:");
            int id = scanner.nextInt();
            System.out.println("Input name of teacher:");
            String nameteacher = scanner.next();
            System.out.println("Input start contract date:");
            String sd = scanner.next();
            java.sql.Date startcontract = java.sql.Date.valueOf(sd);
            System.out.println("Input end contract date:");
            String ed = scanner.next();
            java.sql.Date endcontract = java.sql.Date.valueOf(ed);
            Teacher teacher = session.get(Teacher.class, id);
            teacher.setTeachername(nameteacher);
            teacher.setStartcontract(startcontract);
            teacher.setEndcontract(endcontract);
            session.save(teacher);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of teacher:");
            int id = scanner.nextInt();
            Teacher teacher = session.get(Teacher.class, id);
            session.delete(teacher);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input teachername:");
            String teachername = scanner.next();
            List<Teacher> teachers = session.createQuery("SELECT e from Teacher e WHERE teachername = \'" + teachername + "\'", Teacher.class).getResultList();
            System.out.println(teachers);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
