package com.keywords;

import com.keywords.config.FileUploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileUploadProperties.class
})
public class KeywordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeywordsApplication.class, args);
	}

}
