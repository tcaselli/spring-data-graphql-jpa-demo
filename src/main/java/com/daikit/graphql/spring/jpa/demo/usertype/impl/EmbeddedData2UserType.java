package com.daikit.graphql.spring.jpa.demo.usertype.impl;

import com.daikit.graphql.spring.jpa.demo.entity.EmbeddedData1;
import com.daikit.graphql.spring.jpa.usertype.AbstractJsonUserType;

/**
 * User type for {@link EmbeddedData1}
 *
 * @author Thibaut Caselli
 */
public class EmbeddedData2UserType extends AbstractJsonUserType<EmbeddedData1> {

	/**
	 * Name of this user type
	 */
	public static final String NAME = "com.daikit.graphql.spring.jpa.demo.usertype.impl.EmbeddedData2UserType";

}
