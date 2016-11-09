package it.alfasoft.andrea.servizio;

import java.util.List;

import it.alfasoft.andrea.bean.Film;
import it.alfasoft.andrea.bean.FilmController;
import it.alfasoft.andrea.dao.FilmDao;


public class Servizio {
	
	FilmDao fDao=new FilmDao();

	
	public boolean registraFilm(Film f){
		return fDao.creaFilm(f);
	}
	
	public Film leggiFilmConId(long id){
		return fDao.leggiFilmConId(id);
	}
	
	public Film leggiFilmConNome(String nome){
		return fDao.leggiFilmConNome(nome);
	}
	
	public boolean aggiornaFilm(Film f){
		return fDao.aggiornaFilm(f);
	}
	
	public boolean eliminaFilm(Film f){
		return fDao.eliminaFilm(f);
	}
	
	public List<Film> getTuttiFilm(){
		
		return fDao.leggiTuttiFilm();
	}

}
