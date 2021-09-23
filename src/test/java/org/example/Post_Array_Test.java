package org.example;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class Post_Array_Test {

    public static void main(String[] args) {
        Address_Pojo[] address = new Address_Pojo[2];
        address[0] = new Address_Pojo();
        address[1] = new Address_Pojo();
        address[0].setHouseNumber(18);
        address[0].setBlock('A');
        address[0].setStreet("Karan Enclave");
        address[0].setCity("Ghaziabad");
        address[0].setState("Uttar Pradesh");
        address[0].setCountry("India");
        address[0].setLandmark("Near Green View Apartments");
        address[0].setPin(201009);
        address[1].setHouseNumber(32);
        address[1].setBlock('E');
        address[1].setStreet("Karan Enclave");
        address[1].setCity("Ghaziabad");
        address[1].setState("Uttar Pradesh");
        address[1].setCountry("India");
        address[1].setLandmark("Near Green View Apartments");
        address[1].setPin(201009);
        Post_Array_Pojo data = new Post_Array_Pojo();
        data.setFirstName("Amit Singh");
        data.setLastName("Singh");
        data.setId(4);
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
