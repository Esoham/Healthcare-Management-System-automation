package com.healthcare.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExternalHealthServiceAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.external-health-service.com";
    }

    @Test
    public void testGetPatientInfo() {
        given()
            .pathParam("patientId", "P12345")
        .when()
            .get("/patients/{patientId}")
        .then()
            .statusCode(200)
            .body("name", notNullValue())
            .body("dateOfBirth", notNullValue());
    }

    @Test
    public void testCreateAppointment() {
        String requestBody = "{\"patientId\":\"P12345\",\"doctorId\":\"D67890\",\"date\":\"2024-09-01\",\"time\":\"14:30:00\"}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/appointments")
        .then()
            .statusCode(201)
            .body("appointmentId", notNullValue());
    }

    @Test
    public void testUpdatePatientRecord() {
        String requestBody = "{\"recordType\":\"LabResult\",\"details\":\"Blood test results: All normal\"}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .pathParam("patientId", "P12345")
        .when()
            .put("/patients/{patientId}/records")
        .then()
            .statusCode(200)
            .body("updated", equalTo(true));
    }
}
