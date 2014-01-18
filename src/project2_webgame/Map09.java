package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map09 extends Map {

	public Map09(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[8][0] = true;
		data[9][0] = true;
		data[11][0] = true;
		data[12][0] = true;
		data[16][0] = true;
		data[17][0] = true;
		data[0][1] = true;
		data[1][1] = true;
		data[2][1] = true;
		data[8][1] = true;
		data[9][1] = true;
		data[11][1] = true;
		data[12][1] = true;
		data[14][1] = true;
		data[15][1] = true;
		data[16][1] = true;
		data[17][1] = true;
		data[0][2] = true;
		data[1][2] = true;
		data[2][2] = true;
		data[11][2] = true;
		data[12][2] = true;
		data[14][2] = true;
		data[15][2] = true;
		data[16][2] = true;
		data[17][2] = true;
		data[27][2] = true;
		data[28][2] = true;
		data[29][2] = true;
		data[30][2] = true;
		data[0][3] = true;
		data[1][3] = true;
		data[2][3] = true;
		data[14][3] = true;
		data[15][3] = true;
		data[16][3] = true;
		data[17][3] = true;
		data[22][4] = true;
		data[23][4] = true;
		data[29][4] = true;
		data[30][4] = true;
		data[31][4] = true;
		data[32][4] = true;
		data[11][6] = true;
		data[12][6] = true;
		data[13][6] = true;
		data[14][6] = true;
		data[30][6] = true;
		data[31][6] = true;
		data[0][7] = true;
		data[1][7] = true;
		data[4][7] = true;
		data[5][7] = true;
		data[6][7] = true;
		data[30][7] = true;
		data[31][7] = true;
		data[4][8] = true;
		data[5][8] = true;
		data[6][8] = true;
		data[11][8] = true;
		data[12][8] = true;
		data[17][8] = true;
		data[4][9] = true;
		data[5][9] = true;
		data[6][9] = true;
		data[11][9] = true;
		data[12][9] = true;
		data[16][9] = true;
		data[17][9] = true;
		data[16][10] = true;
		data[17][10] = true;
		data[26][10] = true;
		data[31][10] = true;
		data[32][10] = true;
		data[3][11] = true;
		data[18][11] = true;
		data[19][11] = true;
		data[20][11] = true;
		data[31][11] = true;
		data[32][11] = true;
		data[33][11] = true;
		data[18][12] = true;
		data[19][12] = true;
		data[20][12] = true;
		data[25][12] = true;
		data[26][12] = true;
		data[9][13] = true;
		data[18][13] = true;
		data[19][13] = true;
		data[20][13] = true;
		data[4][14] = true;
		data[5][14] = true;
		data[6][14] = true;
		data[11][14] = true;
		data[12][14] = true;
		data[4][15] = true;
		data[5][15] = true;
		data[6][15] = true;
		data[11][15] = true;
		data[12][15] = true;
		data[8][16] = true;
		data[9][16] = true;
		data[32][16] = true;
		data[33][16] = true;
		data[6][17] = true;
		data[7][17] = true;
		data[8][17] = true;
		data[9][17] = true;
		data[11][17] = true;
		data[12][17] = true;
		data[30][17] = true;
		data[31][17] = true;
		data[32][17] = true;
		data[33][17] = true;
		data[0][18] = true;
		data[1][18] = true;
		data[2][18] = true;
		data[6][18] = true;
		data[7][18] = true;
		data[8][18] = true;
		data[9][18] = true;
		data[23][18] = true;
		data[24][18] = true;
		data[25][18] = true;
		data[26][18] = true;
		data[30][18] = true;
		data[31][18] = true;
		data[32][18] = true;
		data[33][18] = true;
		data[0][19] = true;
		data[1][19] = true;
		data[2][19] = true;
		data[6][19] = true;
		data[7][19] = true;
		data[8][19] = true;
		data[9][19] = true;
		data[23][19] = true;
		data[24][19] = true;
		data[25][19] = true;
		data[26][19] = true;
		data[30][19] = true;
		data[31][19] = true;
		data[32][19] = true;
		data[33][19] = true;

		startPositions = new Point[] { new Point(5, 5), new Point(11, 4),
				new Point(2, 9), new Point(7, 11), new Point(15, 16),
				new Point(26, 14), new Point(22, 8), new Point(23, 14),
				new Point(26, 4), new Point(19, 4), };
		

		waypoints.add(new Point[] { new Point(10, 0), new Point(10, 1),
				new Point(10, 2), new Point(9, 2), new Point(8, 2),
				new Point(7, 2), new Point(6, 2), new Point(5, 2),
				new Point(4, 2), new Point(3, 2), new Point(2, 2), });

		waypoints.add(new Point[] { new Point(13, 0), new Point(13, 1),
				new Point(13, 2), new Point(13, 3), new Point(12, 3),
				new Point(11, 3), new Point(10, 3), new Point(9, 3),
				new Point(8, 3), new Point(7, 3), new Point(6, 3),
				new Point(5, 3), new Point(4, 3), new Point(3, 3),
				new Point(2, 3), });

		waypoints.add(new Point[] { new Point(21, 0), new Point(21, 1),
				new Point(20, 1), new Point(19, 1), new Point(18, 1),
				new Point(18, 2), new Point(18, 3), new Point(19, 3),
				new Point(20, 3), new Point(21, 3), new Point(22, 3),
				new Point(23, 3), new Point(24, 3), new Point(24, 4),
				new Point(24, 5), new Point(23, 5), new Point(22, 5),
				new Point(21, 5), new Point(21, 6), new Point(20, 6),
				new Point(19, 6), new Point(18, 6), new Point(17, 6),
				new Point(17, 7), new Point(17, 8), new Point(16, 8),
				new Point(15, 8), new Point(14, 8), new Point(13, 8),
				new Point(13, 9), new Point(13, 10), new Point(12, 10),
				new Point(11, 10), new Point(10, 10), new Point(10, 9),
				new Point(10, 8), new Point(9, 8), new Point(8, 8),
				new Point(7, 8), new Point(6, 8), });

		waypoints.add(new Point[] { new Point(26, 0), new Point(26, 1),
				new Point(27, 1), new Point(28, 1), new Point(29, 1),
				new Point(30, 1), new Point(31, 1), new Point(31, 2),
				new Point(31, 3), new Point(30, 3), new Point(29, 3),
				new Point(28, 3), new Point(28, 4), new Point(28, 5),
				new Point(29, 5), new Point(30, 5), new Point(31, 5),
				new Point(32, 5), new Point(32, 6), new Point(32, 7),
				new Point(32, 8), new Point(31, 8), new Point(30, 8),
				new Point(29, 8), new Point(28, 8), new Point(27, 8),
				new Point(26, 8), new Point(26, 9), });

		waypoints.add(new Point[] { new Point(5, 19), new Point(5, 18),
				new Point(5, 17), new Point(5, 16), new Point(4, 16),
				new Point(3, 16), new Point(3, 15), new Point(3, 14),
				new Point(3, 13), new Point(3, 12), });

		waypoints.add(new Point[] { new Point(16, 19), new Point(16, 18),
				new Point(15, 18), new Point(14, 18), new Point(13, 18),
				new Point(12, 18), new Point(11, 18), new Point(10, 18),
				new Point(10, 17), new Point(10, 16), new Point(11, 16),
				new Point(12, 16), new Point(13, 16), new Point(13, 15),
				new Point(13, 14), new Point(13, 13), new Point(12, 13),
				new Point(11, 13), new Point(10, 13), });

		waypoints.add(new Point[] { new Point(27, 19), new Point(27, 18),
				new Point(27, 17), new Point(26, 17), new Point(25, 17),
				new Point(24, 17), new Point(23, 17), new Point(22, 17),
				new Point(21, 17), new Point(20, 17), new Point(19, 17),
				new Point(19, 16), new Point(19, 15), new Point(19, 14),
				new Point(19, 13), });

		waypoints.add(new Point[] { new Point(28, 19), new Point(28, 18),
				new Point(28, 17), new Point(28, 16), new Point(27, 16),
				new Point(26, 16), new Point(25, 16), new Point(24, 16),
				new Point(23, 16), new Point(22, 16), new Point(20, 16),
				new Point(20, 15), new Point(20, 14), new Point(20, 13), });
		
		// 30 - 33
		// 9 waves
		
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
				new Wave(6, 10, 5, 180, 2f, sprites[30], waypoints.get(0),
						player, waveManager, 15, 1),
				new Wave(6, 0, 5, 160, 2f, sprites[31], waypoints.get(4),
						player, waveManager, 15, 1),
				new Wave(6, 0, 5, 160, 2f, sprites[32], waypoints.get(2),
						player, waveManager, 15, 1),
				new Wave(6, 20, 5, 160, 2f, sprites[30], waypoints.get(5),
						player, waveManager, 15, 1),
				new Wave(6, 0, 5, 180, 2f, sprites[32], waypoints.get(1),
						player, waveManager, 15, 1),
				new Wave(6, 0, 5, 160, 2f, sprites[31], waypoints.get(3),
						player, waveManager, 15, 1),
				new Wave(6, 0, 5, 160, 2f, sprites[31], waypoints.get(6),
						player, waveManager, 15, 1),
				new Wave(8, 30, 5, 160, 2f, sprites[30], waypoints.get(3),
						player, waveManager, 15, 1),
				new Wave(8, 0, 5, 160, 2f, sprites[32], waypoints.get(7),
						player, waveManager, 15, 1),
				new Wave(8, 0, 5, 160, 2f, sprites[32], waypoints.get(4),
						player, waveManager, 15, 1),
						
				new Wave(10, 60, 5, 180, 2f, sprites[30], waypoints.get(0),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 170, 2f, sprites[31], waypoints.get(4),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 170, 2f, sprites[32], waypoints.get(2),
						player, waveManager, 15, 1),
				new Wave(10, 70, 5, 170, 2f, sprites[30], waypoints.get(5),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 180, 2f, sprites[32], waypoints.get(1),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 170, 2f, sprites[31], waypoints.get(3),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 170, 2f, sprites[31], waypoints.get(6),
						player, waveManager, 15, 1),
				new Wave(10, 80, 5, 170, 3f, sprites[30], waypoints.get(3),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 170, 3f, sprites[32], waypoints.get(7),
						player, waveManager, 15, 1),
				new Wave(10, 0, 5, 170, 3f, sprites[32], waypoints.get(2),
						player, waveManager, 15, 1),
						
				new Wave(1, 0, 6, 2500, 0.25f, sprites[33], waypoints.get(2),
						player, waveManager, 500, 5),
				new Wave(1, 0, 6, 2500, 0.25f, sprites[33], waypoints.get(7),
						player, waveManager, 500, 5),
				new Wave(1, 0, 6, 2500, 0.25f, sprites[33], waypoints.get(1),
						player, waveManager, 500, 5),
						};

	}
}