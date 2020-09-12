package trong.lixco.com.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ResizeImage {
	public static byte[] resizeThumb(InputStream file) {
		try {
			BufferedImage originalImage = ImageIO.read(file);
			originalImage = Scalr.resize(originalImage, Scalr.Method.QUALITY, originalImage.getWidth() / 2,
					originalImage.getHeight() / 2); // resize image
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.close();
			byte[] imageInByte = baos.toByteArray();
			return imageInByte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static byte[] noResize(InputStream file) {
		try {
			BufferedImage originalImage = ImageIO.read(file);
//			originalImage = Scalr.resize(originalImage, Scalr.Method.QUALITY,originalImage.getWidth()/3,originalImage.getHeight()/3); //resize image
			originalImage = Scalr.resize(originalImage, Scalr.Method.QUALITY, originalImage.getWidth(),
					originalImage.getHeight()); // Khong ch?nh kich thu?c
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.close();
			byte[] imageInByte = baos.toByteArray();
			return imageInByte;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static byte[] toByteArray(InputStream is) {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] data = new byte[16384];
		try {
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toByteArray();
	}

}