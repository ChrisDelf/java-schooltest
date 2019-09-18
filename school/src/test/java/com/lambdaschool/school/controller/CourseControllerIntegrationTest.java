package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before // before we do anything we need to intialize
    public void setup()
    {
        RestAssuredMockMvc.webAppContextSetup((webApplicationContext));
    }


    @Test
    public void addNewCourse() throws Exception
    {
        ArrayList<Course> thisCourse = new ArrayList<>();
        String course3Name = "Basketweaving";
        Instructor instType3 = new Instructor("Charlie");
        instType3.setInstructid(5);
        Course c3 = new Course(course3Name,instType3 );

        ObjectMapper mapper = new ObjectMapper();
        String stringR3 = mapper.writeValueAsString(c3);

        given().contentType("application/json").body(stringR3)
                .when()
                .post("/courses/course/add")
                .then().statusCode(201);
    }

}
