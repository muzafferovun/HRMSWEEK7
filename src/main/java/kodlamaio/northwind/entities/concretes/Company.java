package kodlamaio.northwind.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="company")
public class Company {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="user_id")
	private int user_id;
	@Column(name="company_name")
	private String company_name;
	@Column(name="website")
	private String website;
	@Column(name="company_email")
	private String company_email;
	@Column(name="is_verify")
	private boolean is_verify;
	@Column(name="verification_code")
	private String verification_code;
	@Column(name="company_logo")
	private String company_logo;
	@Column(name="company_city")
	private int company_city;
	@Column(name="phone")
	private String phone;
	@Column(name="is_activate")
	private boolean is_activate;
	public Company() {
		super();
	}
	public Company(int id, int user_id, String company_name, String website, String company_email, boolean is_verify,
			String verification_code, String company_logo, int company_city, String phone, boolean is_activate) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.company_name = company_name;
		this.website = website;
		this.company_email = company_email;
		this.is_verify = is_verify;
		this.verification_code = verification_code;
		this.company_logo = company_logo;
		this.company_city = company_city;
		this.phone = phone;
		this.is_activate = is_activate;
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
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
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
	public String getCompany_logo() {
		return company_logo;
	}
	public void setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
	}
	public int getCompany_city() {
		return company_city;
	}
	public void setCompany_city(int company_city) {
		this.company_city = company_city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isIs_activate() {
		return is_activate;
	}
	public void setIs_activate(boolean is_activate) {
		this.is_activate = is_activate;
	}
}