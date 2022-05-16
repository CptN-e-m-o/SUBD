package subd.lr5.service;

import org.hibernate.SessionFactory;
import subd.lr5.models.Subject;
import org.hibernate.Session;

import java.util.Scanner;
import java.util.List;

public class SubjectService {
    public void SubjectMenu(SessionFactory sf) {
        System.out.println("Input a number to choose the action:"
                + "\n1) Create" + "\n2) Read" + "\n3) Update" + "\n4) Delete" + "\n5) Filter");
        Scanner scn = new Scanner(System.in);
        int input = scn.nextInt();

        Session session = null;
        session = sf.getCurrentSession();
        session.beginTransaction();

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

    private void Create(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input Subject name:");
            String subjectname = scanner.nextLine();
            Subject subject = new Subject(subjectname);
            session.save(subject);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Subject> subjects = session.createQuery("SELECT t from Subject t", Subject.class).getResultList();
        System.out.println(subjects);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of subject:");
            int id = scanner.nextInt();
            System.out.println("Input Subject name:");
            String subjectname = scanner.nextLine();
            Subject subject = session.get(Subject.class, id);
            subject.setSubjectname(subjectname);
            session.save(subject);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of subject:");
            int id = scanner.nextInt();
            Subject subject = session.get(Subject.class, id);
            session.delete(subject);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input name of subject:");
            String name = scanner.next();
            List<Subject> subjects = session.createQuery("SELECT t from Subject t WHERE subjectname = \'" + name + "\'", Subject.class).getResultList();
            System.out.println(subjects);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
