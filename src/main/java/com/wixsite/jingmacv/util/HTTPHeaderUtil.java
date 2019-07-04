package com.wixsite.jingmacv.util;

import org.springframework.http.HttpHeaders;

/*
 * Utility functions for HTTP headers.
 */
public class HTTPHeaderUtil {

	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Host", "localhost:8080");
		headers.add("Content-Language", "en-US");	
		return headers;
	}
}
