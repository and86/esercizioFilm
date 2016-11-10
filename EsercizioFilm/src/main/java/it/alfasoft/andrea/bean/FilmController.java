package it.alfasoft.andrea.bean;



import it.alfasoft.andrea.servizio.Servizio;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="fC", eager=true)
@SessionScoped
public class FilmController implements Serializable {

	/**
	 * 
	 */
	
	Servizio s;
	
	private static final long serialVersionUID = 1L;
	
	private List <Film> listaFilm;
	
	public FilmController(){
		s=new Servizio();	
		
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
	
	public String modificaFilm(long id){
		Film f=s.leggiFilmConId(id);
		ExternalContext externalContext=FacesContext.getCurrentInstance()
										.getExternalContext();
		Map<String,Object> requestMap=externalContext.getRequestMap();
		requestMap.put("film", f);	//metto nell'oggetto request Film f e poi lo leggo con #theFilm
		
		return "ModificaFilm";
		
	}
	
	public String aggiornaFilm(Film f){
		s.aggiornaFilm(f);
		return "TabellaFilm?faces-redirect=true";
	}
	
	public String eliminaFilm(long id){
		Film f=s.leggiFilmConId(id);
		s.eliminaFilm(f);
		return "TabellaFilm?faces-redirect=true";
	}
	
	public String registraFilm(Film f){
		s.registraFilm(f);
		
		return "TabellaFilm?faces-redirect=true";
	}
	
	public void caricaFilm(){
		listaFilm=s.getTuttiFilm();
		
	}
	
	
}
