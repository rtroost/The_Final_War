package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map10 extends Map {

	public Map10(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[32][0] = true;
		data[33][0] = true;
		data[32][1] = true;
		data[33][1] = true;
		data[2][3] = true;
		data[3][3] = true;
		data[14][3] = true;
		data[17][3] = true;
		data[29][3] = true;
		data[30][3] = true;
		data[31][3] = true;
		data[2][4] = true;
		data[3][4] = true;
		data[14][4] = true;
		data[15][4] = true;
		data[8][5] = true;
		data[9][5] = true;
		data[11][5] = true;
		data[12][5] = true;
		data[14][5] = true;
		data[15][5] = true;
		data[23][5] = true;
		data[24][5] = true;
		data[29][5] = true;
		data[30][5] = true;
		data[8][6] = true;
		data[9][6] = true;
		data[11][6] = true;
		data[12][6] = true;
		data[14][6] = true;
		data[15][6] = true;
		data[16][6] = true;
		data[20][6] = true;
		data[21][6] = true;
		data[22][6] = true;
		data[23][6] = true;
		data[24][6] = true;
		data[29][6] = true;
		data[30][6] = true;
		data[20][7] = true;
		data[21][7] = true;
		data[22][7] = true;
		data[13][8] = true;
		data[14][8] = true;
		data[20][8] = true;
		data[21][8] = true;
		data[24][8] = true;
		data[25][8] = true;
		data[27][8] = true;
		data[28][8] = true;
		data[29][8] = true;
		data[30][8] = true;
		data[32][8] = true;
		data[33][8] = true;
		data[2][9] = true;
		data[3][9] = true;
		data[9][9] = true;
		data[10][9] = true;
		data[11][9] = true;
		data[13][9] = true;
		data[14][9] = true;
		data[17][9] = true;
		data[18][9] = true;
		data[21][9] = true;
		data[23][9] = true;
		data[24][9] = true;
		data[25][9] = true;
		data[27][9] = true;
		data[28][9] = true;
		data[29][9] = true;
		data[30][9] = true;
		data[32][9] = true;
		data[33][9] = true;
		data[2][10] = true;
		data[3][10] = true;
		data[8][10] = true;
		data[9][10] = true;
		data[10][10] = true;
		data[11][10] = true;
		data[13][10] = true;
		data[14][10] = true;
		data[17][10] = true;
		data[18][10] = true;
		data[21][10] = true;
		data[23][10] = true;
		data[24][10] = true;
		data[25][10] = true;
		data[27][10] = true;
		data[28][10] = true;
		data[29][10] = true;
		data[30][10] = true;
		data[24][11] = true;
		data[28][11] = true;
		data[29][11] = true;
		data[30][11] = true;
		data[31][11] = true;
		data[8][12] = true;
		data[9][12] = true;
		data[10][12] = true;
		data[11][12] = true;
		data[12][12] = true;
		data[13][12] = true;
		data[14][12] = true;
		data[15][12] = true;
		data[17][12] = true;
		data[18][12] = true;
		data[28][12] = true;
		data[8][13] = true;
		data[9][13] = true;
		data[10][13] = true;
		data[11][13] = true;
		data[12][13] = true;
		data[13][13] = true;
		data[14][13] = true;
		data[15][13] = true;
		data[24][13] = true;
		data[25][13] = true;
		data[26][13] = true;
		data[28][13] = true;
		data[10][14] = true;
		data[11][14] = true;
		data[12][14] = true;
		data[13][14] = true;
		data[17][14] = true;
		data[18][14] = true;
		data[19][14] = true;
		data[20][14] = true;
		data[0][15] = true;
		data[1][15] = true;
		data[2][15] = true;
		data[10][15] = true;
		data[11][15] = true;
		data[12][15] = true;
		data[13][15] = true;
		data[16][15] = true;
		data[17][15] = true;
		data[18][15] = true;
		data[19][15] = true;
		data[20][15] = true;
		data[0][16] = true;
		data[1][16] = true;
		data[2][16] = true;
		data[3][16] = true;
		data[4][16] = true;
		data[0][17] = true;
		data[1][17] = true;
		data[2][17] = true;
		data[3][17] = true;
		data[4][17] = true;
		data[0][18] = true;
		data[1][18] = true;
		data[2][18] = true;
		data[3][18] = true;
		data[4][18] = true;
		data[10][18] = true;
		data[11][18] = true;
		data[32][18] = true;
		data[33][18] = true;
		data[0][19] = true;
		data[1][19] = true;
		data[2][19] = true;
		data[3][19] = true;
		data[32][19] = true;
		data[33][19] = true;

		startPositions = new Point[] { new Point(7, 1), new Point(1, 2),
				new Point(29, 17), new Point(17, 18), new Point(6, 9),
				new Point(30, 1), new Point(15, 10), new Point(9, 15),
				new Point(24, 17), new Point(9, 3), };

		// 19 waves

		waypoints.add(new Point[] { new Point(0, 5), new Point(1, 5),
				new Point(2, 5), new Point(3, 5), new Point(4, 5),
				new Point(5, 5), new Point(5, 6), new Point(5, 7),
				new Point(6, 7), new Point(7, 7), new Point(8, 7),
				new Point(9, 7), new Point(10, 7), new Point(11, 7),
				new Point(12, 7), new Point(12, 8), new Point(12, 9),
				new Point(12, 10), new Point(12, 11), new Point(13, 11),
				new Point(14, 11), new Point(15, 11), new Point(16, 11),
				new Point(16, 12), new Point(16, 13), new Point(16, 14),
				new Point(15, 14), new Point(14, 14), new Point(14, 15),
				new Point(14, 16), new Point(14, 17), new Point(14, 18),
				new Point(14, 19), });

		waypoints.add(new Point[] { new Point(0, 9), new Point(1, 9),
				new Point(1, 10), new Point(1, 11), new Point(1, 12),
				new Point(1, 13), new Point(2, 13), new Point(3, 13),
				new Point(4, 13), new Point(5, 13), new Point(6, 13),
				new Point(6, 12), new Point(6, 11), new Point(7, 11),
				new Point(8, 11), new Point(9, 11), new Point(10, 11),
				new Point(11, 11), new Point(12, 11), new Point(13, 11),
				new Point(14, 11), new Point(15, 11), new Point(16, 11),
				new Point(17, 11), new Point(18, 11), new Point(19, 11),
				new Point(20, 11), new Point(21, 11), new Point(21, 12),
				new Point(21, 13), new Point(21, 14), new Point(21, 15),
				new Point(21, 16), new Point(21, 17), new Point(21, 18),
				new Point(21, 19), });

		waypoints.add(new Point[] { new Point(0, 11), new Point(1, 11),
				new Point(2, 11), new Point(3, 11), new Point(4, 11),
				new Point(5, 11), new Point(6, 11), new Point(6, 12),
				new Point(6, 13), new Point(5, 13), new Point(4, 13),
				new Point(3, 13), new Point(2, 13), new Point(1, 13),
				new Point(1, 12), new Point(1, 11), new Point(2, 11),
				new Point(3, 11), new Point(4, 11), new Point(5, 11),
				new Point(6, 11), new Point(6, 12), new Point(6, 13),
				new Point(6, 14), new Point(6, 15), new Point(6, 16),
				new Point(6, 17), new Point(6, 18), new Point(6, 19), });

		waypoints.add(new Point[] { new Point(7, 19), new Point(7, 18),
				new Point(7, 17), new Point(7, 16), new Point(7, 15),
				new Point(7, 14), new Point(7, 13), new Point(7, 12),
				new Point(7, 11), new Point(8, 11), new Point(9, 11),
				new Point(10, 11), new Point(11, 11), new Point(12, 11),
				new Point(12, 10), new Point(12, 9), new Point(12, 8),
				new Point(12, 7), new Point(13, 7), new Point(13, 6),
				new Point(13, 5), new Point(13, 4), new Point(13, 3),
				new Point(13, 2), new Point(13, 1), new Point(13, 0), });

		waypoints.add(new Point[] { new Point(14, 19), new Point(14, 18),
				new Point(14, 17), new Point(14, 16), new Point(14, 15),
				new Point(14, 14), new Point(15, 14), new Point(16, 14),
				new Point(16, 13), new Point(16, 12), new Point(16, 11),
				new Point(17, 11), new Point(18, 11), new Point(19, 11),
				new Point(20, 11), new Point(21, 11), new Point(22, 11),
				new Point(22, 10), new Point(22, 9), new Point(22, 8),
				new Point(23, 8), new Point(23, 7), new Point(24, 7),
				new Point(25, 7), new Point(26, 7), new Point(27, 7),
				new Point(28, 7), new Point(29, 7), new Point(30, 7),
				new Point(31, 7), new Point(32, 7), new Point(33, 7), });

		waypoints.add(new Point[] { new Point(22, 19), new Point(22, 18),
				new Point(22, 17), new Point(22, 16), new Point(22, 15),
				new Point(22, 14), new Point(22, 13), new Point(22, 12),
				new Point(22, 11), new Point(21, 11), new Point(20, 11),
				new Point(19, 11), new Point(19, 10), new Point(19, 9),
				new Point(19, 8), new Point(19, 7), new Point(19, 6),
				new Point(19, 5), new Point(19, 4), new Point(19, 3),
				new Point(19, 2), new Point(19, 1), new Point(19, 0), });

		waypoints.add(new Point[] { new Point(27, 19), new Point(27, 18),
				new Point(27, 17), new Point(27, 16), new Point(27, 15),
				new Point(27, 14), new Point(27, 13), new Point(27, 12),

				new Point(26, 12), new Point(25, 12), new Point(24, 12),
				new Point(23, 12), new Point(22, 12), new Point(21, 12),
				new Point(21, 11),

				new Point(20, 11), new Point(19, 11), new Point(18, 11),
				new Point(17, 11), new Point(16, 11), new Point(15, 11),
				new Point(14, 11), new Point(13, 11), new Point(12, 11),

				new Point(12, 10), new Point(12, 9), new Point(12, 8),
				new Point(12, 7), new Point(11, 7), new Point(10, 7),
				new Point(9, 7), new Point(8, 7), new Point(7, 7),
				new Point(6, 7), new Point(5, 7), new Point(5, 6),
				new Point(5, 5), new Point(4, 5), new Point(3, 5),
				new Point(2, 5), new Point(1, 5), new Point(0, 5), });

		waypoints.add(new Point[] { new Point(33, 12), new Point(32, 12),
				new Point(31, 12), new Point(30, 12), new Point(29, 12),
				new Point(29, 13), new Point(29, 14), new Point(28, 14),
				new Point(27, 14), new Point(26, 14), new Point(25, 14),
				new Point(25, 15), new Point(24, 15), new Point(23, 15),
				new Point(22, 15), new Point(21, 15), new Point(21, 14),
				new Point(21, 13), new Point(20, 13), new Point(19, 13),
				new Point(19, 12), new Point(19, 11), new Point(20, 11),
				new Point(21, 11), new Point(21, 12), new Point(21, 13),
				new Point(21, 14), new Point(21, 15), new Point(21, 16),
				new Point(21, 17), new Point(21, 18), new Point(21, 19), });

		waypoints.add(new Point[] { new Point(33, 10), new Point(32, 10),
				new Point(31, 10), new Point(31, 9), new Point(31, 8),
				new Point(31, 7), new Point(30, 7), new Point(29, 7),
				new Point(28, 7), new Point(27, 7), new Point(26, 7),
				new Point(26, 8), new Point(26, 9), new Point(26, 10),
				new Point(26, 11), new Point(26, 12), new Point(25, 12),
				new Point(24, 12), new Point(23, 12), new Point(22, 12),
				new Point(21, 12), new Point(21, 13), new Point(21, 14),
				new Point(21, 15), new Point(21, 16), new Point(21, 17),
				new Point(21, 18), new Point(21, 19), });

		waypoints.add(new Point[] { new Point(33, 7), new Point(32, 7),
				new Point(31, 7), new Point(30, 7), new Point(29, 7),
				new Point(28, 7), new Point(27, 7), new Point(26, 7),
				new Point(25, 7), new Point(24, 7), new Point(23, 7),
				new Point(22, 8), new Point(22, 9), new Point(22, 10),
				new Point(22, 11), new Point(23, 11), new Point(23, 12),
				new Point(24, 12), new Point(25, 12), new Point(26, 12),
				new Point(27, 12), new Point(27, 13), new Point(27, 14),
				new Point(27, 15), new Point(27, 16), new Point(27, 17),
				new Point(27, 18), new Point(27, 19), });

		waypoints.add(new Point[] { new Point(28, 0), new Point(28, 1),
				new Point(28, 2), new Point(27, 2), new Point(27, 3),
				new Point(27, 4), new Point(27, 5), new Point(26, 5),
				new Point(25, 5), new Point(25, 6), new Point(25, 7),
				new Point(24, 7), new Point(23, 7), new Point(23, 8),
				new Point(22, 8), new Point(22, 9), new Point(22, 10),
				new Point(22, 11), new Point(22, 12), new Point(22, 13),
				new Point(22, 14), new Point(22, 15), new Point(22, 16),
				new Point(22, 17), new Point(22, 18), new Point(22, 19), });

		waypoints.add(new Point[] { new Point(24, 0), new Point(24, 1),
				new Point(24, 2), new Point(25, 2), new Point(25, 3),
				new Point(26, 3), new Point(27, 3), new Point(28, 3),
				new Point(28, 4), new Point(28, 5), new Point(28, 6),
				new Point(28, 7), new Point(27, 7), new Point(26, 7),
				new Point(26, 8), new Point(26, 9), new Point(26, 10),
				new Point(26, 11), new Point(26, 12), new Point(25, 12),
				new Point(24, 12), new Point(23, 12), new Point(22, 12),
				new Point(21, 12), new Point(21, 13), new Point(21, 14),
				new Point(21, 15), new Point(21, 16), new Point(21, 17),
				new Point(21, 18), new Point(21, 19), });

		waypoints.add(new Point[] { new Point(22, 0), new Point(22, 1),
				new Point(22, 2), new Point(21, 2), new Point(20, 2),
				new Point(19, 2), new Point(18, 2), new Point(17, 2),
				new Point(16, 2), new Point(15, 2), new Point(14, 2),
				new Point(13, 2), new Point(12, 2), new Point(12, 3),
				new Point(12, 4), new Point(11, 4), new Point(10, 4),
				new Point(10, 5), new Point(10, 6), new Point(10, 7),
				new Point(10, 8), new Point(11, 8), new Point(12, 8),
				new Point(12, 9), new Point(12, 10), new Point(12, 11),
				new Point(11, 11), new Point(10, 11), new Point(9, 11),
				new Point(8, 11), new Point(7, 11), new Point(6, 11),
				new Point(6, 12), new Point(6, 13), new Point(6, 14),
				new Point(6, 15), new Point(6, 16), new Point(6, 17),
				new Point(6, 18), new Point(6, 19), });

		waypoints.add(new Point[] { new Point(19, 0), new Point(19, 1),
				new Point(19, 2), new Point(19, 3), new Point(19, 4),
				new Point(19, 5), new Point(19, 6), new Point(19, 7),
				new Point(19, 8), new Point(19, 9), new Point(19, 10),
				new Point(19, 11), new Point(19, 12), new Point(19, 13),
				new Point(18, 13), new Point(17, 13), new Point(16, 13),
				new Point(16, 14), new Point(15, 14), new Point(14, 14),
				new Point(14, 15), new Point(14, 16), new Point(14, 17),
				new Point(14, 18), new Point(14, 19), });

		waypoints.add(new Point[] { new Point(18, 0), new Point(18, 1),
				new Point(18, 2), new Point(18, 3), new Point(18, 4),
				new Point(18, 5), new Point(18, 6), new Point(18, 7),
				new Point(18, 8), new Point(17, 8), new Point(16, 8),
				new Point(16, 9), new Point(16, 10), new Point(16, 11),
				new Point(17, 11), new Point(18, 11), new Point(19, 11),
				new Point(19, 12), new Point(19, 13), new Point(20, 13),
				new Point(21, 13), new Point(21, 14), new Point(21, 15),
				new Point(21, 16), new Point(21, 17), new Point(21, 18),
				new Point(21, 19), });

		waypoints.add(new Point[] { new Point(16, 0), new Point(16, 1),
				new Point(16, 2), new Point(16, 3), new Point(16, 4),
				new Point(16, 5), new Point(17, 5), new Point(17, 6),
				new Point(17, 7), new Point(17, 8), new Point(16, 8),
				new Point(15, 8), new Point(15, 9), new Point(16, 9),
				new Point(16, 10), new Point(16, 11), new Point(16, 12),
				new Point(16, 13), new Point(16, 14), new Point(15, 14),
				new Point(14, 14), new Point(14, 15), new Point(14, 16),
				new Point(14, 17), new Point(14, 18), new Point(14, 19), });

		waypoints.add(new Point[] { new Point(13, 0), new Point(13, 1),
				new Point(13, 2), new Point(13, 3), new Point(13, 4),
				new Point(13, 5), new Point(13, 6), new Point(13, 7),
				new Point(12, 7), new Point(12, 8), new Point(12, 9),
				new Point(12, 10), new Point(12, 11), new Point(11, 11),
				new Point(10, 11), new Point(9, 11), new Point(8, 11),
				new Point(7, 11), new Point(7, 12), new Point(7, 13),
				new Point(7, 14), new Point(7, 15), new Point(7, 16),
				new Point(7, 17), new Point(7, 18), new Point(7, 19), });

		waypoints.add(new Point[] { new Point(8, 0), new Point(8, 1),
				new Point(8, 2), new Point(9, 2), new Point(10, 2),
				new Point(10, 3), new Point(10, 4), new Point(10, 5),
				new Point(10, 6), new Point(10, 7), new Point(10, 8),
				new Point(11, 8), new Point(12, 8), new Point(12, 9),
				new Point(12, 10), new Point(12, 11), new Point(13, 11),
				new Point(14, 11), new Point(15, 11), new Point(16, 11),
				new Point(17, 11), new Point(18, 11), new Point(19, 11),
				new Point(20, 11), new Point(21, 11), new Point(21, 12),
				new Point(21, 13), new Point(21, 14), new Point(21, 15),
				new Point(21, 16), new Point(21, 17), new Point(21, 18),
				new Point(21, 19), });

		waypoints.add(new Point[] { new Point(2, 0), new Point(2, 1),
				new Point(3, 1), new Point(4, 1), new Point(5, 1),
				new Point(5, 2), new Point(6, 2), new Point(6, 3),
				new Point(6, 4), new Point(7, 4), new Point(8, 4),
				new Point(9, 4), new Point(10, 4), new Point(11, 4),
				new Point(12, 4), new Point(13, 4), new Point(13, 5),
				new Point(13, 6), new Point(13, 7), new Point(12, 7),
				new Point(12, 8), new Point(12, 9), new Point(12, 10),
				new Point(12, 11), new Point(11, 11), new Point(10, 11),
				new Point(9, 11), new Point(8, 11), new Point(7, 11),
				new Point(6, 11), new Point(6, 12), new Point(6, 13),
				new Point(6, 14), new Point(6, 15), new Point(6, 16),
				new Point(6, 17), new Point(6, 18), new Point(6, 19), });

		// 34 - 38
		// 37 en 38 is boss
		// 19 waves

		/** Amount of enemies */
		// 10,
		// /** Time between the last wave and this wave */
		// 10,
		// /** Spawn time between each enemy */
		// 5,
		// /** Health */
		// 10,
		// /** Speed multiplier */
		// 1f,
		// /** Texture for this enemy */
		// sprites[1],
		// /** Way-points to walk on */
		// waypoints.get(0),
		// /** Reference to player */
		// player,
		// /** Reference to waveManager */
		// waveManager)

		waves = new Wave[] {
				new Wave(60, 10, 4, 160, 1.5f, sprites[34], waypoints.get(0),
						player, waveManager, 0, 1),
				new Wave(60, 15, 3, 160, 2f, sprites[35], waypoints.get(1),
						player, waveManager, 0, 1),
				new Wave(60, 20, 4, 160, 1.5f, sprites[36], waypoints.get(14),
						player, waveManager, 0, 1),
				new Wave(60, 0, 3, 160, 2f, sprites[35], waypoints.get(3),
						player, waveManager, 0, 1),
				new Wave(60, 25, 4, 160, 1.5f, sprites[34], waypoints.get(4),
						player, waveManager, 0, 1),
				new Wave(60, 30, 3, 160, 2f, sprites[36], waypoints.get(17),
						player, waveManager, 0, 1),
				new Wave(60, 35, 4, 160, 1.5f, sprites[34], waypoints.get(6),
						player, waveManager, 0, 1),
				new Wave(60, 0, 3, 160, 2f, sprites[35], waypoints.get(7),
						player, waveManager, 0, 1),
				new Wave(60, 40, 4, 160, 1.5f, sprites[35], waypoints.get(15),
						player, waveManager, 0, 1),
				new Wave(60, 45, 3, 160, 2f, sprites[36], waypoints.get(9),
						player, waveManager, 0, 1),
				new Wave(60, 0, 4, 160, 1.5f, sprites[34], waypoints.get(18),
						player, waveManager, 0, 1),
				new Wave(60, 50, 3, 160, 2f, sprites[34], waypoints.get(11),
						player, waveManager, 0, 1),
				new Wave(60, 55, 4, 160, 1.5f, sprites[36], waypoints.get(12),
						player, waveManager, 0, 1),
				new Wave(60, 60, 3, 160, 2f, sprites[35], waypoints.get(16),
						player, waveManager, 0, 1),
				new Wave(60, 65, 4, 160, 1.5f, sprites[35], waypoints.get(2),
						player, waveManager, 0, 1),
				new Wave(60, 70, 3, 160, 2f, sprites[34], waypoints.get(8),
						player, waveManager, 0, 1),
				new Wave(60, 0, 4, 160, 1.5f, sprites[36], waypoints.get(13),
						player, waveManager, 0, 1),
				new Wave(60, 75, 3, 160, 2f, sprites[35], waypoints.get(5),
						player, waveManager, 0, 1),
				new Wave(60, 80, 4, 160, 1.5f, sprites[34], waypoints.get(10),
						player, waveManager, 0, 1),
				
				new Wave(1, 10, 5, 6000, 0.5f, sprites[37], waypoints.get(7),
						player, waveManager, 0, 10),
				new Wave(1, 10, 5, 6000, 0.5f, sprites[38], waypoints.get(13),
						player, waveManager, 0, 10),
	
		};
	}
}