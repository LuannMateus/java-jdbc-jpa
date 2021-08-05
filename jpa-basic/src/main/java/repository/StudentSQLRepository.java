package repository;

import model.State;
import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentSQLRepository {
  private EntityManagerFactory entityManagerFactory =
    Persistence.createEntityManagerFactory("part2-DIO");
  private EntityManager entityManager = entityManagerFactory.createEntityManager();

  public List<Student> findAll() {
    String SQL = "SELECT * FROM Student";

    List<Student> studentListSQL = (List<Student>) entityManager
      .createNativeQuery(SQL, Student.class)
      .getResultList();

    return studentListSQL;
  }

  public Student findByName(String name) {
    String SQL = "SELECT * FROM Student WHERE name = :name ";

    Student studentSQL = (Student) entityManager
      .createNativeQuery(SQL, Student.class)
      .setParameter("name", name)
      .getSingleResult();

    return studentSQL;
  }

}
