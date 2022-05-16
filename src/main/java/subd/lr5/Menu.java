package subd.lr5;

import subd.lr5.models.*;
import subd.lr5.service.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Subject.class)
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Tablestatement.class)
                .addAnnotatedClass(Groupuni.class)
                .buildSessionFactory();

        boolean isMenu = true;
        while(isMenu){
            try {
                ZaprosService zs = new ZaprosService();
                zs.work(sessionFactory);
                System.out.println("\n\nInput a number to work with:"
                        + "\n1) Subjects" + "\n2) Teachers" + "\n3) Students" + "\n4) Tablestatements" + "\n5) Groupuni 6)Zapros"
                        + "\nInput 0 to finish");

                Scanner scn = new Scanner(System.in);
                int input = scn.nextInt();

                switch (input){
                    case 0:
                        isMenu = false;
                        break;
                    case 1:
                        SubjectService ss = new SubjectService();
                        try {
                            ss.SubjectMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            ss.SubjectMenu(sessionFactory);
                        }
                        break;
                    case 2:
                        TeacherService ts = new TeacherService();
                        try {
                            ts.TeacherMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            ts.TeacherMenu(sessionFactory);
                        }

                        break;
                    case 3:
                        StudentService sts = new StudentService();
                        try {
                            sts.StudentMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            sts.StudentMenu(sessionFactory);
                        }

                        break;
                    case 4:
                        TablestatementService tss = new TablestatementService();
                        try {
                            tss.TablestatementMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            tss.TablestatementMenu(sessionFactory);
                        }

                        break;
                    case 5:
                        GroupuniService gs = new GroupuniService();
                        try {
                            gs.GroupuniMenu(sessionFactory);
                        }
                        catch (Exception ex){
                            System.out.println(ex);
                            gs.GroupuniMenu(sessionFactory);
                        }

                        break;
                }
            }
            catch (Exception ex){
                System.out.println(ex);
            }
        }
        sessionFactory.close();
    }
}
