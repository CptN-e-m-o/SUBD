package subd.lr5.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "teacher", schema = "public", catalog = "test")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherid")
    private int id;

    @Column(name = "teachername")
    private String teachername;

    @Column(name = "startcontract")
    private Date startcontract;

    @Column(name = "endcontract")
    private Date endcontract;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tablestatement> tablestatements;

    public Teacher() { }

    public Teacher(String teachername, Date startcontract, Date endcontract) {
        this.teachername = teachername;
        this.startcontract = startcontract;
        this.endcontract = endcontract;
    }

    @Override
    public String toString() {
        return "Teacher {" +
                "teacherid=" + id +
                ", teachername='" + teachername + '\'' +
                ", startcontract='" + startcontract + '\'' +
                ", endcontract='" + endcontract + '\'' +
                '}' + "\n";
    }
}
