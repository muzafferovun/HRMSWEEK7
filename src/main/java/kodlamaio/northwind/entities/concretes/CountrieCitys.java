package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="countrie_citys")
public class CountrieCitys {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="countrie_id")
	private int countrie_id;
	@Column(name="city_name")
	private String city_name;
	public CountrieCitys(int id, int countrie_id, String city_name) {
		super();
		this.id = id;
		this.countrie_id = countrie_id;
		this.city_name = city_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCountrie_id() {
		return countrie_id;
	}
	public void setCountrie_id(int countrie_id) {
		this.countrie_id = countrie_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	
}