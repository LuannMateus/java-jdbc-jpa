package repository;

import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentRepository {
  private EntityManagerFactory entityManagerFactory =
    Persistence.createEntityManagerFactory("part2-DIO");
  private EntityManager entityManager = entityManagerFactory.createEntityManager();

  public boolean save(Student student) {
    try {

      entityManager.getTransaction().begin();
      entityManager.persist(student);
      entityManager.getTransaction().commit();

      return true;
    } catch (Exception error) {
      return false;
    } finally {
      entityManager.close();
      entityManagerFactory.close();
    }
  }

  public Student findById(int id) {
    try {
      Student student = entityManager.find(Student.class, id);

      return student;
    } catch (Exception error) {

      System.out.println(error);
      return new Student();
    } finally {
      entityManager.close();
      entityManagerFactory.close();
    }
  }

  public boolean update(Student student, int id) {
    try {
      Student oldStudent = entityManager.find(Student.class, id);

      entityManager.getTransaction().begin();
      oldStudent.setName(student.getName());
      oldStudent.setAge(student.getAge());
      entityManager.getTransaction().commit();

      return true;
    } catch (Exception error) {
      return false;
    } finally {
      entityManager.close();
      entityManagerFactory.close();
    }
  }

  public boolean delete(int id) {
    try {
      Student student = entityManager.find(Student.class, id);

      entityManager.getTransaction().begin();
      entityManager.remove(student);
      entityManager.getTransaction().commit();

      return true;
    } catch (Exception error) {
      return false;
    } finally {
      entityManager.close();
      entityManagerFactory.close();
    }
  }


}
