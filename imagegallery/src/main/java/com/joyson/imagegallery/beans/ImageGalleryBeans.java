package com.joyson.imagegallery.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.joyson.imagegallery.model.ImageGallery;
import com.joyson.imagegallery.services.ImageContentService;
import com.joyson.imagegallery.services.ImageContentServiceImpl;
import com.joyson.imagegallery.services.ImageFileServiceImpl;
import com.joyson.imagegallery.services.ImageService;
import com.joyson.imagegallery.services.ImageServiceImpl;
import com.joyson.imagegallery.services.UserService;
import com.joyson.imagegallery.services.UserServiceImpl;

/**
 * Image Gallery beans configuration
 * 
 * @author Jaison
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ImageGalleryBeans {

	@Value("${imagegallery.base_path.content}")
	private String basePath;

	@Bean
	public ImageFileServiceImpl imageFileService() {
		return new ImageFileServiceImpl(basePath);
	}

	@Bean
	public ImageGallery imageGallery() {
		return new ImageGallery("ImageGallery", "0.0.1");
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public ImageContentService imageContentService() {
		return new ImageContentServiceImpl(basePath);
	}

	@Bean
	public ImageService imageService() {
		return new ImageServiceImpl();
	}
}
