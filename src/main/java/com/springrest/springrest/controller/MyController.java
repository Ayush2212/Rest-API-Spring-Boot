package com.springrest.springrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
//import com.springrest.springrest.services.CourseServiceImpl;
//import com.springrest.springrest.services.CourseService;

//import springframework.beans.factory.annotation.Autowired(required=true);
@RestController

public class MyController {
	
	//Creating object of service class its parent interface to access methods of CourseServiceImpl class

	//this annotation autowired will inject object of the courseServiceImpl class in this controller
	@Autowired
	private CourseService courseService;
	
	//NOW HERE WE WILL DO MAPPING OF URLs AS PER METHOS
	@GetMapping("/home")
	public String home() {
		return "Welcome to home";
	}
	
	
	//Creating method to return list of courses
	@GetMapping("/courses")
	public List<Course> getcourses(){
		// Now this controller will return all courses and
		//for doing this it will require service so it will go to service layer
		//for this we will make service layer from where this controller will request
		
		return this.courseService.getCourses();//this will call method getCourse of interface CourseService
		// I made this Interface class and its implementation class seperately for loose coupling
		
		
	}
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	//now updating course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse();
	}
	
	//deleting course
	//we are passing Http status for the request sent by client to make Api rhobust
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
