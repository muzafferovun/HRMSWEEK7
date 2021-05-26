package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="company_activation_codes")
public class CompanyActivationCodes {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="company_id")
	private int company_id;
	@Column(name="activation_code")
	private String activation_code;
	public CompanyActivationCodes() {
		super();
	}
	public CompanyActivationCodes(int id, int company_id, String activation_code) {
		super();
		this.id = id;
		this.company_id = company_id;
		this.activation_code = activation_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public String getActivation_code() {
		return activation_code;
	}
	public void setActivation_code(String activation_code) {
		this.activation_code = activation_code;
	}

			
}
