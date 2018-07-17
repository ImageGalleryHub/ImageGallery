package com.joyson.imagegallery.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ImageContentService
 * 
 * @author Joyson De Souza
 *
 */
@Transactional
public class ImageContentServiceImpl implements ImageContentService {

	private static final int BUFFER_SIZE = 4096; // 4KB
	private String basePath;

	public ImageContentServiceImpl(final String basePath) {
		this.basePath = basePath;
	}

	@Override
	public void writeImageContentToFileSystem(final String imageBinPath, InputStream imageInputStream) throws IOException {
		FileOutputStream imageBinOutputStream = null;
		File imageBinFile = new File(basePath + File.separator + imageBinPath);
		imageBinOutputStream = new FileOutputStream(imageBinFile);
		byte[] buffer = new byte[BUFFER_SIZE];
		while (imageInputStream.read(buffer) != -1) {
			imageBinOutputStream.write(buffer);
		}
		imageBinOutputStream.close();
		imageInputStream.close();
	}

	@Override
	public InputStream getImageBinInputStream(final String imageBinPath) throws IOException {
		return new FileInputStream(new File(basePath + File.separator + imageBinPath));
	}

}
