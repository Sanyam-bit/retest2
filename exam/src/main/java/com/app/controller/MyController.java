package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Course;
import com.app.services.CourseService;

@RestController
@RequestMapping("/courses")
public class MyController {

	@Autowired
	private CourseService courseservice;

	//get the courses
	@GetMapping
	public List<Course> getCourses(){
		
		return this.courseservice.getCourses();
		
	}
	
	
	//get course byId
	@GetMapping("/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	
	//add new course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseservice.addCourse(course);
		
	}
	
	//update course using put request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseservice.updateCourse(course);
		
	}
	
	
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseID));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}

