package org.sample.quarkus;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

public class Response {

	private final int statusCode;
	private final String body;
	private final Map<String, String> headers;

	public Response(int statusCode, String body, Map<String, String> headers) {
		this.statusCode = statusCode;
		this.body = body;
		this.headers = headers;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getBody() {
		return body;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private int statusCode = 200;
		private Map<String, String> headers = Collections.emptyMap();
		private String rawBody;
		private byte[] binaryBody;

		public Builder setStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public Builder setHeaders(Map<String, String> headers) {
			this.headers = headers;
			return this;
		}

		public Builder setRawBody(String rawBody) {
			this.rawBody = rawBody;
			return this;
		}

		public Builder setBinaryBody(byte[] binaryBody) {
			this.binaryBody = binaryBody;
			return this;
		}

		public Response build() {
			String body = null;
			if (rawBody != null) {
				body = rawBody;
			} else if (binaryBody != null) {
				body = new String(Base64.getEncoder().encode(binaryBody), StandardCharsets.UTF_8);
			}
			return new Response(statusCode, body, headers);
		}
	}
}
