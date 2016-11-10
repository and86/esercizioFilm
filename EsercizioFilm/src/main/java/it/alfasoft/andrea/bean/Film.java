package it.alfasoft.andrea.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@ManagedBean(name = "film", eager = true)
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_film;
	private String nomeFilm;
	private int data;
	private String nomeRegista;
	private String codiceFilm;
	private String genere;
	@Transient
	private List<String> generi;

	public Film() {
		generi = new ArrayList<String>();
		generi.add("");
		generi.add("Thriller");
		generi.add("Horror");
		generi.add("Azione");
		generi.add("Giallo");

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

	public List<String> getGeneri() {
		return generi;
	}

	public void setGeneri(List<String> generi) {
		this.generi = generi;
	}

	public void validazioneCodiceFilm(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		if (value == null) {
			return;
		}
		String dato = value.toString();
		if (!dato.startsWith("Mov")) {
			FacesMessage msg = new FacesMessage(
					"Codice Film  errato: deve iniziare con Mov!");
			throw new ValidatorException(msg);
		}

	}

}
