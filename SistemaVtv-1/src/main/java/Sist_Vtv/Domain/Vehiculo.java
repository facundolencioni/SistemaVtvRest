package Sist_Vtv.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;


import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name= "vehiculo")
public class Vehiculo implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@Pattern(regexp = "[A-Z]{3}[\\d]{3}|[A-Z]{2}[\\d]{3}[A-Z]{2}", message = "la patente no tiene el formato valido")
	private String Dominio;
	@NotEmpty
	private String Marca;
	@NotEmpty
	private String Modelo;
	
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	private Duenio duenio;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
        private List<Vtv> vtv;

	public String getDominio() {
		return Dominio;
	}
	public void setDominio(String dominio) {
		Dominio = dominio;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModelo() {
		return Modelo;
	}
	public void setModelo(String modelo) {
		Modelo = modelo;
	}
	@JsonIgnore
	public Duenio getDuenio() {
		return duenio;
	}
	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}

	public List<Vtv> getVtv() {
		return vtv;
	}
	public void setVtv(Vtv vtv) {
		this.vtv.add(vtv);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Vehiculo(String dominio, String marca, String modelo, Duenio duenio, List<Vtv> vtv) {
		super();
		
		this.Dominio = dominio;
		this.Marca = marca;
		this.Modelo = modelo;
		this.duenio = duenio;
		this.vtv = vtv;
	}
	public Vehiculo() {
		super();
	}

	
}
