package com.msouza.revjpa;

import java.util.Arrays;
import java.util.List;

import com.msouza.revjpa.dao.AddressDao;
import com.msouza.revjpa.dao.DocumentDao;
import com.msouza.revjpa.dao.PersonDao;
import com.msouza.revjpa.dao.PhoneDao;
import com.msouza.revjpa.entity.Address;
import com.msouza.revjpa.entity.Document;
import com.msouza.revjpa.entity.Person;
import com.msouza.revjpa.entity.Phone;
import com.msouza.revjpa.entity.Address.TypeAddres;
import com.msouza.revjpa.entity.Phone.TypePhone;

public class AppRevJpa {

	public static void main(String[] args) {
		System.out.println("Hello Word");
		// insertPerson();
		// findPersonById();
		// findAllPersons();
		// countPersons();
		// findByLastName();
		// findByAge();
		// findByFullName();
		// updatePerson();
		// deletePerson();

		// insertDocument();
		// updateDocument();
		// findPersonByCpf();
		// insertPhone();
		// insertPhoneByPerson();
		// updatePhone();
		// updatePhoneByPerson();
		// deleteOnCascade();

//		insertAddressByPerson();
//		insertPersonByAddress();
		findByCity();
		

	}

	private static void findByCity() {
		List<Address> addresses = new AddressDao().findByCity("Porto Alegre");
		
		for (Address address : addresses) {
			System.out.println(address.toString());
		}
		
	}

	private static void insertPersonByAddress() {
		Person person = new PersonDao().findById(5L);
		
		Address ad1 = new  Address();
		ad1.setCity("Porto Alegre");
		ad1.setStreet("Av Beira rio, 102");
		ad1.setType(TypeAddres.RESIDENCIAL);
		ad1.setPersons(Arrays.asList(person));
		
		AddressDao dao = new AddressDao();
		dao.save(ad1);
		System.out.println(dao.findById(ad1.getId()));
		
	}

	private static void insertAddressByPerson() {
		Address ad1 = new Address();

		ad1.setCity("Porto Alegre");
		ad1.setStreet("Av Beira rio, 102");
		ad1.setType(TypeAddres.RESIDENCIAL);

		Address ad2 = new Address();
		ad2.setCity("Porto Alegre");
		ad2.setStreet("Av Floresta, 36");
		ad2.setType(TypeAddres.COMERCIAL);
		
		Person person = new Person();
		person.setFirstName("Isabel");
		person.setLastName("Martins");
		person.setAge(23);
		person.setDocument(new Document("973.283.456-09", 193456534));
		person.addPhone(new Phone(TypePhone.RESIDENCIAL, "4456730"));
		person.addPhone(new Phone(TypePhone.COMERCIAL, "4554430"));
		person.setAddresses(Arrays.asList(ad1,ad2));
		
		new PersonDao().save(person);
		
		System.out.println(new PersonDao().findById(person.getId()));

	}

	private static void deleteOnCascade() {
		// new PersonDao().delete(7L);
		// new PhoneDao().delete(1L);

		PhoneDao dao = new PhoneDao();
		Phone phone = dao.findById(6L);

		System.out.println(phone.toString());

		phone.getPerson().removePhone(phone);

		dao.delete(phone);
	}

	private static void updatePhoneByPerson() {
		Person person = new PersonDao().findById(7L);

		for (Phone phone : person.getPhones()) {
			System.out.println("1- " + phone.toString());

			if (TypePhone.COMERCIAL == phone.getType()) {
				phone.setType(TypePhone.RESIDENCIAL);
			}
		}

		new PersonDao().update(person);

		for (Phone phone : person.getPhones()) {
			System.out.println("2- " + phone.toString());
		}
	}

	private static void updatePhone() {
		Person person = new PersonDao().findById(7L);

		PhoneDao dao = new PhoneDao();

		Phone phone = dao.findById(3L);
		phone.setPerson(person);

		dao.update(phone);

		phone = dao.findById(phone.getId());
		System.out.println(phone.toString());

	}

	private static void insertPhoneByPerson() {
		Phone ph1 = new Phone(TypePhone.CELULAR, "90094765");
		Phone ph2 = new Phone(TypePhone.COMERCIAL, "34540985");

		Person p = new Person();
		p.setFirstName("Juliano");
		p.setLastName("Figueira");
		p.setAge(20);
		p.setDocument(new Document("135.956.364-99", 137076439));

		// ph1.setPerson(p);
		// ph2.setPerson(p);
		// p.setPhones(Arrays.asList(ph1, ph2));

		p.addPhone(ph1);
		p.addPhone(ph2);
		new PersonDao().save(p);
	}

	private static void insertPhone() {
		Person p = new Person();
		p.setFirstName("Gilson");
		p.setLastName("Figueira");
		p.setAge(28);
		p.setDocument(new Document("145.256.364-96", 129036439));

		Phone phone = new Phone(TypePhone.CELULAR, "12349765");
		phone.setPerson(p);

		PhoneDao dao = new PhoneDao();

		dao.save(phone);
		phone = dao.findById(phone.getId());

		System.out.println(phone.toString());
	}

	private static void findPersonByCpf() {
		Person p = new PersonDao().findByCpf("123.456.789-99");
		System.out.println(p.toString());

	}

	private static void updateDocument() {
		Document doc = new DocumentDao().findById(1L);
		System.out.println(doc.toString());

		doc.setCpf("123.456.789-99");
		new DocumentDao().update(doc);

		System.out.println(new DocumentDao().findById(1L));

	}

	private static void insertDocument() {
		Person p1 = new Person();
		p1.setFirstName("Aline");
		p1.setLastName("de Souza");
		p1.setAge(24);
		p1.setDocument(new Document("123+456+789-99", 123456789));

		new PersonDao().save(p1);
		System.out.println(p1.toString());
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
