package com.daikit.graphql.spring.jpa.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity class 5
 *
 * @author Thibaut Caselli
 */
@Entity
@Table(name = "entity6")
public class Entity6 extends AbstractEntity {

	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;

	/**
	 * @return the attr1
	 */
	public String getAttr1() {
		return attr1;
	}
	/**
	 * @param attr1
	 *            the attr1 to set
	 */
	public void setAttr1(final String attr1) {
		this.attr1 = attr1;
	}
	/**
	 * @return the attr2
	 */
	public String getAttr2() {
		return attr2;
	}
	/**
	 * @param attr2
	 *            the attr2 to set
	 */
	public void setAttr2(final String attr2) {
		this.attr2 = attr2;
	}
	/**
	 * @return the attr3
	 */
	public String getAttr3() {
		return attr3;
	}
	/**
	 * @param attr3
	 *            the attr3 to set
	 */
	public void setAttr3(final String attr3) {
		this.attr3 = attr3;
	}
	/**
	 * @return the attr4
	 */
	public String getAttr4() {
		return attr4;
	}
	/**
	 * @param attr4
	 *            the attr4 to set
	 */
	public void setAttr4(final String attr4) {
		this.attr4 = attr4;
	}
}
