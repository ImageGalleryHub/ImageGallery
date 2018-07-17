package com.joyson.imagegallery.services;

import java.io.IOException;

/**
 * Image File service for creating dynamic folder / file structure
 * 
 * @author Joyson De Souza
 *
 */
public interface ImageFileService {

	public String createFilePath() throws IOException;
	
}
