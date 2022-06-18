package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    CourseMapper courseMapper;
    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setId((long) i);
            course.setUserId(i);
            course.setStatus(1);
            courseMapper.insert(course);
        }
    }

    @Test
    void select(){
        List<Course> courses = courseMapper.selectList(null);
        System.out.println(courses);
    }

    @Test
    void selectRange(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.between("id","1","2");
        List<Course> courses = courseMapper.selectList(null);
        System.out.println(courses);
    }

}
