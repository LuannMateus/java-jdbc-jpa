import model.Student;
import repository.StudentCRITERIARepository;
import repository.StudentJPQLRepository;
import repository.StudentSQLRepository;
import service.StateService;
import service.StudentService;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    // jpaSqlTests();
    // jpqlTests();
    CriteriaTests();
  }

  public void jpaTests() {
    StudentService studentService = new StudentService();
    StateService stateService = new StateService();

    // State newState = new State("Sao Paulo", "SP");
    // Student newStudent = new Student("John Doe", 29, newState);

    // stateService.save(newState);
    // studentService.save(newStudent);

    // State searchState = stateService.findById(25);

    // boolean isUpdate = stateService.update(new State("Sao Paulo CHANGE", "SP"), 25);

    // boolean isDeleted = stateService.delete(25);

    Student searchStudent = studentService.findById(26);

    System.out.print(searchStudent);
  }

  public static void jpaSqlTests() {
    StudentSQLRepository studentSQLRepository = new StudentSQLRepository();

    // stateAndStudentSQLRepository.findByName("John Doe");

    List<Student> students = studentSQLRepository.findAll();

    students.stream().forEach(System.out::println);


  }

  public static void jpqlTests() {
    StudentJPQLRepository studentJPQLRepository = new StudentJPQLRepository();

    System.out.print(studentJPQLRepository.findByName("John Doe"));

    List<Student> students = studentJPQLRepository.findAll();

    students.stream().forEach(System.out::println);


  }

  public static void CriteriaTests() {
    StudentCRITERIARepository studentCRITERIARepository = new StudentCRITERIARepository();

    // System.out.print(stateAndStudentCRITERIARepository.findByName("John Doe"));

    List<Student> students = studentCRITERIARepository.findAll();

    students.stream().forEach(System.out::println);


  }
}
