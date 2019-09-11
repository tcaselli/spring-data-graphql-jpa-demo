package com.daikit.graphql.spring.jpa.demo.usertype.impl;

import java.util.List;

import com.daikit.graphql.spring.jpa.demo.entity.EmbeddedData1;
import com.daikit.graphql.spring.jpa.usertype.AbstractJsonListUserType;

/**
 * User type for {@link List} of {@link EmbeddedData1}
 *
 * @author Thibaut Caselli
 */
public class EmbeddedData1ListUserType extends AbstractJsonListUserType<EmbeddedData1> {

	/**
	 * Name of this user type
	 */
	public static final String NAME = "com.daikit.graphql.spring.jpa.demo.usertype.impl.EmbeddedData1ListUserType";

}
