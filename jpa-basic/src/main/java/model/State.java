package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class State {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String initials;

  @OneToMany(
    mappedBy = "state",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Student> students = new ArrayList<>();

  public State() {
  }

  public State(String name, String initials) {
    this.name = name;
    this.initials = initials;
  }

  public State(String name, String initials, List<Student> students) {
    this.name = name;
    this.initials = initials;
    this.students = students;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInitials() {
    return initials;
  }

  public void setInitials(String initials) {
    this.initials = initials;
  }

  public List<Student> getStudents() {
    return students;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  @Override
  public String toString() {
    return "Estado{" +
      "id = " + id +
      ", nome = '" + name + '\'' +
      ", sigla = '" + initials + '\'' +
      '}';
  }
}