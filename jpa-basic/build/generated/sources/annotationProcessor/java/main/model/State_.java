package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(State.class)
public abstract class State_ {

	public static volatile SingularAttribute<State, String> initials;
	public static volatile SingularAttribute<State, String> name;
	public static volatile ListAttribute<State, Student> students;
	public static volatile SingularAttribute<State, Integer> id;

	public static final String INITIALS = "initials";
	public static final String NAME = "name";
	public static final String STUDENTS = "students";
	public static final String ID = "id";

}

