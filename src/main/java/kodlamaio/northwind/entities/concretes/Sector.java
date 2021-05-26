package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="sector")
public class Sector {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="sector_name")
	private String sector_name;
	@Column(name="sector_avatar")
	private String sector_avatar;
	@Column(name="popularity")
	private int popularity;
	
	public Sector() {
		super();
	}
	public Sector(int id, String sector_name, String sector_avatar) {
		super();
		this.id = id;
		this.sector_name = sector_name;
		this.sector_avatar = sector_avatar;
	}
	public Sector(int id, String sector_name, String sector_avatar,int popularity) {
		super();
		this.id = id;
		this.sector_name = sector_name;
		this.sector_avatar = sector_avatar;
		this.popularity = popularity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSector_name() {
		return sector_name;
	}
	public void setSector_name(String sector_name) {
		this.sector_name = sector_name;
	}
	public String getSector_avatar() {
		return sector_avatar;
	}
	public void setSector_avatar(String sector_avatar) {
		this.sector_avatar = sector_avatar;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
}
