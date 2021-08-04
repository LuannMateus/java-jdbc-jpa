package service;

import model.Student;
import repository.StudentDAO;

import java.util.List;

public class StudentService {
  static StudentDAO studentDAO = new StudentDAO();

  public static void main(String[] args) {
    //List<Student> students = findAll();
    //students.stream().forEach(System.out::println);

    //Student student = findById(1);
    //System.out.println(student);

    //final Student student = new Student("John Doe", 31, "CE");
    //save(student);
    //List<Student> students = findAll();
    //students.stream().forEach(System.out::println);

    /*final Student student = new Student(5, "John Doe CHANGE", 34, "SP");
    update(student);
    List<Student> students = findAll();
    students.stream().forEach(System.out::println);*/

    delete(5);
    List<Student> students = findAll();
    students.stream().forEach(System.out::println);


  }

  public static List<Student> findAll() {
    List<Student> students = studentDAO.findAll();

    // students.stream().forEach(System.out::println);
    return students;
  }

  public static Student findById(int id) {
    Student student = studentDAO.findById(id);

    // students.stream().forEach(System.out::println);
    return student;
  }

  public static void save(Student student) {
    studentDAO.save(student);
  }

  public static void update(Student student) {
    studentDAO.update(student);
  }

  public static void delete(int id) {
    studentDAO.delete(id);
  }
}
