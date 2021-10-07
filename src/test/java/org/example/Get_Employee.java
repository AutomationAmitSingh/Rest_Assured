package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.simple.JSONObject;

import static com.jayway.restassured.RestAssured.given;

public class Get_Employee {

    public static void main(String[] args) {

        Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees");



    }

}
