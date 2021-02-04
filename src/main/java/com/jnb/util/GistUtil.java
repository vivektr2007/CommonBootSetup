package com.jnb.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

import com.jnb.modal.UserBean;

public class GistUtil {
	public static String FOLDER_PATH_STUDENT_PIC_FILE = "/var/lib/tomcat8/webapps/Images/";
	public static String HTTP_FOLDER_PATH = "http://13.127.82.69/Images/";

	public static String generateRandomPassword() {

		Random random = new Random();
		String password = String.format("%05d", random.nextInt(100000));

		return password;
	}

	public static String uploadImages(MultipartFile advFile, UserBean userBean) {

		String imagePath = "";
		String newFileName = "";
		if (advFile != null && advFile.getOriginalFilename() != null && !"".equals(advFile.getOriginalFilename())) {
			newFileName = GistUtil.getFileNameWithTimeStamp(advFile.getOriginalFilename()).replaceAll(" ", "_");
			String folderPath = GistUtil.FOLDER_PATH_STUDENT_PIC_FILE + "/";
			if (!new File(folderPath).exists()) {
				new File(folderPath).mkdir();
			}
			String path = folderPath + newFileName;
			File destinationFile = new File(path);
			try {
				advFile.transferTo(destinationFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			imagePath = GistUtil.HTTP_FOLDER_PATH + "/" + newFileName;
		}
		return imagePath;
	}

	public static void deleteFile(String filePath) {

		try {
			File f = new File(filePath);
			if (f.exists()) {
				f.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getFileNameWithTimeStamp(String fileName) {
		String date = new SimpleDateFormat("ddMMyyyyHH_mm_ss_S").format(new Date());
		fileName = fileName.substring(0, fileName.lastIndexOf(".")) + date
				+ fileName.substring(fileName.lastIndexOf("."));

		return fileName;
	}

	public static String encodeString(String message) {
		try {
			message = URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return message;
	}

}
