package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import java.util.List;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class Response_Parsing_Lotto {

    public static void main(String[] args) {


        /*Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/lotto");*/

       // List winnersID = rs.jsonPath().getList("winners.numbers");
        //System.out.println(rs.asString());
        List winnersID = get("http://localhost:3000/lotto").jsonPath().getList("winners.numbers");
        System.out.println(winnersID);

    }

}
