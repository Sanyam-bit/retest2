package com.app.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.entities.Course;

public interface CourseService {

	public List<Course>getCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
	
}
