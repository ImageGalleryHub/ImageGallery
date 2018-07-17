package com.joyson.imagegallery.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of ImageFileService interface
 * 
 * @author Jaison
 *
 */
@Transactional
public class ImageFileServiceImpl implements ImageFileService {

	private String basePath;

	public ImageFileServiceImpl(final String basePath) {
		this.basePath = basePath;
	}

	public String createFilePath() throws IOException {
		String folderTimePath = "";
		int[] timePath = { LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
				LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute() };
		for (int time : timePath) {
			if (folderTimePath.isEmpty()) {
				folderTimePath = String.valueOf(time);
			} else {
				folderTimePath += File.separator + time;
			}
			if (!fileExists(basePath + File.separator + folderTimePath)) {
				createFile(basePath + File.separator + folderTimePath);
			}
		}
		UUID uuid = UUID.randomUUID();
		String binImagePath = folderTimePath + File.separator + uuid.toString() + ".bin";
		createImageBinFile(basePath, binImagePath);
		return binImagePath;
	}

	private boolean fileExists(String file) {
		return new File(file).exists();
	}

	private boolean createFile(String filePath) {
		return new File(filePath).mkdir();
	}

	private boolean createImageBinFile(String basePath, String imageBinPath) throws IOException {
		try {
			File imageBinFile = new File(basePath + File.separator + imageBinPath);
			imageBinFile.createNewFile();
			return true;
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			return false;
		}
	}

}
