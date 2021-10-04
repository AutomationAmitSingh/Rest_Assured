package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Pattern;

import static com.jayway.restassured.RestAssured.given;

public class Post_DV_Json_Test {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("../Rest_Assured/Variable.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jo = new JSONObject(jt);

        String data = jo.toString();
        data = data.replaceAll(Pattern.quote("{{"+"id"+"}}"),"2");
        data = data.replaceAll(Pattern.quote("{{"+"fN"+"}}"),"David");
        data = data.replaceAll(Pattern.quote("{{"+"lN"+"}}"),"Miller");
        data = data.replaceAll(Pattern.quote("{{"+"prof"+"}}"),"Batsman");
        data = data.replaceAll(Pattern.quote("{{"+"exp"+"}}"),"10");

        Response rs = given()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("http://localhost:3000/friends");

        System.out.println("Status code: "+rs.getStatusCode());
        System.out.println("Data is:");
        System.out.println(rs.asString());


    }

}