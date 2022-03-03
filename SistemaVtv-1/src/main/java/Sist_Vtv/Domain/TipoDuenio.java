package Sist_Vtv.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name= "tipoduenio")
public class TipoDuenio implements Serializable {

  
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoDuenio;
	private String nombreTipoDuenio;
	
	@OneToMany (mappedBy = "tipoDuenio")
	private List<Duenio> duenio;
	@OneToMany(mappedBy = "tipoDuenio")
	private List<Duenio> duenios;
	@JsonIgnore
	public List<Duenio> getDuenios() {
		return duenios;
	}

	public void setDuenios(Duenio duenios) {
		this.duenios.add(duenios);
	}

	public Long getIdTipoDuenio() {
		return idTipoDuenio;
	}

	public void setIdTipoDuenio(Long idTipoDuenio) {
		this.idTipoDuenio = idTipoDuenio;
	}

	public String getNombreTipoDuenio() {
		return nombreTipoDuenio;
	}

	public void setNombreTipoDuenio(String nombreTipoDuenio) {
		this.nombreTipoDuenio = nombreTipoDuenio;
	}

	public TipoDuenio(List<Duenio> duenios, Long idTipoDuenio, String nombreTipoDuenio, List<Duenio> duenio) {
		super();
		this.duenios = duenios;
		this.idTipoDuenio = idTipoDuenio;
		this.nombreTipoDuenio = nombreTipoDuenio;
		this.duenio = duenio;
	}

	public TipoDuenio() {
		super();
	}
	
	
}









