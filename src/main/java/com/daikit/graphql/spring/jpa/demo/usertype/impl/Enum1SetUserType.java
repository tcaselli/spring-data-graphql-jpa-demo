package com.daikit.graphql.spring.jpa.demo.usertype.impl;

import java.util.List;

import com.daikit.graphql.spring.jpa.demo.entity.EmbeddedData1;
import com.daikit.graphql.spring.jpa.demo.entity.Enum1;
import com.daikit.graphql.spring.jpa.usertype.AbstractJsonSetUserType;

/**
 * User type for {@link List} of {@link EmbeddedData1}
 *
 * @author Thibaut Caselli
 */
public class Enum1SetUserType extends AbstractJsonSetUserType<Enum1> {

	/**
	 * Name of this user type
	 */
	public static final String NAME = "com.daikit.graphql.spring.jpa.demo.usertype.impl.Enum1SetUserType";

}
