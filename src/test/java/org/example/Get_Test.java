package org.example;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class Get_Test {

    public static void main(String[] args) {

       Response rs = given()
               .contentType(ContentType.JSON)
               .when()
               .get("http://localhost:3000/friends");
       System.out.println("Status code: "+rs.getStatusCode());
       System.out.println("Data is:");
       System.out.println(rs.asString());

    }
}
