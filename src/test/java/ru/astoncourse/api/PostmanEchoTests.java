package ru.astoncourse.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTests {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        given()
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json; charset=utf-8")
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .contentType(ContentType.JSON)
                .get(BASE_URL + "/get")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testPostRequestRawText() {
        String rawData = "{ \"test\": \"value\" }";

        given()
                .header("Content-Type", "text/plain; charset=utf-8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body(rawData)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testPostRequestFromData() {
        given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(BASE_URL + "/post")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testPutRequest() {
        given()
                .header("Content-Type", "text/plain; charset=utf-8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put(BASE_URL + "/put")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testPatchRequest() {
        given()
                .header("Content-Type", "application/json; charset=utf-8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testDeleteRequest() {
        given()
                .header("Content-Type", "text/plain; charset=utf-8")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
