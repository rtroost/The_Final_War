package project2_webgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Credits {

	private String[] stream;

	private Player player;

	private float x = 640;
	private float y = (Playfield.HEIGHT * Playfield.TILE_SIZE) + 50;

	private boolean running = false;

	public Credits() {

	}

	public void setReferences(Player player) {
		this.player = player;
	}

	public void run() {
		if (player.getLives() > 0) {
				stream = new String[] {
						"Credits:",
						" ",
						" ",
						"This game is created by Djoezzy Games!",
						" ",
						"Projectmanager and designer:",
						"Stefan Bayarri",
						" ",
						"Lead Designer:",
						"Nick van Leeuwen", 
						" ",
						"Head Developer:",
						"Rob Troost", 
						" ",
						"Second Developer and version control:",
						"Remco van der Kleijn", 
						" ",
						" THE END ",
						" ",
						};
		}
		this.running = true;
	}

	public void paint(Graphics2D g) {
		if (!running)
			return;

		/** Clear everything off the screen */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 2000, 2000);

		/** Start the actual paint work */
		g.setFont(new Font("SansSerif", Font.PLAIN, 42));
		g.setColor(Color.WHITE);
		for (int i = 0; i < stream.length; i++) {
			FontMetrics fm = g.getFontMetrics();
			g.drawString(stream[i], x - (fm.stringWidth(stream[i]) / 2), y
					+ (48 * i));
		}
	}

	public void update(long delta) {
		if (!running)
			return;

		y -= (delta * 0.05f);
	}

	public boolean isRunning() {
		return running;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
}
