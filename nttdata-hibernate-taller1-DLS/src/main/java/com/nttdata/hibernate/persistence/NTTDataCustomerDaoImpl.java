package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 *
 */

public class NTTDataCustomerDaoImpl<T> implements NTTDataCustomerDaoI<T> {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Metodo constructor
	 * 
	 * @param session
	 */
	public NTTDataCustomerDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {
		// Verificaion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserccion
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void update(T paramT) {

		// Verificaion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualizacion
		session.saveOrUpdate(paramT);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public void delete(T paramT) {

		// Verificaion de sesion abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Borrado
		session.delete(paramT);

		// Commit
		session.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchById(Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		T result = (T) session.get(NTTDataCustomer.class, id);

		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + NTTDataCustomer.class.getName()).list();

		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchByNameAndSurnames(String name, String firstSurname, String secondSurname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza clientes en función del nombre y apellidos.
		final List<T> customerList = session.createQuery("FROM " + NTTDataCustomer.class.getName() + " WHERE "
				+ "clientName LIKE " + "'" + name + "'" + " AND firstSurname LIKE " + "'" + firstSurname + "'"
				+ " AND secondSurname LIKE " + "'" + secondSurname + "'").list();

		return customerList;

	}

}
