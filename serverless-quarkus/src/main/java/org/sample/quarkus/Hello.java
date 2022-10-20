package org.sample.quarkus;

import java.util.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

@Named("hello")
public class Hello implements RequestHandler<Map<String, Object>, Response> {
	@Inject
	Validator validator;

	@Override
	public Response handleRequest(Map<String, Object> input, Context context) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");

		Data data = new Data();
		data.setNumber(-10);
		Set<ConstraintViolation<Data>> violations = validator.validate(data);

		return Response.builder()
				.setStatusCode(200)
				.setRawBody("Has violations? " + !violations.isEmpty())
				.setHeaders(headers)
				.build();
	}
}
