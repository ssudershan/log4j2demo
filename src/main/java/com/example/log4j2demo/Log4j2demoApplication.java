package com.example.log4j2demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.StringMapMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class Log4j2demoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Log4j2demoApplication.class, args);

		Map m = new HashMap<String,String>();

		m.put("message", "this is an actual error message "); // Exception meessge - e.getMessage()
		m.put("custom_msg", "this is a custom  message ");

		LogManager.getLogger(Log4j2demoApplication.class).info(new StringMapMessage(m));
		LogManager.getLogger(Log4j2demoApplication.class).error(new StringMapMessage(m));
	}

}
