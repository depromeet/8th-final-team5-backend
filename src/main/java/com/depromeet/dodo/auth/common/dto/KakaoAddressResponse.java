package com.depromeet.dodo.auth.common.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class KakaoAddressResponse {

	private Address address;

	@JsonCreator
	public KakaoAddressResponse(@JsonProperty("address") Address address) {
		this.address = address;
	}

	@Getter
	public class Address {
		private String addressName;
		private String region3DepthName;

		@JsonCreator
		public Address(@JsonProperty("address_name") String addressName,
			@JsonProperty("region_3depth_name") String region3DepthName) {
			this.addressName = addressName;
			this.region3DepthName = region3DepthName;
		}
	}

}
