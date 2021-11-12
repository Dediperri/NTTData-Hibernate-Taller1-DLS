package com.nttdata.hibernate;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.hibernate.services.NTTDataCustomerManagementServiceImpl;

/**
 * Clase main del proyecto
 *
 * @author Diego Lopez Strickland
 */
public class NTTDataHibernateMainT1 {

	/**
	 * Metodo main de mi clase NTTDataHibernateMainT1
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NTTDataCustomerManagementServiceImpl customerService = new NTTDataCustomerManagementServiceImpl(session);

		// Generación de clientes.
		final NTTDataCustomer cliente1 = new NTTDataCustomer();
		cliente1.setclientName("Diego");
		cliente1.setclientFirstSurname("Lopez");
		cliente1.setclientSecondSurname("Strickland");
		cliente1.setClientDNI("77943441Y");

		final NTTDataCustomer cliente2 = new NTTDataCustomer();
		cliente2.setclientName("Fatima");
		cliente2.setclientFirstSurname("Prieto");
		cliente2.setclientSecondSurname("Alvear");
		cliente2.setClientDNI("36943321Y");

		final NTTDataCustomer cliente3 = new NTTDataCustomer();
		cliente3.setclientName("Juan Luis");
		cliente3.setclientFirstSurname("Almeida");
		cliente3.setclientSecondSurname("Munoz");
		cliente3.setClientDNI("48574839I");

		// Insertar los clientes
		customerService.insertNewCustomer(cliente1);
		customerService.insertNewCustomer(cliente2);
		customerService.insertNewCustomer(cliente3);

		// Hago un update de el cliente 2 y 3
		cliente2.setclientName("Maria");
		cliente2.setClientDNI("36943781Y");
		cliente3.setclientName("Angel Luis");

		customerService.updateCustomer(cliente2);
		customerService.updateCustomer(cliente3);

		// Por ultimo borro el cliente 2
		customerService.deleteCustomer(cliente2);

		// Imprimo por consola el dni del cliente 3
		System.out.println(
				customerService.searchByNameAndSurnames("Angel Luis", "Almeida", "Munoz").get(0).getClientDNI());
		
		// Cierre de sesión.
		session.close();

	}
}
