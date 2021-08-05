package repository;

import model.State;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StateRepository {
  private EntityManagerFactory entityManagerFactory =
    Persistence.createEntityManagerFactory("part2-DIO");
  private EntityManager entityManager = entityManagerFactory.createEntityManager();

  public boolean save(State state) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(state);
      entityManager.getTransaction().commit();

      return true;
    } catch (Exception error) {
      return false;
    } finally {
      entityManager.close();
      entityManagerFactory.close();
    }
  }

  public State findById(int id) {
    try {
      State state = entityManager.find(State.class, id);

      return state;
    } catch (Exception error) {
      System.out.println(error);

      return new State();
    } finally {
      entityManager.close();
      entityManagerFactory.close();
    }
  }

  public boolean update(State state, int id) {
    try {
      State oldState = entityManager.find(State.class, id);

      entityManager.getTransaction().begin();
      oldState.setName(state.getName());
      oldState.setInitials(state.getInitials());
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
      State state = entityManager.find(State.class, id);

      entityManager.getTransaction().begin();
      entityManager.remove(state);
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
