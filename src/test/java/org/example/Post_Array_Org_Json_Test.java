package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static com.jayway.restassured.RestAssured.*;

public class Post_Array_Org_Json_Test {

    public static void main(String[] args) {
        JSONArray address = new JSONArray();

        JSONObject primaryInfo = new JSONObject();
        primaryInfo.put("H.No.","3745");
        primaryInfo.put("Street","Fake Street");
        primaryInfo.put("Town","Fake Town");

        JSONObject secondaryInfo = new JSONObject();
        primaryInfo.put("H.No.","3999");
        primaryInfo.put("Street","Fake Street");
        primaryInfo.put("Town","Fake Town");

        JSONObject thirdInfo = new JSONObject();
        primaryInfo.put("H.No.","4000");
        primaryInfo.put("Street","Fake Street");
        primaryInfo.put("Town","Fake Town");


        address.add(0,primaryInfo);
        address.add(1,secondaryInfo);
        address.add(2,thirdInfo);

        JSONObject basicInfo = new JSONObject();
        basicInfo.put("firstName","Sumit");
        basicInfo.put("lastName","Singh");
        basicInfo.put("age","21");
        basicInfo.put("id","8");
        basicInfo.put("Address", address);

        Response res = given()
                .contentType(ContentType.JSON)
                .body(basicInfo.toString())
                .when()
                .post("http://localhost:3000/comments");

        System.out.println("Status code: "+res.getStatusCode());
        System.out.println("Data is:");
        System.out.println(res.asString());

    }

}
