package com.watermark;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WaterMarkAction extends ActionSupport {
	private File[] image;
	private String[] imageFileName;
	private String uploadPath;

	private List<PicInfo> picInfo = new ArrayList<PicInfo>();

	public String watermark() throws Exception {
		String realUploadPath = ServletActionContext.getServletContext().getRealPath(uploadPath);

		UploadService uploadService = new UploadService();

		MarkService markService = new MoreImageMarkService();

		if (image != null && image.length > 0) {
			for (int i = 0; i < image.length; i++) {
				PicInfo pi = new PicInfo();
				String uploadImage = uploadService.uploadImage(image[i], imageFileName[i], uploadPath, realUploadPath);
				pi.setImageURL(uploadImage);

				String logoImage = markService.watermark(image[i], imageFileName[i], uploadPath, realUploadPath);
				pi.setLogoImageURL(logoImage);
				System.out.println("ddd");
				picInfo.add(pi);
			}
		}

		/*
		 * MarkService markService2 = new TextMarkService();
		 * 
		 * String logoImage2 = markService2.watermark(image, imageFileName,
		 * uploadPath, realUploadPath);
		 * 
		 * picInfo.setLogoImageURL(logoImage2);
		 */

		return SUCCESS;
	}

	public File[] getImage() {
		return image;
	}

	public void setImage(File[] image) {
		this.image = image;
	}

	public String[] getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public List<PicInfo> getPicInfo() {
		return picInfo;
	}

	public void setPicInfo(List<PicInfo> picInfo) {
		this.picInfo = picInfo;
	}

}
