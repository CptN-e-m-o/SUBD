package subd.lr5.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tablestatement", schema = "public", catalog = "test")
@Getter
@Setter
public class Tablestatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tablestatementid")
    private int id;

    @Column(name = "mark")
    private int mark;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjectid")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentid")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherid")
    private Teacher teacher;


    public Tablestatement() {}

    public Tablestatement(int mark, Subject subject, Student student, Teacher teacher) {
        this.mark = mark;
        this.subject = subject;
        this.student = student;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Tablestatement {" +
                "tablestatementid=" + id +
                ", mark='" + mark + '\'' +
                ", subject_id='" + subject.getId() + '\'' +
                ", student_id='" + student.getId() + '\'' +
                ", teacher_id='" + teacher.getId() + '\'' +
                '}' + "\n";
    }
}
