package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity

	@Table(name="person_activation_codes")
	public class PersonActivationCodes {
		@Id 
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="id")
		private int id;
		@Column(name="person_id")
		private int person_id;
		@Column(name="activation_code")
		private String activation_code;
		public PersonActivationCodes() {
			super();
		}
		public PersonActivationCodes(int id, int person_id, String activation_code) {
			super();
			this.id = id;
			this.person_id = person_id;
			this.activation_code = activation_code;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPerson_id() {
			return person_id;
		}
		public void setPerson_id(int person_id) {
			this.person_id = person_id;
		}
		public String getActivation_code() {
			return activation_code;
		}
		public void setActivation_code(String activation_code) {
			this.activation_code = activation_code;
		}
				
}
