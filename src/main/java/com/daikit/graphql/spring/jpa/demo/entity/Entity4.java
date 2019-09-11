package com.daikit.graphql.spring.jpa.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity class 4
 *
 * @author Thibaut Caselli
 */
@Entity
@Table(name = "entity4")
public class Entity4 extends AbstractEntity {

	@ManyToMany(mappedBy = "entity4s", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<Entity1> entity1s = new ArrayList<>();

	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	// GETTERS / SETTERS
	// *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

	/**
	 * @return the entity1s
	 */
	public List<Entity1> getEntity1s() {
		return entity1s;
	}

	/**
	 * @param entity1s
	 *            the entity1s to set
	 */
	public void setEntity1s(List<Entity1> entity1s) {
		this.entity1s = entity1s;
	}
}
