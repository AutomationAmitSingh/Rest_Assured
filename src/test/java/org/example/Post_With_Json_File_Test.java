package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.jayway.restassured.RestAssured.given;

public class Post_With_Json_File_Test {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("../Rest_Assured/Demo.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        Response rs = given()
                .contentType(ContentType.JSON)
                .body(jo.toString())
                .when()
                .post("http://localhost:3000/friends");

        System.out.println("Status code: "+rs.getStatusCode());
        System.out.println("Data is:");
        System.out.println(rs.asString());

    }

}
