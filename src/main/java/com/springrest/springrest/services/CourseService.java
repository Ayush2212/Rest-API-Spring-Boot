package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

public interface CourseService {
	public static final CourseService courseService = null;
	public List<Course>getCourses();
	// this is interface so we just define method here and will make new class to implement to implement this interface
	
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long courseId);
}
