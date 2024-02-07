package com.SpringBootProject.SpringRest.Dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.SpringBootProject.SpringRest.Entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
}
