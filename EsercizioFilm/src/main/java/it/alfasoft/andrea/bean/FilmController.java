package it.alfasoft.andrea.bean;


import it.alfasoft.andrea.dao.FilmDao;
import it.alfasoft.andrea.servizio.Servizio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="fC", eager=true)
public class FilmController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List <Film> listaFilm;
	
	public FilmController(){
		Servizio s=new Servizio();	
		listaFilm=s.getTuttiFilm();
	}

	public List<Film> getListaFilm() {
		return listaFilm;
	}

	public void setListaFilm(List<Film> listaFilm) {
		this.listaFilm = listaFilm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
