package com.joyson.imagegallery.services;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.joyson.imagegallery.model.Images;
import com.joyson.imagegallery.repository.ImageRepository;

/**
 * Implementation of ImageService interface
 * 
 * @author Joyson De Souza
 *
 */
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	ImageContentService imageContentService;

	@Autowired
	ImageFileService imageFileService;

	@Autowired
	UserService userService;

	@Override
	public void saveImage(final MultipartFile file, final String info) throws IOException {
		Images image = new Images();
		image.setCreateBy(userService.getUser(new Long(1)));
		image.setCreatedDate(new Date(System.currentTimeMillis()));
		image.setImageName(file.getOriginalFilename());
		image.setMimeType(file.getContentType());
		image.setSize(file.getSize());
		String imageBinPath = imageFileService.createFilePath();
		imageContentService.writeImageContentToFileSystem(imageBinPath, file.getInputStream());
		image.setContentUrl(imageBinPath);
		image.setInfo(info);
		imageRepository.save(image);
	}

	@Override
	public Images getImage(final Long imageId) {
		return imageRepository.findById(imageId).get();

	}

	@Override
	public void deleteImage(String imageName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateImage(String imageName) {
		// TODO Auto-generated method stub

	}

}
