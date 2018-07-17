package com.joyson.imagegallery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is a starting point of the application
 * 
 * @author Joyson De Souza
 *
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.joyson.imagegallery")
public class ImageGalleryApp {
	public static void main(String[] args) {
		SpringApplication.run(ImageGalleryApp.class, args);
	}
}
