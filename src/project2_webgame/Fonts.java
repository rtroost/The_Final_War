package project2_webgame;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class Fonts {

	public static Font getFont(String s) {
		System.out.println("Fetching font -> " + s);
		Font ttfBase = null;
		InputStream myStream = Playfield.class.getClassLoader()
				.getResourceAsStream(s);
		try {
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ttfBase;
	}
}