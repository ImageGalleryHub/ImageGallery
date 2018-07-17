package com.joyson.imagegallery.model;

/**
 * Image Gallery version information pojo
 * 
 * @author Joyson De Souza
 *
 */
public class ImageGallery {

	private String name;
	private String version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ImageGallery(String name, String version) {
		this.name = name;
		this.version = version;
	}
}
