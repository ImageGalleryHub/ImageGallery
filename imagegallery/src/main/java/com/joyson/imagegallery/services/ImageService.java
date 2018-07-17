package com.joyson.imagegallery.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.joyson.imagegallery.model.Images;

/**
 * Basic CRUD operation service for Images
 * 
 * @author Joyson De Souza
 *
 */
public interface ImageService {

	public void saveImage(MultipartFile file, String info) throws IOException;
	
	public Images getImage(Long imageName);
	
	public void deleteImage(String imageName);
	
	public void updateImage(String imageName);
}
