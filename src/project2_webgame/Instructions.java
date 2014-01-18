package project2_webgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public class Instructions {
	private boolean running = false;

	private Image[] sprites;
	
	private int skipOver = 1;

	public Instructions(Image[] sprites) {
		this.sprites = sprites;
	}

	public void run() {
		this.running = true;
	}

	public void paint(Graphics2D g) {
		if (!running)
			return;

		// /** Clear the background */
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, 1280, 640);
		//
		// /** Title text */
		// g.setFont(font.deriveFont(Font.PLAIN, 72));
		// g.setColor(new Color(97, 184, 109));
		// g.drawString("Instructions", 30, 70);
		//
		// /** Top-Left Square */
		// g.setColor(Color.BLACK);
		// g.fillRect(130, 100, 500, 250);
		// g.setColor(new Color(97, 184, 109));
		// g.drawRect(130, 100, 500, 250);
		//
		// g.setFont(font.deriveFont(Font.PLAIN, 14));
		// g.drawString("Basic Gameplay", 135, 115);
		// g.drawString(
		// "Gameplay consists of moving around the map through a point and click system. Clicking one of your heroes on the field will select said hero and will allow you to controll it on the field.",
		// 140, 130);
		// /** Bottom-Left Square */
		// g.setColor(Color.BLACK);
		// g.fillRect(130, 360, 500, 250);
		// g.setColor(new Color(97, 184, 109));
		// g.drawRect(130, 360, 500, 250);
		// /** Top-Right Square */
		// g.setColor(Color.BLACK);
		// g.fillRect(640, 100, 500, 250);
		// g.setColor(new Color(97, 184, 109));
		// g.drawRect(640, 100, 500, 250);
		// /** Bottom-Right Square */
		// g.setColor(Color.BLACK);
		// g.fillRect(640, 360, 500, 250);
		// g.setColor(new Color(97, 184, 109));
		// g.drawRect(640, 360, 500, 250);

		g.drawImage(sprites[0], 0, 0, null);
		g.drawImage(sprites[skipOver], 1155, 484, null);
	}

	public int doClick(Point c) {
		if (c.getX() > 1160 && c.getX() < 1260 && c.getY() > 494
				&& c.getY() < 594) {
			this.running = false;
			return 1;
		}
		return 0;
	}
	
	public void update(long delta) {
		if (!isRunning())
			return;
	}

	public boolean isRunning() {
		return running;
	}
	
	public void setSkip(int i) {
		skipOver = i;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
}