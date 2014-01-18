package project2_webgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Map {

	Player player;
	WaveManager waveManager;
	
	private int mapNumber;

	protected boolean[][] data = new boolean[Playfield.WIDTH][Playfield.HEIGHT];

	/** Cell values */
	protected static final int MAP1 = 0;

	protected static final int SOLID = 1;

	protected ArrayList<Point[]> waypoints = new ArrayList<Point[]>();
	protected Wave[] waves = null;
	protected Point[] startPositions;

	protected Image[][] sprites;

	public boolean isRoad(float x, float y) {
		// look up the right cell (based on simply rounding the floating
		// values) and check the value
		boolean dataOnTile = data[(int) x][(int) y];
		boolean temp = false;

		for (int i = 0; i < this.waypoints.size(); i++) {
			for (int j = 0; j < this.waypoints.get(i).length; j++) {
				if (waypoints.get(i)[j].x == (int) x
						&& waypoints.get(i)[j].y == (int) y) {
					temp = true;
				}
			}
		}

		if (dataOnTile || temp) {
			return true;
		} else {
			return false;
		}

	}

	public void setReferences(Player player, WaveManager waveManager , int mapnumber) {
		this.player = player;
		this.waveManager = waveManager;
		doStuff();
		this.mapNumber = mapnumber;
	}

	public abstract void doStuff();

	public void update(long delta) {
	}

	public void paint(Graphics2D g) {
		// Paint Background Image
		
		g.drawImage(sprites[0][mapNumber-1], 0, 0, null);
	}

	public Wave[] getWaves() {
		return waves;
	}
	
	public Point[] getStartPositions() {
		return this.startPositions;
	}
}