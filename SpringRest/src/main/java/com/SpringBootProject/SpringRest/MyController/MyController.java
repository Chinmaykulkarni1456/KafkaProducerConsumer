package com.SpringBootProject.SpringRest.MyController;

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

import com.SpringBootProject.SpringRest.CourseServices.CourseServices;
import com.SpringBootProject.SpringRest.Entities.Course;

@RestController
public class MyController {

	@Autowired
	private CourseServices ccc;
	
	@GetMapping("/Courses")
	public List<Course> getCourses(){
		return this.ccc.getCourses();
	}
	
	@GetMapping("/Courses/{CourseID}")
	public Course getCourse(@PathVariable String CourseID) {
		return this.ccc.getCourse(Long.parseLong(CourseID));
	}
	
	@PostMapping("/Courses")
	public Course postCourse(@RequestBody Course course) {
		return this.ccc.postCourse(course);
	}
	
	@PutMapping("/Courses")
	public Course putCourse(@RequestBody Course course) {
		return this.ccc.putCourse(course);
	}
	
	@DeleteMapping("/Courses/{CourseID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String CourseID){
		try {
			this.ccc.deleteCourses(Long.parseLong(CourseID));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
