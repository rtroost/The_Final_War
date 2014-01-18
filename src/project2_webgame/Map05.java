package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map05 extends Map {

	public Map05(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {
		data[16][2] = true;
		data[16][3] = true;
		data[20][3] = true;
		data[21][3] = true;
		data[22][3] = true;
		data[23][3] = true;
		data[24][3] = true;
		data[30][3] = true;
		data[7][4] = true;
		data[25][4] = true;
		data[30][4] = true;
		data[6][5] = true;
		data[7][5] = true;
		data[20][5] = true;
		data[21][5] = true;
		data[22][5] = true;
		data[23][5] = true;
		data[25][5] = true;
		data[30][5] = true;
		data[6][6] = true;
		data[7][6] = true;
		data[14][6] = true;
		data[15][6] = true;
		data[16][6] = true;
		data[17][6] = true;
		data[18][6] = true;
		data[21][6] = true;
		data[4][7] = true;
		data[6][7] = true;
		data[17][7] = true;
		data[21][7] = true;
		data[23][7] = true;
		data[25][7] = true;
		data[26][7] = true;
		data[27][7] = true;
		data[4][8] = true;
		data[9][8] = true;
		data[12][8] = true;
		data[13][8] = true;
		data[14][8] = true;
		data[15][8] = true;
		data[17][8] = true;
		data[21][8] = true;
		data[23][8] = true;
		data[26][8] = true;
		data[31][8] = true;
		data[1][9] = true;
		data[4][9] = true;
		data[9][9] = true;
		data[17][9] = true;
		data[21][9] = true;
		data[23][9] = true;
		data[24][9] = true;
		data[26][9] = true;
		data[31][9] = true;
		data[1][10] = true;
		data[4][10] = true;
		data[12][10] = true;
		data[17][10] = true;
		data[21][10] = true;
		data[23][10] = true;
		data[24][10] = true;
		data[26][10] = true;
		data[4][11] = true;
		data[12][11] = true;
		data[14][11] = true;
		data[15][11] = true;
		data[17][11] = true;
		data[30][11] = true;
		data[12][12] = true;
		data[14][12] = true;
		data[15][12] = true;
		data[26][12] = true;
		data[30][12] = true;
		data[7][13] = true;
		data[8][13] = true;
		data[9][13] = true;
		data[12][13] = true;
		data[14][13] = true;
		data[15][13] = true;
		data[26][13] = true;
		data[30][13] = true;
		data[5][14] = true;
		data[6][14] = true;
		data[7][14] = true;
		data[8][14] = true;
		data[17][14] = true;
		data[18][14] = true;
		data[19][14] = true;
		data[20][14] = true;
		data[21][14] = true;
		data[6][15] = true;
		data[10][15] = true;
		data[11][15] = true;
		data[12][15] = true;
		data[14][15] = true;
		data[15][15] = true;
		data[16][15] = true;
		data[17][15] = true;
		data[25][15] = true;
		data[6][16] = true;
		data[9][16] = true;
		data[10][16] = true;
		data[11][16] = true;
		data[12][16] = true;
		data[25][16] = true;
		data[6][17] = true;
		data[20][17] = true;
		data[29][17] = true;
		data[30][17] = true;
		data[31][17] = true;
		data[32][17] = true;
		data[20][18] = true;
		
		startPositions = new Point[] { new Point(5, 2), new Point(2, 8),
				new Point(13, 1), new Point(23, 1), new Point(10, 10),
				new Point(1, 14), new Point(6, 18), new Point(18, 17),
				new Point(29, 15), new Point(28, 8), };

		waypoints.add(new Point[] { new Point(2, 0), new Point(2, 1),
				new Point(2, 2), new Point(3, 2), new Point(3, 3),
				new Point(3, 4), new Point(2, 4), new Point(2, 5),
				new Point(2, 6), new Point(3, 6), new Point(4, 6),
				new Point(5, 6), new Point(5, 7), new Point(5, 8),
				new Point(5, 9), new Point(6, 9), new Point(7, 9),
				new Point(7, 10), new Point(7, 11), new Point(7, 12),
				new Point(6, 12), new Point(5, 12), new Point(4, 12),
				new Point(3, 12), new Point(3, 13), new Point(3, 14),
				new Point(3, 15), new Point(4, 15), new Point(5, 15),
				new Point(5, 16), new Point(5, 17), new Point(4, 17),
				new Point(3, 17), new Point(2, 17), new Point(2, 18),
				new Point(2, 19), });

		waypoints.add(new Point[] { new Point(10, 0), new Point(10, 1),
				new Point(10, 2), new Point(9, 2), new Point(8, 2),
				new Point(8, 3), new Point(8, 4), new Point(8, 5),
				new Point(9, 5), new Point(10, 5), new Point(11, 5),
				new Point(12, 5), new Point(13, 5), new Point(13, 6),
				new Point(13, 7), new Point(14, 7), new Point(15, 7),
				new Point(16, 7), new Point(16, 8), new Point(16, 9),
				new Point(16, 10), new Point(15, 10), new Point(14, 10),
				new Point(13, 10), new Point(13, 11), new Point(13, 12),
				new Point(13, 13), new Point(13, 14), new Point(13, 15),
				new Point(13, 16), new Point(14, 16), new Point(15, 16),
				new Point(15, 17), new Point(15, 18), new Point(15, 19), });

		waypoints.add(new Point[] { new Point(19, 0), new Point(19, 1),
				new Point(19, 2), new Point(19, 3), new Point(19, 4),
				new Point(20, 4), new Point(21, 4), new Point(22, 4),
				new Point(23, 4), new Point(24, 4), new Point(24, 5),
				new Point(24, 6), new Point(24, 7), new Point(24, 8),
				new Point(25, 8), new Point(25, 9), new Point(25, 10),
				new Point(25, 11), new Point(26, 11), new Point(27, 11),
				new Point(27, 12), new Point(27, 13), new Point(27, 14),
				new Point(26, 14), new Point(25, 14), new Point(24, 14),
				new Point(24, 15), new Point(24, 16), new Point(24, 17),
				new Point(25, 17), new Point(26, 17), new Point(27, 17),
				new Point(28, 17), new Point(28, 18), new Point(28, 19), });

		waypoints.add(new Point[] { new Point(10, 19), new Point(10, 18),
				new Point(10, 17), new Point(9, 17), new Point(8, 17),
				new Point(8, 16), new Point(8, 15), new Point(9, 15),
				new Point(9, 14), new Point(10, 14), new Point(11, 14),
				new Point(12, 14), new Point(13, 14), new Point(14, 14),
				new Point(15, 14), new Point(16, 14), new Point(16, 13),
				new Point(16, 12), new Point(17, 12), new Point(18, 12),
				new Point(19, 12), new Point(19, 11), new Point(20, 11),
				new Point(21, 11), new Point(22, 11), new Point(22, 10),
				new Point(22, 9), new Point(22, 8), new Point(22, 7),
				new Point(22, 6), new Point(23, 6), new Point(24, 6),
				new Point(25, 6), new Point(26, 6), new Point(27, 6),
				new Point(28, 6), new Point(29, 6), new Point(30, 6),
				new Point(31, 6), new Point(31, 5), new Point(31, 4),
				new Point(31, 3), new Point(31, 2), new Point(30, 2),
				new Point(29, 2), new Point(28, 2), new Point(28, 1),
				new Point(28, 0), });
		
		
		//14 - 17
		
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
				new Wave(10, 10, 4, 100, 3f, sprites[14], waypoints.get(0),
						player, waveManager, 8, 1),
				new Wave(10, 15, 4, 100, 3f, sprites[15], waypoints.get(1),
						player, waveManager, 8, 1),
				new Wave(10, 20, 4, 100, 3f, sprites[16], waypoints.get(2),
						player, waveManager, 8, 1),
				new Wave(10, 25, 4, 100, 4f, sprites[14], waypoints.get(3),
						player, waveManager, 8, 1),
						
		
				new Wave(20, 40, 4, 100, 2f, sprites[15], waypoints.get(0),
						player, waveManager, 8, 1),
				new Wave(20, 0, 4, 100, 2f, sprites[16], waypoints.get(1),
						player, waveManager, 8, 1),
				new Wave(20, 0, 4, 100, 2f, sprites[14], waypoints.get(2),
						player, waveManager, 8, 1),
				new Wave(20, 0, 4, 100, 2f, sprites[15], waypoints.get(3),
						player, waveManager, 8, 1),
						
		
				new Wave(15, 100, 5, 200, 1f, sprites[16], waypoints.get(0),
						player, waveManager, 8, 1),
				new Wave(1, 0, 4, 1200, 1f, sprites[17], waypoints.get(1),
						player, waveManager, 150, 10),
				new Wave(15, 0, 5, 200, 2f, sprites[14], waypoints.get(3),
						player, waveManager, 8, 1),
						};

	}
}