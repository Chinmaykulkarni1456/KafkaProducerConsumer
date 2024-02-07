package com.SpringBootProject.SpringRest.CourseServices;

import java.util.List;

import com.SpringBootProject.SpringRest.Entities.Course;

public interface CourseServices {

	public List<Course> getCourses();
	
	public Course getCourse(long CourseID);
	
	public Course postCourse(Course course);
	
	public Course putCourse(Course course);
	
	public void deleteCourses(long CourseID);
}
