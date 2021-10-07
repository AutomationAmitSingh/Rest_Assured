package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class Get_Data {

    public static void main(String[] args) {

        Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/data");
        String employeeName = rs.jsonPath().get("employee_name[5]");
        System.out.println("Status code: "+rs.getStatusCode());
        System.out.println("Data is:");
        System.out.println(employeeName);
        //System.out.println(rs.asString());

    }

}
