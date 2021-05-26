package kodlamaio.northwind.entities.concretes;

public class PersonUser {
	private User user;
	private Person person;
	public PersonUser(User user, Person person) {
		super();
		this.user = user;
		this.person = person;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public void setPersonid(int id) {
		this.person.setId(id);
	}
	
}
