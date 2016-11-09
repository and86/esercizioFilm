import it.alfasoft.andrea.bean.Film;
import it.alfasoft.andrea.servizio.Servizio;


public class mainFilm {

	public static void main(String[] args) {
		Servizio s=new Servizio();
		
		Film f1=new Film("aaa",2015,"aaa","aaa","aaa");
		Film f2=new Film("bbb",2016,"bbb","bbb","bbb");
		Film f3=new Film("ccc",2013,"ccc","ccc","ccc");
		
		s.registraFilm(f1);
		s.registraFilm(f2);
		s.registraFilm(f3);
		

	}

}
