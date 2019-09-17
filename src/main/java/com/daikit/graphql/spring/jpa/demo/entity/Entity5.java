package com.daikit.graphql.spring.jpa.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class 5
 *
 * @author Thibaut Caselli
 */
@Entity
@Table(name = "entity5")
public class Entity5 extends AbstractEntity {

	private int intAttr;
	private String stringAttr;

	/**
	 * @return the intAttr
	 */
	public int getIntAttr() {
		return intAttr;
	}
	/**
	 * @param intAttr
	 *            the intAttr to set
	 */
	public void setIntAttr(final int intAttr) {
		this.intAttr = intAttr;
	}
	/**
	 * @return the stringAttr
	 */
	public String getStringAttr() {
		return stringAttr;
	}
	/**
	 * @param stringAttr
	 *            the stringAttr to set
	 */
	public void setStringAttr(final String stringAttr) {
		this.stringAttr = stringAttr;
	}

}
