package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map01 extends Map {

	public Map01(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {
		data[6][1] = true;
		data[13][2] = true;
		data[26][2] = true;
		data[1][5] = true;
		data[24][5] = true;
		data[25][5] = true;
		data[24][6] = true;
		data[25][6] = true;
		data[9][9] = true;
		data[10][9] = true;
		data[9][10] = true;
		data[10][10] = true;
		data[18][10] = true;
		data[11][12] = true;
		data[12][12] = true;
		data[11][13] = true;
		data[12][13] = true;
		data[0][15] = true;
		data[21][15] = true;
		data[7][16] = true;
		data[26][16] = true;
		data[15][17] = true;
		data[16][17] = true;
		data[17][17] = true;
		data[15][18] = true;
		data[16][18] = true;
		data[17][18] = true;
		data[15][19] = true;
		data[16][19] = true;
		data[17][19] = true;

		startPositions = new Point[] { new Point(5, 3), new Point(1, 6),
				new Point(1, 12), new Point(6, 11), new Point(6, 14),
				new Point(1, 15), new Point(19, 13), new Point(13, 16),
				new Point(22, 5), new Point(14, 4), };

		waypoints.add(new Point[] { new Point(1, 0), new Point(1, 1),
				new Point(1, 2), new Point(1, 3), new Point(2, 3),
				new Point(3, 3), new Point(3, 4), new Point(3, 5),
				new Point(3, 6), new Point(3, 7), new Point(3, 8),
				new Point(2, 8), new Point(2, 9), new Point(2, 10),
				new Point(2, 11), new Point(3, 11), new Point(3, 12),
				new Point(4, 12), new Point(4, 13), new Point(4, 14),
				new Point(4, 15), new Point(4, 16), new Point(4, 17),
				new Point(3, 17), new Point(3, 18), new Point(3, 19), });

		waypoints.add(new Point[] { new Point(10, 0), new Point(10, 1),
				new Point(10, 2), new Point(11, 2), new Point(11, 3),
				new Point(11, 4), new Point(10, 4), new Point(9, 4),
				new Point(9, 5), new Point(9, 6), new Point(10, 6),
				new Point(11, 6), new Point(12, 6), new Point(12, 7),
				new Point(12, 8), new Point(11, 8), new Point(10, 8),
				new Point(9, 8), new Point(8, 8), new Point(8, 9),
				new Point(8, 10), new Point(8, 11), new Point(9, 11),
				new Point(10, 11), new Point(11, 11), new Point(12, 11),
				new Point(13, 11), new Point(13, 12), new Point(13, 13),
				new Point(13, 14), new Point(12, 14), new Point(11, 14),
				new Point(10, 14), new Point(10, 15), new Point(10, 16),
				new Point(10, 17), new Point(10, 18), new Point(11, 18),
				new Point(11, 19) });

		waypoints.add(new Point[] { new Point(16, 0), new Point(16, 1),
				new Point(16, 2), new Point(16, 3), new Point(16, 4),
				new Point(16, 5), new Point(16, 6), new Point(16, 7),
				new Point(16, 8), new Point(16, 9), new Point(16, 10),
				new Point(16, 11), new Point(16, 12), new Point(16, 13),
				new Point(16, 14), new Point(16, 15), new Point(16, 16) });

		waypoints.add(new Point[] { new Point(22, 0), new Point(22, 1),
				new Point(21, 1), new Point(21, 2), new Point(20, 2),
				new Point(20, 3), new Point(20, 4), new Point(19, 4),
				new Point(19, 5), new Point(19, 6), new Point(19, 7),
				new Point(20, 7), new Point(21, 7), new Point(21, 8),
				new Point(22, 8), new Point(22, 9), new Point(23, 9),
				new Point(23, 10), new Point(24, 10), new Point(24, 11),
				new Point(24, 12), new Point(24, 13), new Point(24, 14),
				new Point(24, 15), new Point(24, 16), new Point(24, 17),
				new Point(24, 18), new Point(24, 19), });

		waypoints.add(new Point[] { new Point(29, 0), new Point(29, 1),
				new Point(29, 2), new Point(29, 3), new Point(30, 3),
				new Point(30, 4), new Point(30, 5), new Point(29, 5),
				new Point(29, 6), new Point(29, 7), new Point(29, 8),
				new Point(28, 8), new Point(28, 9), new Point(28, 10),
				new Point(29, 10), new Point(29, 11), new Point(29, 12),
				new Point(30, 12), new Point(30, 13), new Point(30, 14),
				new Point(30, 15), new Point(29, 15), new Point(29, 16),
				new Point(29, 17), new Point(29, 18), new Point(29, 19) });

		waves = new Wave[] { 
//				new Wave(
//		/** Amount of enemies */
//		10,
//		/** Time between the last wave and this wave */
//		10,
//		/** Spawn time between each enemy */
//		5,
//		/** Health */
//		10,
//		/** Speed multiplier */
//		1f,
//		/** Texture for this enemy */
//		sprites[1],
//		/** Way-points to walk on */
//		waypoints.get(0),
//		/** Reference to player */
//		player,
//		/** Reference to waveManager */
//		waveManager),

		 new Wave(10, 10, 5, 30, 2f, sprites[1], waypoints.get(1), player,
		 waveManager, 5, 1),
		 new Wave(10, 20, 5, 30, 2f, sprites[2], waypoints.get(3), player,
		 waveManager, 5, 1),
		 new Wave(20, 30, 4, 40, 1f, sprites[1], waypoints.get(0), player,
		 waveManager, 5, 1),
		 new Wave(20, 10, 4, 40, 1f, sprites[2], waypoints.get(4), player,
		 waveManager, 5, 1),
		 
		 new Wave(10, 50, 4, 30, 2f, sprites[1], waypoints.get(0), player,
		 waveManager, 5, 1),
		 new Wave(10, 0, 4, 30, 2f, sprites[1], waypoints.get(1), player,
		 waveManager, 5, 1),
		 new Wave(10, 0, 4, 50, 1f, sprites[3], waypoints.get(2), player,
		 waveManager, 5, 1),
		 new Wave(10, 0, 4, 30, 2f, sprites[2], waypoints.get(3), player,
		 waveManager, 5, 1),
		 new Wave(10, 0, 4, 30, 2f, sprites[2], waypoints.get(4), player,
		 waveManager, 5, 1),
		 
		// new Wave(10, 10, 5, 20, 2f, sprites[1], waypoints.get(2), player,
		// waveManager),
		// new Wave(10, 10, 5, 20, 2f, sprites[1], waypoints.get(3), player,
		// waveManager),
		// new Wave(10, 10, 5, 20, 2f, sprites[1], waypoints.get(4), player,
		// waveManager),
		};
	}
}