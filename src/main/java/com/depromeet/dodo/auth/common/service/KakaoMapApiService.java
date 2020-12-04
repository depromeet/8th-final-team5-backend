package com.depromeet.dodo.auth.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.depromeet.dodo.auth.common.dto.KakaoAddressResponse;
import com.depromeet.dodo.auth.common.dto.KakaoErrorResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vividsolutions.jts.geom.Point;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KakaoMapApiService {

	@Value("${kakao.api.map.secret.key}")
	private final String kakaoMapAuthValue;
	private static final String KAKAO_MAP_AUTH_KEY = "Authorization";
	private static final String KAKAO_MAP_URL = "https://dapi.kakao.com/v2/local/geo/coord2address.json";

	private final WebClient apiWebClient;

	public KakaoMapResponse getAddress(Point point) {
		return apiWebClient.get()
			.uri(addQuerystring(KAKAO_MAP_URL, point))
			.header(KAKAO_MAP_AUTH_KEY, kakaoMapAuthValue)
			.retrieve()
			.onStatus(status -> status.is4xxClientError(),
				response -> response.bodyToMono(KakaoErrorResponse.class)
					.map(body -> new IllegalArgumentException(body.getMsg())))
			.bodyToMono(KakaoMapResponse.class)
			.block();
	}

	private String addQuerystring(String url, Point point) {
		return url + "?x=" + point.getX() + "&y=" + point.getY() + "&input_coord=WTM";
	}

	@Getter
	public static class KakaoMapResponse {
		private List<KakaoAddressResponse> kakaoAddressResponse;

		@JsonCreator
		public KakaoMapResponse(@JsonProperty("documents") List<KakaoAddressResponse> kakaoAddressResponse) {
			this.kakaoAddressResponse = kakaoAddressResponse;
		}

	}

}
