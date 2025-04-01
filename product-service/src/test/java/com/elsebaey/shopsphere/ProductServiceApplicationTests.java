package com.elsebaey.shopsphere;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import static org.hamcrest.Matchers.notNullValue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String RequestBody = """
				{
					"name": "IPhone 15",
				     "description": "IPhone 15 is a smartphone from Apple",
				     "price": 1000
				}
				""";
		RestAssured.given()
				.body(RequestBody)
				.contentType("application/json")
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", notNullValue())
				.body("name", Matchers.equalTo("IPhone 15"))
				.body("description", Matchers.equalTo("IPhone 15 is a smartphone from Apple"))
				.body("price", Matchers.equalTo(1000));
	}



}
