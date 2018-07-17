package com.joyson.imagegallery.services;

import java.io.IOException;
import java.io.InputStream;

/**
 * Image content service to read and write image contents to binary file
 * 
 * @author Joyson De Souza
 *
 */
public interface ImageContentService {

	public void writeImageContentToFileSystem(String imageBinPath, InputStream imageInputStream) throws IOException;
	
	public InputStream getImageBinInputStream(String imageBinPath) throws IOException;
	
}
