package service;

import model.Student;
import repository.StudentRepository;

public class StudentService {

  private static StudentRepository studentRepository = new StudentRepository();

  public boolean save(Student student) {
    final boolean result = studentRepository.save(student);

    return result;
  }

  public Student findById(int id) {
    Student student = studentRepository.findById(id);

    return student;
  }

  public boolean update(Student student, int id) {
    boolean result = studentRepository.update(student, id);

    return result;
  }

  public boolean delete(int id) {
    boolean result = studentRepository.delete(id);

    return result;
  }
}
