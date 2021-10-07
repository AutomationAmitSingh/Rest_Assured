package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.given;

public class Get_Employee_Array {

    public static void main(String[] args) {

        Response rs = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees");

        JSONObject jo = new JSONObject(rs.asString());
        int sizeArray = jo.getJSONArray("data").length();
        System.out.println(sizeArray);
        for(int i = 0; i < sizeArray; i++)
        {
            String record = jo.getJSONArray("data").getJSONObject(i).get("employee_age").toString();
            System.out.println(i+" "+record);

        }

    }

}
