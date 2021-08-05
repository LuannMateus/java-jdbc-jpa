package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, Integer> id;
	public static volatile SingularAttribute<Student, State> state;
	public static volatile SingularAttribute<Student, Integer> age;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String AGE = "age";

}

