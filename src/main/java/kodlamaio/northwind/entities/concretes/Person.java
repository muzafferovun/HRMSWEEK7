package kodlamaio.northwind.entities.concretes;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity

@Table(name="person")
public class Person {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int user_id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="national_identity")
	private String national_identity;
	@Column(name="date_of_birth")
	private String date_of_birth;
	@Column(name="is_verify")
	private boolean is_verify;
	@Column(name="verification_code")
	private String verification_code;

	@Column(name="phone")
	private String phone;
	
	public Person() {
		super();
	}
	public Person(int id, int user_id, String name, String surname, String national_identity, String date_of_birth,
			boolean is_verify, String verification_code, String phone) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.surname = surname;
		this.national_identity = national_identity;
		this.date_of_birth = date_of_birth;
		this.is_verify = is_verify;
		this.verification_code = verification_code;
		this.phone = phone;
	
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNational_identity() {
		return national_identity;
	}
	public void setNational_identity(String national_identity) {
		this.national_identity = national_identity;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public boolean isIs_verify() {
		return is_verify;
	}
	public void setIs_verify(boolean is_verify) {
		this.is_verify = is_verify;
	}
	public String getVerification_code() {
		return verification_code;
	}
	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	
	
}