package repository;

import model.Student;
import model.Student_;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentCRITERIARepository {
  private EntityManagerFactory entityManagerFactory =
    Persistence.createEntityManagerFactory("part2-DIO");
  private EntityManager entityManager = entityManagerFactory.createEntityManager();

  public List<Student> findAll() {
    CriteriaQuery<Student> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Student.class);
    Root<Student> studentRoot = criteriaQuery.from(Student.class);

    List<Student> studentAPICriteriaList = entityManager.createQuery(criteriaQuery).getResultList();

    return  studentAPICriteriaList;
  }

  public Student findByName(String name) {
    CriteriaQuery<Student> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Student.class);
    Root<Student> studentRoot = criteriaQuery.from(Student.class);
    CriteriaBuilder.In<String> inClause = entityManager.getCriteriaBuilder().in(studentRoot.get(Student_.name));
    inClause.value(name);
    criteriaQuery.select(studentRoot).where(inClause);
    Student studentAPICriteria = entityManager.createQuery(criteriaQuery).getSingleResult();

    return studentAPICriteria;
  }
}
