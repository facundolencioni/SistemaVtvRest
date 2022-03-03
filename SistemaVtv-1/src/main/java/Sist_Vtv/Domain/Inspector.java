package Sist_Vtv.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Entity
@Table(name= "inspector")
public class Inspector extends Persona implements Serializable{

    
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInspector;
	@NotEmpty
	private String nombreInspector;
	@NotEmpty
	private String telefono;
	@Email
	private String email;  
        @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL)
        private List<Vtv> vtvs;
        
        public Long getIdInspector() {
			return idInspector;
		}
		public void setIdInspector(Long idInspector) {
			this.idInspector = idInspector;
		}
		public String getNombreInspector() {
			return nombreInspector;
		}
		public void setNombreInspector(String nombreInspector) {
			this.nombreInspector = nombreInspector;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public List<Vtv> getVtvs() {
			return vtvs;
		}
		public void setVtvs(List<Vtv> vtvs) {
			this.vtvs = vtvs;
		}
		public Inspector(Long idInspector, String nombreInspector, String telefono, String email, List<Vtv> vtvs) {
			super();
			this.idInspector = idInspector;
			this.nombreInspector = nombreInspector;
			this.telefono = telefono;
			this.email = email;
			this.vtvs = vtvs;
		}
		public Inspector() {
			super();
		}

        
}
