package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.InstructorService;
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

    @Autowired
    private InstructorService instructorService;



    @Before // before we do anything we need to intialize
    public void setup()
    {
        RestAssuredMockMvc.webAppContextSetup((webApplicationContext));
    }


    @Test
    public void givenPostANewCourse() throws Exception
    {
        Instructor inst = instructorService.findInstructorById(3);
        Course c1 = new Course("New Course", inst);
        ObjectMapper mapper = new ObjectMapper();
        String string1 = mapper.writeValueAsString(c1);
        given().contentType("application/json").body(string1).when().post("/courses/course/add").then().statusCode(201);

        System.out.println(string1);
    }
}
