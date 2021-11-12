package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Entidad de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author Diego Lopez Strickland
 *
 */

@Entity
@Table(name = "NTTDATA_TH1_CUSTOMER")
public class NTTDataCustomer implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador PK */
	private Long clientNumber;

	/** Nombre del cliente */
	private String clientName;

	/** Primer apellido del cliente */
	private String clientFirstSurname;

	/** Segundo apellido del cliente */
	private String clientSecondSurname;

	/** DNI del cliente */
	private String clientDNI;

	/**
	 * @return the clientNumber
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getClientNumber() {
		return clientNumber;
	}

	/**
	 * @param clientNumber the clientNumber to set
	 */
	public void setClientNumber(Long clientNumber) {
		this.clientNumber = clientNumber;
	}

	/**
	 * @return the clientName
	 */
	@Column(name = "clientName")
	public String getclientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setclientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientFirstSurname
	 */
	@Column(name = "firstSurname")
	public String getclientFirstSurname() {
		return clientFirstSurname;
	}

	/**
	 * @param clientFirstSurname the clientFirstSurname to set
	 */
	public void setclientFirstSurname(String clientFirstSurname) {
		this.clientFirstSurname = clientFirstSurname;
	}

	/**
	 * @return the clientSecondSurname
	 */
	@Column(name = "secondSurname")
	public String getclientSecondSurname() {
		return clientSecondSurname;
	}

	/**
	 * @param clientSecondSurname the clientSecondSurname to set
	 */
	public void setclientSecondSurname(String clientSecondSurname) {
		this.clientSecondSurname = clientSecondSurname;
	}

	/**
	 * @return the clientDNI
	 */
	@Column(name = "customerDni", unique = true, nullable = true, length = 9)
	public String getClientDNI() {
		return clientDNI;
	}

	/**
	 * @param clientDNI the clientDNI to set
	 */
	public void setClientDNI(String clientDNI) {
		this.clientDNI = clientDNI;
	}

}
