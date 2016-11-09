package it.alfasoft.andrea.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean(name="f", eager=true)
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_film;
	private String nomeFilm;
	int data;
	private String nomeRegista;
	private String codiceFilm;
	private String genere;
	
	public Film(){
	}
	
	public Film(String nomeFilm, int data, String nomeRegista,
			String codiceFilm, String genere) {
		this.nomeFilm = nomeFilm;
		this.data = data;
		this.nomeRegista = nomeRegista;
		this.codiceFilm = codiceFilm;
		this.genere = genere;
	}

	public long getId_film() {
		return id_film;
	}

	public void setId_film(long id_film) {
		this.id_film = id_film;
	}

	public String getNomeFilm() {
		return nomeFilm;
	}

	public void setNomeFilm(String nomeFilm) {
		this.nomeFilm = nomeFilm;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getNomeRegista() {
		return nomeRegista;
	}

	public void setNomeRegista(String nomeRegista) {
		this.nomeRegista = nomeRegista;
	}

	public String getCodiceFilm() {
		return codiceFilm;
	}

	public void setCodiceFilm(String codiceFilm) {
		this.codiceFilm = codiceFilm;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
