package com.msouza.revjpa.dao;

import java.util.List;

import com.msouza.revjpa.entity.Person;

public class PersonDao extends GenericDao<Person> {

	public PersonDao() {
		super(Person.class);
	}

	public List<Person> findByLastName(String lastName) {
		String jpql = "from Person p where p.lastName like ?";
		return find(jpql, lastName);
	}

	public List<Person> findAgeIsBetween(int min, int max) {
		String jpql = "from Person p where p.age between ? and ?";
		return find(jpql, min, max);
	}

	public Person findByFullName(String firstName, String lastName) {
		String jpql = "from Person p where p.firstName like ? and p.lastName like ?";
		return findOne(jpql, firstName, lastName);
	}

	public Person findByCpf(String cpf) {
		String jpql = "select p from Person p, Document d where d.cpf like ? and p.document.id = d.id";

		return findOne(jpql, cpf);
	}

}
