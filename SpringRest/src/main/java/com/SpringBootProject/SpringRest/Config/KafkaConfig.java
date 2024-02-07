package com.SpringBootProject.SpringRest.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	@Bean
	public NewTopic topic() {
		
		return TopicBuilder.name(AppConstants.COURSE_TOPIC_NAME).build();
	}
}
