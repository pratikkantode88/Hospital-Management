package com.Hospital.Management.System.DocLogin.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String age;
	private String symtomps;
	@Column(name = "mob_number")
	private String number;
	
	public Appointment() {
         super();
	}

	public Appointment(long id, String firstName, String lastName, String age, String symtomps, String number) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.symtomps = symtomps;
		this.number = number;
	}

	public Appointment(String firstName, String lastName, String age, String symtomps, String number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.symtomps = symtomps;
		this.number = number;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSymtomps() {
		return symtomps;
	}

	public void setSymtomps(String symtomps) {
		this.symtomps = symtomps;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", symtomps=" + symtomps + ", number=" + number + "]";
	}
	
	
}
