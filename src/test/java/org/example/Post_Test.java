package org.example;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class Post_Test {

    public static void main(String[] args) {

        Address_Pojo address = new Address_Pojo();
        address.setHouseNumber(18);
        address.setBlock('A');
        address.setStreet("Karan Enclave");
        address.setCity("Ghaziabad");
        address.setState("Uttar Pradesh");
        address.setCountry("India");
        address.setLandmark("Near Green View Apartments");
        address.setPin(201009);
        Post_Pojo data = new Post_Pojo();
        data.setFirstName("Amit Singh");
        data.setLastName("Singh");
        data.setId(3);
        data.setAge(28);
        data.setCourseName("Artificial Intelligence");
        data.setDesignation("Software Engineer");
        data.setMentorName("Ankit Singh");
        data.setAddress(address);

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
