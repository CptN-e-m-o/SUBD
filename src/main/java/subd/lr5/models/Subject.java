package subd.lr5.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subject", schema = "public", catalog = "test")
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectid")
    private int id;

    @Column(name = "subjectname")
    private String subjectname;


    public Subject() { }

    public Subject(String subjectname) {
        this.subjectname = subjectname;
    }

    @Override
    public String toString() {
        return "Subject {" +
                "subjectid=" + id +
                ", subjectname='" + subjectname + '\'' +
                '}' + "\n";
    }
}
