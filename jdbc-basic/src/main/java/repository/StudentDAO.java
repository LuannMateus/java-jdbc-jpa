package repository;

import database.ConnectionFactory;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
  public List<Student> findAll() {
    List<Student> students = new ArrayList<>();

    try (Connection conn = ConnectionFactory.getConnection()) {
      String sql = "SELECT * FROM aluno";

      PreparedStatement stmt = conn.prepareStatement(sql);

      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("nome");
        int age = rs.getInt("idade");
        String state = rs.getString("estado");

        students.add(new Student(
          id,
          name,
          age,
          state
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return students;
  }

  public Student findById(int id) {
    Student student = new Student();

    try (Connection conn = ConnectionFactory.getConnection()) {
      String sql = "SELECT * FROM aluno WHERE id = ?";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);

      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("nome"));
        student.setAge(rs.getInt("idade"));
        student.setState(rs.getString("estado"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return student;
  }

  public void save(Student student) {
    try (Connection conn = ConnectionFactory.getConnection()) {
      String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?, ?, ?)";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, student.getName());
      stmt.setInt(2, student.getAge());
      stmt.setString(3, student.getState());


      int rowsAffected = stmt.executeUpdate();

      System.out.println("Insert with success!. Line affected: " + rowsAffected);

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void update(Student student) {
    try (Connection conn = ConnectionFactory.getConnection()) {
      String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, student.getName());
      stmt.setInt(2, student.getAge());
      stmt.setString(3, student.getState());
      stmt.setInt(4, student.getId());

      int rowsAffected = stmt.executeUpdate();

      System.out.println("Update with success!. Line affected: " + rowsAffected);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(int id) {
    try (Connection conn = ConnectionFactory.getConnection()) {
      String sql = "DELETE FROM aluno WHERE id = ?";

      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);

      int rowsAffected = stmt.executeUpdate();

      System.out.println("Delete with success!. Line affected: " + rowsAffected);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}

