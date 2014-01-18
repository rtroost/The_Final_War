package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map04 extends Map {

	public Map04(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[15][3] = true;
		data[20][3] = true;
		data[21][3] = true;
		data[22][3] = true;
		data[29][3] = true;
		data[15][4] = true;
		data[20][4] = true;
		data[21][4] = true;
		data[22][4] = true;
		data[15][5] = true;
		data[15][6] = true;
		data[1][7] = true;
		data[2][7] = true;
		data[3][7] = true;
		data[13][7] = true;
		data[14][7] = true;
		data[15][7] = true;
		data[16][7] = true;
		data[17][7] = true;
		data[13][8] = true;
		data[14][8] = true;
		data[15][8] = true;
		data[16][8] = true;
		data[17][8] = true;
		data[13][9] = true;
		data[14][9] = true;
		data[15][9] = true;
		data[16][9] = true;
		data[17][9] = true;
		data[11][10] = true;
		data[12][10] = true;
		data[13][10] = true;
		data[14][10] = true;
		data[15][10] = true;
		data[16][10] = true;
		data[17][10] = true;
		data[11][11] = true;
		data[12][11] = true;
		data[13][11] = true;
		data[14][11] = true;
		data[15][11] = true;
		data[16][11] = true;
		data[17][11] = true;
		data[19][12] = true;
		data[19][13] = true;
		data[19][14] = true;
		data[20][14] = true;
		data[21][14] = true;
		data[18][15] = true;
		data[19][15] = true;
		data[20][15] = true;
		data[21][15] = true;
		data[2][16] = true;
		data[18][16] = true;
		data[19][16] = true;
		data[20][16] = true;
		data[21][16] = true;
		data[22][16] = true;
		data[21][17] = true;
		data[31][17] = true;

		startPositions = new Point[] { new Point(7, 7), new Point(8, 1),
				new Point(19, 6), new Point(3, 13), new Point(13, 17),
				new Point(25, 16), new Point(23, 6), new Point(26, 9),
				new Point(25, 2), new Point(31, 13), };
		
		// pad1

		waypoints.add(new Point[] { new Point(3, 0), new Point(3, 1),
				new Point(3, 2), new Point(4, 2), new Point(5, 2),
				new Point(6, 2), new Point(6, 3), new Point(6, 4),
				new Point(7, 4), new Point(8, 4), new Point(8, 3),
				new Point(9, 3), new Point(10, 3), new Point(10, 4),
				new Point(10, 5), new Point(10, 6), new Point(10, 7),
				new Point(11, 7), new Point(12, 7), new Point(12, 6),
				new Point(13, 6), new Point(14, 6), new Point(14, 7), });

		waypoints.add(new Point[] { new Point(4, 19), new Point(4, 18),
				new Point(4, 17), new Point(5, 17), new Point(6, 17),
				new Point(6, 18), new Point(7, 18), new Point(8, 18),
				new Point(8, 17), new Point(8, 16), new Point(8, 15),
				new Point(8, 14), new Point(7, 14), new Point(7, 13),
				new Point(7, 12), new Point(8, 12), new Point(9, 12),
				new Point(10, 12), new Point(11, 12), new Point(11, 13),
				new Point(11, 14), new Point(12, 14), new Point(13, 14),
				new Point(14, 14), new Point(15, 14), new Point(15, 13),
				new Point(15, 12), });

		waypoints.add(new Point[] { new Point(33, 8), new Point(32, 8),
				new Point(31, 8), new Point(30, 8), new Point(29, 8),
				new Point(29, 9), new Point(29, 10), new Point(29, 11),
				new Point(28, 11), new Point(28, 12), new Point(28, 13),
				new Point(27, 13), new Point(26, 13), new Point(26, 12),
				new Point(25, 12), new Point(24, 12), new Point(24, 11),
				new Point(24, 10), new Point(23, 10), new Point(22, 10),
				new Point(21, 10), new Point(20, 10), new Point(20, 9),
				new Point(19, 9), new Point(18, 9), });
		
		// 10 - 13
		/** Amount of enemies */
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
//		waveManager)
		waves = new Wave[] {
				new Wave(10, 10, 3, 80, 3f, sprites[10], waypoints.get(0),
						player, waveManager,6, 1),
				new Wave(10, 20, 3, 80, 3f, sprites[11], waypoints.get(1),
						player, waveManager,6, 1),
				new Wave(10, 30, 3, 80, 3f, sprites[12], waypoints.get(2),
						player, waveManager,6, 1),
						
				new Wave(10, 40, 5, 80, 2f, sprites[11], waypoints.get(1),
						player, waveManager,6, 1),
				new Wave(10, 0, 5, 80, 2f, sprites[12], waypoints.get(2),
						player, waveManager,6, 1), 
						
				new Wave(10, 60, 5, 100, 1f, sprites[10], waypoints.get(0),
						player, waveManager,6, 1),
				new Wave(1, 0, 5, 1000, 1f, sprites[13], waypoints.get(2),
						player, waveManager,50, 10),
				new Wave(10, 0, 5, 100, 1f, sprites[11], waypoints.get(1),
						player, waveManager,6, 1),
						};

	}
}