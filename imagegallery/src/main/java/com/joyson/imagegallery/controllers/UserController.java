package com.joyson.imagegallery.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.joyson.imagegallery.model.Images;
import com.joyson.imagegallery.model.Users;
import com.joyson.imagegallery.services.ImageContentService;
import com.joyson.imagegallery.services.ImageService;
import com.joyson.imagegallery.services.UserService;

/**
 * User controller for Image Gallery user information
 * 
 * @author Joyson De Souza
 *
 */
@RestController
public class UserController extends ImageGalleryBaseController {

	@Autowired
	UserService userService;

	@Autowired
	ImageService imageService;

	@Autowired
	ImageContentService imageContentService;
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public void saveUser(@RequestBody Users user) {
		userService.saveUser(user);
	}

	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<Users> getAllUsers() {
		return userService.getAllUser();
	}

	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public void saveImage(@RequestParam("file") MultipartFile file, @RequestParam("info") String info)
			throws IOException {
		imageService.saveImage(file, info);
	}

	@RequestMapping(path = "/image/{imageId}", method = RequestMethod.GET)
	public void getImageContents(HttpServletResponse response, @PathVariable("imageId") Long imageId)
			throws IOException {
		Images images = imageService.getImage(imageId);
		response.setContentType(images.getMimeType());
		response.setCharacterEncoding("UTF-8");
		IOUtils.copy(imageContentService.getImageBinInputStream(images.getContentUrl()), response.getOutputStream());
	}
}
