package com.joyson.imagegallery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyson.imagegallery.model.ImageGallery;

/**
 * Image Gallery version information controller
 * 
 * @author Joyson De Souza
 *
 */
@RestController
public class InformationControllers extends ImageGalleryBaseController {

	@Autowired
	ImageGallery imageGallery;

	@RequestMapping("/info")
	ImageGallery imageGalleryInfo() {
		return imageGallery;
	}
}
