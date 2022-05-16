package subd.lr5.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "student", schema = "public", catalog = "test")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private int id;

    @Column(name = "studentname")
    private String studentname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupuniid")
    private Groupuni groupuni;




    public Student() {}

    public Student(String studentname, Groupuni groupuni) {
        this.studentname = studentname;
        this.groupuni = groupuni;
    }

    @Override
    public String toString() {
        return "Student {" +
                "studentid=" + id +
                ", studentname='" + studentname + '\'' +
                ", groupuniid='" + groupuni.getId() + '\'' +
                '}' + "\n";
    }
}
