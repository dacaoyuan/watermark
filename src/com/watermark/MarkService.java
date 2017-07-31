package com.watermark;

import java.awt.Font;
import java.io.File;
import java.awt.*;

public interface MarkService {

	public static final String MARK_TEXT = "Ä½¿ÎÍø";
	public static final String FONT_NAME = "Î¢ÈíÑÅºÚ";
	public static final int FONT_SYTLE = Font.BOLD;
	public static final int FONT_SIZE = 30;
	public static final Color FONT_COLOR = Color.BLACK;

	public static final int X = 10;
	public static final int Y = 10;

	public static float ALPHA = 0.4F;

	public static final String LOGO = "logo.png";

	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath);

}