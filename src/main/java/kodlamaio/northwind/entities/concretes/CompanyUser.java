package kodlamaio.northwind.entities.concretes;

public class CompanyUser {
	private String email;
	private String password;
	private String repassword;
	private String company_name;
	private String website;
	private String company_email;
	private String phone;
	private String company_city;
	public CompanyUser() {
		super();
	}
	public CompanyUser(String email, String password, String repassword, String company_name, String website,
			String company_email, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.repassword = repassword;
		this.company_name = company_name;
		this.website = website;
		this.company_email = company_email;
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany_city() {
		return company_city;
	}
	public void setCompany_city(String company_city) {
		this.company_city = company_city;
	}
	
}
