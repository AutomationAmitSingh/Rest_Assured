package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.simple.JSONObject;

import static com.jayway.restassured.RestAssured.*;

public class Post_Org_Json_Test {

    public static void main(String[] args) {

        JSONObject basicInfo = new JSONObject();
        basicInfo.put("firstName","Sumit");
        basicInfo.put("lastName","Singh");
        basicInfo.put("age","21");
        basicInfo.put("id","5");

        Response res = given()
                .contentType(ContentType.JSON)
                .body(basicInfo.toString())
                .when()
                .post("http://localhost:3000/friends");

        System.out.println("Status code: "+res.getStatusCode());
        System.out.println("Data is:");
        System.out.println(res.asString());


    }
}
