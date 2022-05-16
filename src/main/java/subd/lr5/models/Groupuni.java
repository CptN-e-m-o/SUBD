package subd.lr5.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "groupuni", schema = "public", catalog = "test")
@Getter
@Setter
public class Groupuni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupuniid")
    private int id;

    @Column(name = "groupuniname")
    private String groupuniname;

    @OneToMany(mappedBy = "groupuni", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    public Groupuni() {}

    public Groupuni(String groupuniname) {
        this.groupuniname = groupuniname;
    }

    @Override
    public String toString() {
        return "Groupuni {" +
                "groupuniid=" + id +
                ", groupuniname='" + groupuniname + '\'' +
                '}' + "\n";
    }
}
