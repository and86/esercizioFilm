package it.alfasoft.andrea.dao;

import java.util.List;

import it.alfasoft.andrea.bean.Film;
import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilmDao {

	public boolean creaFilm(Film f) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.persist(f);

			res = true;
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;
	}

	// 2a Read con Id
	public Film leggiFilmConId(long id_f) {
		Film f = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			f = session.get(Film.class, id_f);

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return f;

	}

	// 2b Read con username
	public Film leggiFilmConNome(String nomeFilm) {
		Film f = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Film where nomeFilm=:nomeInserito");
			query.setString("nomeInserito", nomeFilm);
			f = (Film) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return f;

	}
	
	public List<Film> leggiTuttiFilm() {
		List<Film> lista=null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Film ");

		lista= query.list();

			tx.commit();

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return lista;

	}
	

	// 3 Update
	public boolean aggiornaFilm(Film f) {

		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.update(f);

			tx.commit();
			res = true;

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;

	}

	// 4 Delete
	public boolean eliminaFilm(Film f) {

		boolean res = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();

			session.delete(f);

			tx.commit();
			res = true;

		} catch (Exception ex) {
			tx.rollback();
		} finally {
			session.close();
		}

		return res;

	}

}
