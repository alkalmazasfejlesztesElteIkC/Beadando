package hu.inf.elte.csaladitodo.csaladitodo2000.modell;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String taskname;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User lead;

    @ManyToMany(mappedBy = "tasksToDo")
    @JsonIgnore
    private List<User> workers;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;

}