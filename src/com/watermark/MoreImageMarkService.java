package com.watermark;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class MoreImageMarkService implements MarkService {

	@Override
	public String watermark(File image, String imageFileName, String uploadPath, String realUploadPath) {
		String logoFileName = "logo_" + imageFileName;
		OutputStream os = null;
		String logoPath = realUploadPath + "/" + LOGO;
		try {
			Image image2 = ImageIO.read(image);
			int width = image2.getWidth(null);
			int height = image2.getHeight(null);

			BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image2, 0, 0, width, height, null);

			File logo = new File(logoPath);
			Image imageLogo = ImageIO.read(logo);
			int width1 = imageLogo.getWidth(null);
			int height1 = imageLogo.getHeight(null);

			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));
			
			//关键代码
			g.rotate(Math.toRadians(30), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
			int x = -width / 2;
			int y = -height / 2;

			while (x < width * 1.5) {
				y = -height / 2;
				while (y < height * 1.5) {
					g.drawImage(imageLogo, x, y, null);
					y += height1 + 30;
				}
				x += width1 + 30;
			}
			//关键代码
			
			g.dispose();

			os = new FileOutputStream(realUploadPath + "/" + logoFileName);
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(bufferedImage);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		return uploadPath + "/" + logoFileName;
	}

}
