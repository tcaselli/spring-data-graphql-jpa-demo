package com.daikit.graphql.spring.jpa.demo.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity class 3
 *
 * @author Thibaut Caselli
 */
@Entity
@Table(name = "entity3")
public class Entity3 extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "entity1Id", nullable = false)
	@Fetch(FetchMode.SELECT)
	private Entity1 entity1;

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	// GETTERS / SETTERS
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

	/**
	 * @return the entity1
	 */
	public Entity1 getEntity1() {
		return entity1;
	}

	/**
	 * @param entity1
	 *            the entity1 to set
	 */
	public void setEntity1(Entity1 entity1) {
		this.entity1 = entity1;
	}
}
