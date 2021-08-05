package service;

import model.State;
import model.Student;
import repository.StateRepository;
import repository.StudentRepository;

public class StateService {

  private static StateRepository stateRepository = new StateRepository();

  public boolean save(State state) {
    final boolean result = stateRepository.save(state);

    return result;
  }

  public State findById(int id) {
    State state = stateRepository.findById(id);

    return state;
  }

  public boolean update(State state, int id) {
    boolean result = stateRepository.update(state, id);

    return result;
  }

  public boolean delete(int id) {
    boolean result = stateRepository.delete(id);

    return result;
  }
}
