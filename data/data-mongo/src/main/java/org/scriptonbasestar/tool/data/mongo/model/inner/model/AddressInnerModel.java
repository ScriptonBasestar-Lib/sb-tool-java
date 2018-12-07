package org.scriptonbasestar.tool.data.mongo.model.inner.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.PersistenceConstructor;

import java.io.Serializable;

/**
 * @author archmagece
 * @since 2015-06-02-11
 */
//@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class AddressInnerModel
	implements Serializable {
	@PersistenceConstructor
	public AddressInnerModel(String country, String state, String city, String detail, String formattedAddress) {
		this(country, state, city, detail, formattedAddress, null);
	}

	public AddressInnerModel(String country, String state, String city, String detail, String formattedAddress, String zipCode) {
		//TODO not null
		this.country = country;
		this.state = state;
		//TODO not null
		this.city = city;
		this.detail = detail;
		//TODO not null
		this.formattedAddress = formattedAddress;
		this.zipCode = zipCode;
	}

	private String country;
	private String state;
	private String city;
	private String detail;
	private String formattedAddress;

	private String zipCode;
}
