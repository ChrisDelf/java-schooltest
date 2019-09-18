package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.service.CourseService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest( value = CourseService.class, secure = false)  //we are turning off user authen
public class CourseControllerUnitTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before // before we do anything we need to intialize
    public void setup()
    {
        RestAssuredMockMvc.webAppContextSetup((webApplicationContext));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourses() {

    }
}