package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map02 extends Map {

	public Map02(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[8][3] = true;
		data[9][3] = true;
		data[8][4] = true;
		data[9][4] = true;
		data[17][4] = true;
		data[18][4] = true;
		data[19][4] = true;
		data[20][4] = true;
		data[21][4] = true;
		data[22][4] = true;
		data[23][4] = true;
		data[24][4] = true;
		data[8][5] = true;
		data[9][5] = true;
		data[17][5] = true;
		data[18][5] = true;
		data[19][5] = true;
		data[20][5] = true;
		data[21][5] = true;
		data[22][5] = true;
		data[23][5] = true;
		data[24][5] = true;
		data[8][6] = true;
		data[9][6] = true;
		data[8][7] = true;
		data[9][7] = true;
		data[8][8] = true;
		data[9][8] = true;
		data[8][9] = true;
		data[9][9] = true;
		data[8][10] = true;
		data[9][10] = true;
		data[15][10] = true;
		data[16][10] = true;
		data[17][10] = true;
		data[21][10] = true;
		data[22][10] = true;
		data[23][10] = true;
		data[24][10] = true;
		data[8][11] = true;
		data[9][11] = true;
		data[15][11] = true;
		data[16][11] = true;
		data[17][11] = true;
		data[20][11] = true;
		data[21][11] = true;
		data[22][11] = true;
		data[23][11] = true;
		data[24][11] = true;
		data[8][12] = true;
		data[9][12] = true;
		data[15][12] = true;
		data[16][12] = true;
		data[17][12] = true;
		data[20][12] = true;
		data[21][12] = true;
		data[22][12] = true;
		data[23][12] = true;
		data[24][12] = true;
		data[20][13] = true;
		data[21][13] = true;
		data[22][13] = true;
		data[23][13] = true;
		data[24][13] = true;
		data[20][14] = true;
		data[21][14] = true;
		data[22][14] = true;
		data[23][14] = true;
		data[24][14] = true;
		data[20][15] = true;
		data[21][15] = true;
		data[22][15] = true;
		data[23][15] = true;
		data[24][15] = true;
		data[20][16] = true;
		data[21][16] = true;
		data[22][16] = true;
		data[23][16] = true;
		data[24][16] = true;
		data[25][16] = true;
		data[26][16] = true;
		data[27][16] = true;
		data[20][17] = true;
		data[21][17] = true;
		data[22][17] = true;
		data[23][17] = true;
		data[24][17] = true;
		data[25][17] = true;
		data[26][17] = true;
		data[27][17] = true;
		
		startPositions = new Point[] { new Point(6, 4), new Point(19, 7),
				new Point(29, 12), new Point(14, 17), new Point(2, 18),
				new Point(2, 9), new Point(5, 2), new Point(14, 8),
				new Point(9, 1), new Point(10, 10), };


		waypoints.add(new Point[] { new Point(3, 0), new Point(3, 1),
				new Point(3, 2), new Point(3, 3), new Point(2, 3),
				new Point(1, 3), new Point(1, 4), new Point(1, 5),
				new Point(1, 6), new Point(2, 6), new Point(3, 6),
				new Point(4, 6), new Point(5, 6), new Point(6, 6),
				new Point(6, 7), new Point(6, 8), new Point(6, 9),
				new Point(5, 9), new Point(5, 10), new Point(5, 11),
				new Point(5, 12), new Point(4, 12), new Point(3, 12),
				new Point(3, 13), new Point(3, 14), new Point(3, 15),
				new Point(3, 16), new Point(4, 16), new Point(5, 16),
				new Point(6, 16), new Point(7, 16), new Point(8, 16),
				new Point(9, 16), new Point(10, 16), new Point(10, 17),
				new Point(10, 18), new Point(10, 19), });

		waypoints.add(new Point[] { new Point(17, 0), new Point(17, 1),
				new Point(17, 2), new Point(16, 2), new Point(15, 2),
				new Point(14, 2), new Point(13, 2), new Point(13, 3),
				new Point(13, 4), new Point(13, 5), new Point(13, 6),
				new Point(13, 7), new Point(12, 7), new Point(11, 7),
				new Point(11, 8), new Point(11, 9), new Point(12, 9),
				new Point(13, 9), new Point(14, 9), new Point(15, 9),
				new Point(16, 9), new Point(17, 9), new Point(18, 9),
				new Point(18, 10), new Point(18, 11), new Point(18, 12),
				new Point(18, 13), new Point(18, 14), new Point(18, 15),
				new Point(18, 16), new Point(18, 17), new Point(18, 18),
				new Point(18, 19), });

		waypoints.add(new Point[] { new Point(24, 0), new Point(24, 1),
				new Point(24, 2), new Point(25, 2), new Point(26, 2),
				new Point(27, 2), new Point(28, 2), new Point(28, 3),
				new Point(28, 4), new Point(28, 5), new Point(28, 6),
				new Point(28, 7), new Point(29, 7), new Point(30, 7),
				new Point(30, 8), new Point(30, 9), new Point(30, 10),
				new Point(29, 10), new Point(28, 10), new Point(27, 10),
				new Point(26, 10), new Point(26, 11), new Point(26, 12),
				new Point(26, 13), new Point(26, 14), new Point(27, 14),
				new Point(28, 14), new Point(29, 14), new Point(29, 15),
				new Point(29, 16), new Point(29, 17), new Point(29, 18),
				new Point(29, 19), });

		//4 - 6
		
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
//		waveManager),
		
		waves = new Wave[] {
				new Wave(10, 10, 5, 40, 2f, sprites[4], waypoints.get(0),
						player, waveManager, 5, 1),
				new Wave(10, 20, 5, 50, 1.5f, sprites[5], waypoints.get(1),
						player, waveManager, 5, 1),
				new Wave(5, 0, 5, 50, 2f, sprites[6], waypoints.get(2),
						player, waveManager, 5, 1),
				new Wave(10, 30, 5, 50, 2f, sprites[4], waypoints.get(0),
						player, waveManager, 5, 1),
				new Wave(5, 0, 5, 50, 1.5f, sprites[5], waypoints.get(2),
						player, waveManager, 5, 1),
				new Wave(1, 50, 5, 1000, 0.5f, sprites[3], waypoints.get(1),
						player, waveManager, 50, 10),
						};

	}
}