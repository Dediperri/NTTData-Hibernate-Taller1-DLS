package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * DAO de la tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 */
public interface NTTDataCustomerDaoI<T> {

	/**
	 * Inserta un registro en la BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en la BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramt);

	/**
	 * Elimina un registro en la BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramt);

	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param paramT
	 */
	public T searchById(final Long id);

	/**
	 * Busqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

	/**
	 * Localiza los registros dependiendo del nombre y apellidos en BBDD
	 * 
	 * @return List<T>
	 */
	public List<T> searchByNameAndSurnames(final String name, final String firstSurname, final String secondSurname);
}
