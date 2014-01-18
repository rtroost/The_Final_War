package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map08 extends Map {

	public Map08(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[26][2] = true;
		data[27][2] = true;
		data[28][2] = true;
		data[3][3] = true;
		data[26][3] = true;
		data[27][3] = true;
		data[28][3] = true;
		data[15][4] = true;
		data[16][4] = true;
		data[26][4] = true;
		data[27][4] = true;
		data[28][4] = true;
		data[15][5] = true;
		data[16][5] = true;
		data[18][5] = true;
		data[19][5] = true;
		data[15][6] = true;
		data[16][6] = true;
		data[18][6] = true;
		data[19][6] = true;
		data[15][7] = true;
		data[16][7] = true;
		data[19][7] = true;
		data[20][7] = true;
		data[8][8] = true;
		data[9][8] = true;
		data[14][8] = true;
		data[15][8] = true;
		data[16][8] = true;
		data[17][8] = true;
		data[19][8] = true;
		data[20][8] = true;
		data[8][9] = true;
		data[9][9] = true;
		data[14][9] = true;
		data[15][9] = true;
		data[16][9] = true;
		data[17][9] = true;
		data[14][10] = true;
		data[15][10] = true;
		data[16][10] = true;
		data[17][10] = true;
		data[20][10] = true;
		data[21][10] = true;
		data[22][10] = true;
		data[8][11] = true;
		data[9][11] = true;
		data[10][11] = true;
		data[14][11] = true;
		data[15][11] = true;
		data[16][11] = true;
		data[17][11] = true;
		data[20][11] = true;
		data[21][11] = true;
		data[22][11] = true;
		data[8][12] = true;
		data[9][12] = true;
		data[10][12] = true;
		data[20][12] = true;
		data[21][12] = true;
		data[22][12] = true;
		data[10][13] = true;
		data[20][13] = true;
		data[21][13] = true;
		data[22][13] = true;
		data[10][14] = true;
		data[16][14] = true;
		data[17][14] = true;
		data[18][14] = true;
		data[19][14] = true;
		data[20][14] = true;
		data[21][14] = true;
		data[22][14] = true;
		data[10][15] = true;
		data[11][15] = true;
		data[12][15] = true;
		data[13][15] = true;
		data[14][15] = true;
		data[17][15] = true;
		data[18][15] = true;
		data[19][15] = true;
		data[20][15] = true;
		data[21][15] = true;
		data[22][15] = true;
		data[17][16] = true;
		data[18][16] = true;
		data[19][16] = true;
		data[28][16] = true;
		data[29][16] = true;
		data[5][17] = true;
		data[6][17] = true;
		data[28][17] = true;
		data[29][17] = true;
		data[5][18] = true;
		data[6][18] = true;
		
		startPositions = new Point[] { new Point(2, 3), new Point(6, 5),
				new Point(3, 8), new Point(6, 13), new Point(2, 16),
				new Point(12, 17), new Point(20, 7), new Point(25, 14),
				new Point(30, 7), new Point(21, 2), };



		// pad1 naar boven vanaf zeikant
		// pad2 naar beneden vanaf zeikant
		// pad3 naar boven
		// pad4 naar beneden
		// pad5+6 van zeikant naar beneden

		waypoints.add(new Point[] { new Point(14, 0), new Point(14, 1),
				new Point(14, 2), new Point(14, 3), new Point(14, 4),
				new Point(14, 5), new Point(14, 6), new Point(14, 7),
				new Point(13, 7), new Point(13, 8), new Point(13, 9),
				new Point(13, 10), new Point(13, 11), new Point(13, 12),
				new Point(14, 12), new Point(15, 12), new Point(16, 12),
				new Point(17, 12), new Point(18, 12), new Point(18, 11),
				new Point(18, 10), new Point(18, 9), new Point(18, 8),
				new Point(18, 7), new Point(17, 7), new Point(17, 6),
				new Point(17, 5), new Point(17, 4), new Point(17, 3),
				new Point(17, 2), new Point(17, 1), new Point(17, 0), });

		waypoints.add(new Point[] { new Point(13, 0), new Point(13, 1),
				new Point(13, 2), new Point(13, 3), new Point(13, 4),
				new Point(13, 5), new Point(13, 6), new Point(12, 6),
				new Point(12, 7), new Point(12, 8), new Point(12, 9),
				new Point(12, 10), new Point(12, 11), new Point(12, 12),
				new Point(12, 13), new Point(13, 13), new Point(14, 13),
				new Point(15, 13), new Point(16, 13), new Point(17, 13),
				new Point(18, 13), new Point(19, 13), new Point(19, 12),
				new Point(19, 11), new Point(19, 10), new Point(19, 9),
				new Point(20, 9), new Point(21, 9), new Point(22, 9),
				new Point(23, 9), new Point(24, 9), new Point(24, 8),
				new Point(24, 7), new Point(25, 7), new Point(26, 7),
				new Point(27, 7), new Point(27, 8), new Point(27, 9),
				new Point(27, 10), new Point(28, 10), new Point(29, 10),
				new Point(30, 10), new Point(31, 10), new Point(32, 10),
				new Point(33, 10), });

		waypoints.add(new Point[] { new Point(12, 0), new Point(12, 1),
				new Point(12, 2), new Point(12, 3), new Point(12, 4),
				new Point(12, 5), new Point(11, 5), new Point(11, 6),
				new Point(11, 7), new Point(11, 8), new Point(11, 9),
				new Point(11, 10), new Point(11, 11), new Point(11, 12),
				new Point(11, 13), new Point(11, 14), new Point(12, 14),
				new Point(13, 14), new Point(14, 14), new Point(15, 14),
				new Point(15, 15), new Point(15, 16), new Point(15, 17),
				new Point(15, 18), new Point(15, 19), });

		waypoints.add(new Point[] { new Point(11, 0), new Point(11, 1),
				new Point(11, 2), new Point(11, 3), new Point(11, 4),
				new Point(10, 4), new Point(10, 5), new Point(10, 6),
				new Point(10, 7), new Point(10, 8), new Point(10, 9),
				new Point(10, 10), new Point(9, 10), new Point(8, 10),
				new Point(7, 10), new Point(6, 10), new Point(5, 10),
				new Point(4, 10), new Point(4, 11), new Point(4, 12),
				new Point(4, 13), new Point(3, 13), new Point(2, 13),
				new Point(2, 12), new Point(2, 11), new Point(2, 10),
				new Point(1, 10), new Point(0, 10), });
		
		// 26 - 29
		// 4 waves
		
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
		
		// money = 15
		waves = new Wave[] {
				new Wave(10, 10, 5, 160, 2f, sprites[26], waypoints.get(0),
						player, waveManager, 13, 1),
				new Wave(10, 0, 5, 160, 2f, sprites[27], waypoints.get(2),
						player, waveManager, 13, 1),
				new Wave(15, 0, 5, 170, 2f, sprites[28], waypoints.get(1),
						player, waveManager, 13, 1),
				new Wave(15, 0, 5, 170, 2f, sprites[27], waypoints.get(3),
						player, waveManager, 13, 1),
						
				new Wave(15, 40, 5, 170, 2f, sprites[27], waypoints.get(3),
						player, waveManager, 13, 1),
				new Wave(15, 0, 5, 170, 2f, sprites[28], waypoints.get(2),
						player, waveManager, 13, 1),
				new Wave(15, 0, 5, 170, 2f, sprites[26], waypoints.get(1),
						player, waveManager, 13, 1),
				new Wave(15, 0, 5, 170, 2f, sprites[28], waypoints.get(0),
						player, waveManager, 13, 1),
						
				new Wave(40, 60, 3, 130, 4f, sprites[27], waypoints.get(0),
						player, waveManager, 13, 1),
				new Wave(40, 0, 3, 130, 4f, sprites[28], waypoints.get(3),
						player, waveManager, 13, 1),
				new Wave(40, 0, 3, 130, 4f, sprites[26], waypoints.get(1),
						player, waveManager, 13, 1),
				new Wave(40, 0, 3, 130, 4f, sprites[28], waypoints.get(2),
						player, waveManager, 13, 1),
						
				new Wave(1, 100, 6, 3000, 0.5f, sprites[29], waypoints.get(0),
						player, waveManager, 250, 5),
				new Wave(1, 0, 6, 3000, 0.5f, sprites[29], waypoints.get(1),
						player, waveManager, 250, 5),
				new Wave(1, 0, 6, 3000, 0.5f, sprites[29], waypoints.get(2),
						player, waveManager, 250, 5),
				new Wave(1, 0, 6, 3000, 0.5f, sprites[29], waypoints.get(3),
						player, waveManager, 250, 5),
						};

	}
}