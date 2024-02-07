package com.SpringBootProject.SpringRest.CourseServices;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.SpringBootProject.SpringRest.Config.AppConstants;

@Service
public class KafkaService {
	
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public boolean updateCourse(String c) {
		
		
		this.kafkaTemplate.send(AppConstants.COURSE_TOPIC_NAME,c);
		return true;
	}

}
