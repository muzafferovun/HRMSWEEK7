package kodlamaio.northwind.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="sector_position_professions")
public class SectorPositionProfession {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="sector_position_id")
	private int sector_position_id;
	@Column(name="profession_name")
	private String profession_name;
	@Column(name="profession_description")
	private String profession_description;
	@Column(name="profession_avatar")
	private int profession_avatar;
	public SectorPositionProfession(int id, int sector_position_id, String profession_name,
			String profession_description, int profession_avatar) {
		super();
		this.id = id;
		this.sector_position_id = sector_position_id;
		this.profession_name = profession_name;
		this.profession_description = profession_description;
		this.profession_avatar = profession_avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSector_position_id() {
		return sector_position_id;
	}
	public void setSector_position_id(int sector_position_id) {
		this.sector_position_id = sector_position_id;
	}
	public String getProfession_name() {
		return profession_name;
	}
	public void setProfession_name(String profession_name) {
		this.profession_name = profession_name;
	}
	public String getProfession_description() {
		return profession_description;
	}
	public void setProfession_description(String profession_description) {
		this.profession_description = profession_description;
	}
	public int getProfession_avatar() {
		return profession_avatar;
	}
	public void setProfession_avatar(int profession_avatar) {
		this.profession_avatar = profession_avatar;
	}
}
