package org.sample.quarkus;
import java.util.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.graalvm.polyglot.Source;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

@Named("hello")
public class Hello implements RequestHandler<Map<String, Object>, Response> {
	@Inject
	Validator validator;

	// @Inject
	// EntityManager em;

	/*
	@Transactional
	public void saveRandom() {
		Data data = new Data();
		data.setNumber(new Random().nextInt());
		em.persist(data);
	}

	public List<Data> readAll() {
		TypedQuery<Data> queryAll = em.createQuery("select p from Data p", Data.class);
		return queryAll.getResultList();
	}
	*/

	@Override
	// @Transactional
	public Response handleRequest(Map<String, Object> input, Context context) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");

		Data data = new Data();
		data.setNumber(-10);
		Set<ConstraintViolation<Data>> violations = validator.validate(data);

		// saveRandom();
		// List<Data> allData = readAll();

		return Response.builder()
				.setStatusCode(200)
				// .setRawBody(Arrays.toString(allData.toArray()))
				.setRawBody("Has violations? " + !violations.isEmpty())
				.setHeaders(headers)
				.build();
	}
}
