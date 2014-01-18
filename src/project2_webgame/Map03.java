package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map03 extends Map {

	public Map03(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[12][1] = true;
		data[13][1] = true;
		data[14][1] = true;
		data[9][2] = true;
		data[10][2] = true;
		data[11][2] = true;
		data[12][2] = true;
		data[13][2] = true;
		data[14][2] = true;
		data[12][3] = true;
		data[13][3] = true;
		data[14][3] = true;
		data[21][3] = true;
		data[29][4] = true;
		data[30][4] = true;
		data[1][5] = true;
		data[2][5] = true;
		data[5][5] = true;
		data[6][5] = true;
		data[8][5] = true;
		data[9][5] = true;
		data[29][5] = true;
		data[30][5] = true;
		data[1][6] = true;
		data[2][6] = true;
		data[5][6] = true;
		data[6][6] = true;
		data[8][6] = true;
		data[9][6] = true;
		data[15][7] = true;
		data[16][7] = true;
		data[5][8] = true;
		data[6][8] = true;
		data[8][8] = true;
		data[9][8] = true;
		data[15][8] = true;
		data[16][8] = true;
		data[5][9] = true;
		data[6][9] = true;
		data[8][9] = true;
		data[9][9] = true;
		data[24][9] = true;
		data[25][9] = true;
		data[26][9] = true;
		data[24][10] = true;
		data[25][10] = true;
		data[26][10] = true;
		data[30][14] = true;
		data[31][14] = true;
		data[10][15] = true;
		data[11][15] = true;
		data[12][15] = true;
		data[30][15] = true;
		data[31][15] = true;
		data[10][16] = true;
		data[11][16] = true;
		data[12][16] = true;
		data[19][16] = true;
		data[20][16] = true;
		data[19][17] = true;
		data[20][17] = true;
		
		startPositions = new Point[] { new Point(1, 1), new Point(10, 4),
				new Point(3, 11), new Point(2, 18), new Point(12, 13),
				new Point(18, 14), new Point(20, 9), new Point(29, 10),
				new Point(28, 17), new Point(22, 2), };

		// pad1 naar beneden
		// pad2 naar boven
		// pad3 naar beneden
		waypoints.add(new Point[] { new Point(3, 0), new Point(3, 1),
				new Point(3, 2), new Point(3, 3), new Point(4, 3),
				new Point(5, 3), new Point(6, 3), new Point(7, 3),
				new Point(7, 4), new Point(7, 5), new Point(7, 6),
				new Point(7, 7), new Point(7, 8), new Point(7, 9),
				new Point(7, 10), new Point(7, 11), new Point(8, 11),
				new Point(9, 11), new Point(10, 11), new Point(11, 11),
				new Point(12, 11), new Point(13, 11), new Point(14, 11),
				new Point(15, 11), new Point(15, 12), new Point(15, 13),
				new Point(15, 14), new Point(15, 15), new Point(15, 16),
				new Point(15, 17), new Point(15, 18), new Point(15, 19), });

		waypoints.add(new Point[] { new Point(7, 19), new Point(7, 18),
				new Point(7, 17), new Point(6, 17), new Point(5, 17),
				new Point(5, 16), new Point(5, 15), new Point(4, 15),
				new Point(3, 15), new Point(2, 15), new Point(1, 15),
				new Point(1, 14), new Point(1, 13), new Point(1, 12),
				new Point(1, 11), new Point(1, 10), new Point(1, 9),
				new Point(2, 9), new Point(3, 9), new Point(3, 8),
				new Point(3, 7), new Point(4, 7), new Point(5, 7),
				new Point(6, 7), new Point(7, 7), new Point(8, 7),
				new Point(9, 7), new Point(10, 7), new Point(10, 6),
				new Point(11, 6), new Point(12, 6), new Point(12, 7),
				new Point(12, 8), new Point(12, 9), new Point(13, 9),
				new Point(14, 9), new Point(14, 8), new Point(14, 7),
				new Point(14, 6), new Point(15, 6), new Point(16, 6),
				new Point(17, 6), new Point(18, 6), new Point(18, 5),
				new Point(18, 4), new Point(18, 3), new Point(18, 2),
				new Point(18, 1), new Point(18, 0),

		});
		waypoints.add(new Point[] { new Point(26, 0), new Point(26, 1),
				new Point(26, 2), new Point(26, 3), new Point(27, 3),
				new Point(28, 3), new Point(29, 3), new Point(30, 3),
				new Point(31, 3), new Point(31, 4), new Point(31, 5),
				new Point(31, 6), new Point(30, 6), new Point(29, 6),
				new Point(28, 6), new Point(27, 6), new Point(26, 6),
				new Point(25, 6), new Point(24, 6), new Point(23, 6),
				new Point(23, 7), new Point(23, 8), new Point(23, 9),
				new Point(23, 10), new Point(23, 11), new Point(23, 12),
				new Point(23, 13), new Point(24, 13), new Point(25, 13),
				new Point(25, 14), new Point(25, 15), new Point(26, 15),
				new Point(27, 15), new Point(27, 16), new Point(27, 17),
				new Point(27, 18), new Point(26, 18), new Point(25, 18),
				new Point(24, 18), new Point(24, 19), });
		
		//7-9
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
				new Wave(20, 10, 3, 60, 2f, sprites[7], waypoints.get(0),
						player, waveManager, 5, 1),
				new Wave(15, 30, 4, 60, 2f, sprites[8], waypoints.get(2),
						player, waveManager, 5, 1),
				new Wave(20, 50, 4, 120, 2f, sprites[9], waypoints.get(1),
						player, waveManager, 6, 1),
				new Wave(10, 60, 5, 60, 2f, sprites[8], waypoints.get(0),
						player, waveManager, 5, 1),
				new Wave(10, 0, 5, 60, 2f, sprites[9], waypoints.get(2),
						player, waveManager, 5, 1),
				new Wave(10, 0, 5, 120, 2f, sprites[7], waypoints.get(1),
						player, waveManager, 5, 1),
						};

	}
}