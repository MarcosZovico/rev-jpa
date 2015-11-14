package com.msouza.revjpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHONES")
public class Phone implements Serializable {

	private static final long serialVersionUID = 6865671129050719726L;

	public enum TypePhone {
		RESIDENCIAL, CELULAR, COMERCIAL;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PHONE")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_PHONE", nullable = false)
	private TypePhone type;

	@Column(name = "NUMBER", nullable = false)
	private String number;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public Phone() {
		super();
	}

	public Phone(TypePhone type, String number) {
		this.type = type;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypePhone getType() {
		return type;
	}

	public void setType(TypePhone type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", type=" + type + ", number=" + number + ", person=" + person + "]";
	}

}
