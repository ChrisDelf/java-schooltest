package com.lambdaschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;
import com.lambdaschool.school.service.CourseService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
// we have to make our own seeddata
@RunWith(SpringRunner.class)
@WebMvcTest( value = CourseService.class, secure = false)  //we are turning off user authen
public class CourseControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    private List<Instructor> instructorList;
    private ArrayList<Course> courseList;

    @Before // before we do anything we need to intialize
    public void setup()
    {
        instructorList = new ArrayList<>();
        courseList = new ArrayList<>();

        Instructor instType1 = new Instructor("Ben");
        instType1.setInstructid(1);
        Instructor instType2 = new Instructor("Henry");
        instType2.setInstructid(2);

        instructorList.add(instType1);
        instructorList.add(instType2);


        String course1Name = "Apple";
        String course2Name = "Basketweaving";
        Course c1 = new Course(course1Name, instType1);
        Course c2 = new Course(course2Name, instType2);

        courseList.add(c1);
        courseList.add(c2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAllCourse() throws Exception
    {
        String apiUrl = "/courses/courses";

        Mockito.when(courseService.findAll()).thenReturn(courseList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        // the following actually performs a real controller call
        MvcResult r = mockMvc.perform(rb).andReturn(); // this could throw an exception
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(courseList);


    }
}