package com.SpringBootProject.SpringRest.CourseServices;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProject.SpringRest.Dao.CourseDao;
import com.SpringBootProject.SpringRest.Entities.Course;
@Service
public class implementService implements CourseServices{
	
	@Autowired
	private KafkaService kafkaService;
	
	@Autowired
	private CourseDao daovariable;
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	public implementService() {
		//not required of constructor
	}

	@Override
	public List<Course> getCourses() {
		
		return daovariable.findAll();
	}

	//@SuppressWarnings("deprecation")
	
	@Override
	public Course getCourse(long CourseID) {
		return daovariable.findById(CourseID).get();
	}

	@Override
	public Course postCourse(Course course) {
		String s="new course :- " +course.toString();	
		this.kafkaService.updateCourse(s);
		this.logger.info("course update sent");
		
		daovariable.save(course);
		return course;
	}

	@Override
	public Course putCourse(Course course) {
		String s="update course:- " +course.toString();	
		this.kafkaService.updateCourse(s);
		this.logger.info("course update sent");
		
		daovariable.save(course);
		return course;
	}

	@Override
	public void deleteCourses(long CourseID) {
		String s="Deleting course:- " + getCourse(CourseID).toString();	
		this.kafkaService.updateCourse(s);
		this.logger.info("course update sent");
		
		@SuppressWarnings("deprecation")
		Course temp=daovariable.getOne(CourseID);
		daovariable.delete(temp);
	}

}
