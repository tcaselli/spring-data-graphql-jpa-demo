package com.daikit.graphql.spring.jpa.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Entity class 2
 *
 * @author Thibaut Caselli
 */
@Entity
@Table(name = "entity2")
public class Entity2 extends AbstractEntity {

	@OneToMany(mappedBy = "entity2", fetch = FetchType.LAZY)
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
	public void setEntity1s(final List<Entity1> entity1s) {
		this.entity1s = entity1s;
	}

}
