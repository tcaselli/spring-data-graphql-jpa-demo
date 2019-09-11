package com.daikit.graphql.spring.jpa.demo.entity;

/**
 * Class intended to be embedded in an entity entity
 *
 * @author Thibaut Caselli
 *
 */
public class EmbeddedData3 {

	private int intAttr;

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
	public void setIntAttr(int intAttr) {
		this.intAttr = intAttr;
	}

}
