package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class Response_Parsing {

    public static void main(String[] args) {

        Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/friends");

        String firstName = rs.jsonPath().get("[0].firstName");

        //System.out.println(rs.asString());
        System.out.println(firstName);
    }

}
