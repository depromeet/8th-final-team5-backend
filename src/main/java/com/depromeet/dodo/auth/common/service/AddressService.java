package com.depromeet.dodo.auth.common.service;

import org.springframework.stereotype.Service;

import com.depromeet.dodo.location.domain.Location;
import com.depromeet.dodo.location.service.LocationService;
import com.depromeet.dodo.location.thirdparty.KakaoMapApiService;
import com.vividsolutions.jts.geom.Point;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

	private final LocationService locationService;

	public Location addLocation(Point point, KakaoMapApiService.KakaoMapResponse response) {
		Location location = null;

		if (!response.getKakaoAddressResponse().isEmpty()) {
			location = Location.builder()
				.point(point)
				.addressName(response.getKakaoAddressResponse().get(0).getAddress().getRegion3DepthName())
				.region3DepthName(response.getKakaoAddressResponse().get(0).getAddress().getRegion3DepthName()).build();
			locationService.addLocation(location);
		}

		return location;
	}

}
