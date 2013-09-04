package gfx;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public String path;
	public int width;
	public int height;

	public int[] pixels;

	public SpriteSheet(String path) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (image == null) {
			return;
		}

		this.path = path;
		this.width = image.getWidth();
		this.height = image.getHeight();

		pixels = image.getRGB(0, 0, width, height, null, 0, width); // AARRGGBB 0xFF(Alpha opaque)FFFF(white);
		
		/*for (int i = 0; i < 6; i++) {
			Color c = new Color(pixels[i]);
			String t = c.getAlpha() + " " + c.getRed() + " " + c.getGreen() + " " + c.getBlue();
			System.out.println(t);			
		}*/
		
		System.out.println("--------------------");

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = (pixels[i] & 0xff); //scans through pixel color data and sets all alpha bits to opaque
		}

		/*for (int i = 0; i < 6; i++) {
			Color c = new Color(pixels[i]);
			String t = c.getAlpha() + " " + c.getRed() + " " + c.getGreen() + " " + c.getBlue();
			System.out.println(t);			
		}*/

	}

}
