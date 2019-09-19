package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest {
@Autowired
private CourseService courseService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findCourseById() {
        assertEquals("Mobile Android", courseService.findCourseById(6).getCoursename());
    }

    @Test
    public void delete() {
        courseService.delete(3);
        assertEquals(5,courseService.findAll().size());
    }
    @Test
    public void deleteFound()
    {
        courseService.delete(2);
        assertEquals(5, courseService.findAll().size());
    }
    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        courseService.delete(100);
        assertEquals(5, courseService.findAll().size());
    }
}