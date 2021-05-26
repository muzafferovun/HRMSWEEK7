package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="sector_positions")
public class SectorPosition {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="sector_id")
	private int sector_id;
	@Column(name="position_name")
	private String position_name;
	@Column(name="position_avatar")
	private String position_avatar;
	@Column(name="position_popularity")
	private int position_popularity;
	public SectorPosition(int id, int sector_id, String position_name, String position_avatar,
			int position_popularity) {
		super();
		this.id = id;
		this.sector_id = sector_id;
		this.position_name = position_name;
		this.position_avatar = position_avatar;
		this.position_popularity = position_popularity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSector_id() {
		return sector_id;
	}
	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getPosition_avatar() {
		return position_avatar;
	}
	public void setPosition_avatar(String position_avatar) {
		this.position_avatar = position_avatar;
	}
	public int getPosition_popularity() {
		return position_popularity;
	}
	public void setPosition_popularity(int position_popularity) {
		this.position_popularity = position_popularity;
	}

}
