package com.msouza.revjpa;

import java.util.List;

import com.msouza.revjpa.dao.PersonDao;
import com.msouza.revjpa.entity.Person;

public class AppRevJpa {

	public static void main(String[] args) {
		System.out.println("Hello Word");
		// insertPerson();
		// findPersonById();
		 findAllPersons();
		// countPersons();
		// findByLastName();
		// findByAge();
		// findByFullName();
//		updatePerson();
//		deletePerson();
		
	}

	private static void deletePerson() {
		new PersonDao().delete(3L);
		
	}

	private static void updatePerson() {
		Person p = new PersonDao().findById(3L);

		System.out.println(p.toString());

		p.setFirstName("de Souza");
		new PersonDao().update(p);

		Person p2 = new PersonDao().findById(3L);
		System.out.println(p2.toString());

	}

	private static void findByFullName() {
		Person p = new PersonDao().findByFullName("Gilberto", "Figueira");
		System.out.println(p.toString());

	}

	private static void findByAge() {
		List<Person> persons = new PersonDao().findAgeIsBetween(30, 40);

		for (Person person : persons) {
			System.out.println(person);
		}

	}

	private static void findByLastName() {
		List<Person> persons = new PersonDao().findByLastName("Figueira");

		for (Person person : persons) {
			System.out.println(person);
		}

	}

	private static void countPersons() {
		Long total = new PersonDao().count();
		System.out.println("Total of persons -> " + total);

	}

	private static void findAllPersons() {
		List<Person> persons = new PersonDao().findAll();

		for (Person person : persons) {
			System.out.println(person);
		}

	}

	private static void findPersonById() {
		Person p1 = new PersonDao().findById(2L);
		Person p2 = new PersonDao().findById(3L);

		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}

	private static void insertPerson() {
		Person p1 = new Person();
		p1.setFirstName("Fabiana");
		p1.setLastName("da Silva");
		p1.setAge(29);

		new PersonDao().save(p1);
		System.out.println(p1.toString());

		Person p2 = new Person();
		p2.setFirstName("Gilberto");
		p2.setLastName("Figueira");
		p2.setAge(36);

		new PersonDao().save(p2);
		System.out.println(p2.toString());

		Person p3 = new Person();
		p3.setFirstName("Carlos Andre");
		p3.setLastName("Rodrigues");
		p3.setAge(36);

		new PersonDao().save(p3);
		System.out.println(p3.toString());
	}
}
