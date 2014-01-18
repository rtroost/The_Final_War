package project2_webgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public class SideMenu {

	Player player;
	WaveManager waveManager;

	private int mapnumber;
	Font[] fonts;

	Image[] sprites;

	public SideMenu(Image[] sprites, Font[] fonts) {
		this.sprites = sprites;
		this.fonts = fonts;
	}

	public void setReferences(Player player, WaveManager waveManager,
			int mapnumber) {
		this.player = player;
		this.waveManager = waveManager;
		this.mapnumber = mapnumber;
	}

	public void paint(Graphics2D g) {
		g.translate(Playfield.WIDTH * Playfield.TILE_SIZE, 0);

		g.drawImage(sprites[0], 0, 0, null);

		drawGameStatistics(g);
		drawSelectedUnitInfo(g);

		g.drawImage(sprites[1 + mapnumber], 35, 585, null);

		g.translate(-(Playfield.WIDTH * Playfield.TILE_SIZE), 0);
	}

	private void drawSelectedUnitInfo(Graphics2D g) {
		Unit _u = player.getSelectedUnit();

		if (_u == null) {
			return;
		}

		g.drawString("Damage: " + _u.getdmg(), 43, 425);
		g.drawString("Speed: " + _u.getspeed(), 43, 468);
		g.drawString("Range: " + _u.getrange(), 43, 511);
		g.drawString("AttackSpeed: " + _u.getfireRate(), 43, 554);

		g.drawImage(_u.getSideMenuImage(), 37, 235 + 10, null);
	}

	private void drawGameStatistics(Graphics2D g) {
		/** Money */
		int money = player.getMoney();

		g.setFont(fonts[1].deriveFont(Font.PLAIN, 16));
		g.setColor(new Color(97, 184, 109));

		g.drawString("Money: " + money, 43, 37);
		g.drawString("Next in: " + waveManager.getTimer(), 43, 77);
		g.drawString("Wave nr: " + waveManager.getWaveCounter(), 43, 117);
		g.drawString("Kills: " + waveManager.getKillCounter(), 43, 157);

		/** Lives */
		for (int i = 0; i < player.getLives(); i++) {
			g.drawImage(sprites[1], (42 + (i * 13)), 194, null);
		}

	}

	public void update(long delta) {
	}

	public void doClick(Point c) {
		// New game
		if (c.getX() > 1100 && c.getX() < 1150 && c.getY() > 0 && c.getY() < 50) {
			
		}

	}
}