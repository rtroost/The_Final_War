package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map06 extends Map {

	public Map06(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {
		data[18][2] = true;
		data[17][3] = true;
		data[18][3] = true;
		data[22][3] = true;
		data[23][3] = true;
		data[28][3] = true;
		data[29][3] = true;
		data[4][4] = true;
		data[5][4] = true;
		data[9][4] = true;
		data[10][4] = true;
		data[17][4] = true;
		data[18][4] = true;
		data[22][4] = true;
		data[23][4] = true;
		data[4][5] = true;
		data[5][5] = true;
		data[9][5] = true;
		data[10][5] = true;
		data[17][5] = true;
		data[18][5] = true;
		data[17][6] = true;
		data[20][8] = true;
		data[21][8] = true;
		data[2][9] = true;
		data[13][9] = true;
		data[16][9] = true;
		data[17][9] = true;
		data[18][9] = true;
		data[20][9] = true;
		data[21][9] = true;
		data[26][9] = true;
		data[27][9] = true;
		data[32][9] = true;
		data[1][10] = true;
		data[2][10] = true;
		data[13][10] = true;
		data[16][10] = true;
		data[17][10] = true;
		data[18][10] = true;
		data[26][10] = true;
		data[27][10] = true;
		data[31][10] = true;
		data[32][10] = true;
		data[1][11] = true;
		data[2][11] = true;
		data[20][11] = true;
		data[21][11] = true;
		data[22][11] = true;
		data[23][11] = true;
		data[31][11] = true;
		data[32][11] = true;
		data[1][12] = true;
		data[2][12] = true;
		data[4][12] = true;
		data[5][12] = true;
		data[12][12] = true;
		data[13][12] = true;
		data[14][12] = true;
		data[15][12] = true;
		data[16][12] = true;
		data[21][12] = true;
		data[22][12] = true;
		data[23][12] = true;
		data[24][12] = true;
		data[31][12] = true;
		data[32][12] = true;
		data[1][13] = true;
		data[4][13] = true;
		data[5][13] = true;
		data[13][13] = true;
		data[14][13] = true;
		data[15][13] = true;
		data[16][13] = true;
		data[17][13] = true;
		data[31][13] = true;
		data[6][14] = true;
		data[7][14] = true;
		data[6][15] = true;
		data[7][15] = true;
		data[12][15] = true;
		data[20][15] = true;
		data[21][15] = true;
		data[11][16] = true;
		data[12][16] = true;
		data[16][16] = true;
		data[17][16] = true;
		data[20][16] = true;
		data[21][16] = true;
		data[11][17] = true;
		data[12][17] = true;
		data[27][17] = true;
		data[28][17] = true;
		data[11][18] = true;
		data[12][18] = true;
		data[14][18] = true;
		data[15][18] = true;
		data[16][18] = true;
		data[17][18] = true;
		data[19][18] = true;
		data[20][18] = true;
		data[27][18] = true;
		data[28][18] = true;
		data[11][19] = true;
		data[15][19] = true;
		data[16][19] = true;
		data[17][19] = true;
		data[18][19] = true;
		data[19][19] = true;
		data[20][19] = true;
		
		startPositions = new Point[] { new Point(6, 2), new Point(1, 5),
				new Point(4, 9), new Point(2, 17), new Point(10, 14),
				new Point(24, 17), new Point(32, 16), new Point(31, 6),
				new Point(25, 6), new Point(20, 3), };

		// pad1 naar boven vanaf zeikant
		// pad2 naar beneden vanaf zeikant
		// pad3 naar boven
		// pad4 naar beneden
		// pad5+6 van zeikant naar beneden

		waypoints.add(new Point[] { new Point(0, 14), new Point(1, 14),
				new Point(2, 14), new Point(3, 14), new Point(3, 13),
				new Point(3, 12), new Point(3, 11), new Point(4, 11),
				new Point(5, 11), new Point(5, 10), new Point(5, 9),
				new Point(5, 8), new Point(5, 7), new Point(5, 6),
				new Point(4, 6), new Point(3, 6), new Point(3, 5),
				new Point(3, 4), new Point(3, 3), new Point(3, 2),
				new Point(3, 1), new Point(3, 0), });

		waypoints.add(new Point[] { new Point(0, 14), new Point(1, 14),
				new Point(2, 14), new Point(3, 14), new Point(4, 14),
				new Point(5, 14), new Point(5, 15), new Point(5, 16),
				new Point(6, 16), new Point(7, 16), new Point(8, 16),
				new Point(8, 17), new Point(8, 18), new Point(8, 19), });

		waypoints.add(new Point[] { new Point(13, 19), new Point(13, 18),
				new Point(13, 17), new Point(14, 17), new Point(15, 17),
				new Point(16, 17), new Point(17, 17), new Point(18, 17),
				new Point(18, 16), new Point(18, 15), new Point(18, 14),
				new Point(18, 13), new Point(18, 12), new Point(18, 11),
				new Point(17, 11), new Point(16, 11), new Point(15, 11),
				new Point(14, 11), new Point(13, 11), new Point(12, 11),
				new Point(12, 10), new Point(12, 9), new Point(12, 8),
				new Point(12, 7), new Point(11, 7), new Point(10, 7),
				new Point(10, 6), new Point(9, 6), new Point(8, 6),
				new Point(8, 5), new Point(8, 4), new Point(8, 3),
				new Point(9, 3), new Point(10, 3), new Point(10, 2),
				new Point(10, 1), new Point(10, 0), });

		waypoints.add(new Point[] { new Point(12, 0), new Point(12, 1),
				new Point(12, 2), new Point(12, 3), new Point(13, 3),
				new Point(14, 3), new Point(14, 4), new Point(14, 5),
				new Point(15, 5), new Point(16, 5), new Point(16, 6),
				new Point(16, 7), new Point(17, 7), new Point(18, 7),
				new Point(19, 7), new Point(19, 8), new Point(19, 9),
				new Point(19, 10), new Point(19, 11), new Point(19, 12),
				new Point(19, 13), new Point(19, 14), new Point(19, 15),
				new Point(19, 16), new Point(19, 17), new Point(20, 17),
				new Point(21, 17), new Point(21, 18), new Point(21, 19), });

		waypoints.add(new Point[] { new Point(33, 4), new Point(32, 4),
				new Point(31, 4), new Point(30, 4), new Point(29, 4),
				new Point(29, 5), new Point(29, 6), new Point(29, 7),
				new Point(29, 8), new Point(29, 9), new Point(28, 9),
				new Point(28, 10), new Point(28, 11), new Point(27, 11),
				new Point(26, 11), new Point(25, 11), new Point(25, 10),
				new Point(24, 10), new Point(23, 10), new Point(22, 10),
				new Point(21, 10), new Point(20, 10), new Point(19, 10),
				new Point(19, 11), new Point(19, 12), new Point(19, 13),
				new Point(19, 14), new Point(19, 15), new Point(19, 16),
				new Point(19, 17), new Point(20, 17), new Point(21, 17),
				new Point(21, 18), new Point(21, 19), });

		waypoints.add(new Point[] { new Point(29, 19), new Point(29, 18),
				new Point(29, 17), new Point(29, 16), new Point(28, 16),
				new Point(28, 15), new Point(28, 14), new Point(28, 13),
				new Point(28, 12), new Point(28, 11), new Point(27, 11),
				new Point(26, 11), new Point(25, 11), new Point(25, 10),
				new Point(24, 10), new Point(23, 10), new Point(22, 10),
				new Point(21, 10), new Point(20, 10), new Point(19, 10),
				new Point(19, 11), new Point(19, 12), new Point(19, 13),
				new Point(19, 14), new Point(19, 15), new Point(19, 16),
				new Point(19, 17), new Point(20, 17), new Point(21, 17),
				new Point(21, 18), new Point(21, 19), });

		// 18 - 21
		// 6 waves
		
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
				new Wave(10, 10, 6, 120, 3f, sprites[18], waypoints.get(0),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[19], waypoints.get(4),
						player, waveManager, 10, 1),
				new Wave(10, 20, 6, 120, 3f, sprites[20], waypoints.get(2),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[19], waypoints.get(5),
						player, waveManager, 10, 1),
				new Wave(10, 30, 6, 120, 3f, sprites[18], waypoints.get(1),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[19], waypoints.get(3),
						player, waveManager, 10, 1),
						
				new Wave(10, 50, 6, 120, 3f, sprites[18], waypoints.get(0),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[19], waypoints.get(4),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[20], waypoints.get(2),
						player, waveManager, 10, 1),
				new Wave(10, 70, 6, 120, 3f, sprites[19], waypoints.get(5),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[18], waypoints.get(1),
						player, waveManager, 10, 1),
				new Wave(10, 0, 6, 120, 3f, sprites[20], waypoints.get(2),
						player, waveManager, 10, 1),
						
				new Wave(1, 80, 4, 2000, 1f, sprites[21], waypoints.get(3),
						player, waveManager, 10, 10),		
						
				};

	}
}