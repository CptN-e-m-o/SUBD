package subd.lr5.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import subd.lr5.models.*;

import java.util.List;
import java.util.Scanner;

public class GroupuniService {
    public void GroupuniMenu(SessionFactory sf) {
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
            System.out.println("Input groupuniname:");
            String groupuniname = scanner.next();
            Groupuni groupuni = new Groupuni(groupuniname);
            session.save(groupuni);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Read(Session session) {
        List<Groupuni> expens = session.createQuery("SELECT e from Groupuni e", Groupuni.class).getResultList();
        System.out.println(expens);
    }

    private void Update(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of groupuni:");
            int id = scanner.nextInt();
            System.out.println("Input groupuniname:");
            String groupuniname = scanner.next();

            Groupuni groupuni = session.get(Groupuni.class, id);
            groupuni.setGroupuniname(groupuniname);
            session.save(groupuni);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Delete(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input id of groupuni:");
            int id = scanner.nextInt();
            Groupuni groupuni = session.get(Groupuni.class, id);
            session.delete(groupuni);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

    private void Filter(Session session) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input groupuniname of groupuni:");
            String groupuniname = scanner.next();
            List<Groupuni> expens = session.createQuery("SELECT e from Groupuni e WHERE groupuniname = " + groupuniname , Groupuni.class).getResultList();
            System.out.println(expens);
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }
}
