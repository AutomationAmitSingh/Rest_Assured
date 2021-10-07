package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;

public class Get_Employee {

    //Q1: Write a program to parse response data Employee Name of the 6th Record using JsonPath and
    //Org.Json library

    public static void main(String[] args) {

        Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees");

        JSONObject jo = new JSONObject(rs.asString());
        String employeeName = jo.getJSONArray("data").getJSONObject(0).get("employee_name").toString();
        System.out.println(employeeName);



    }

}
