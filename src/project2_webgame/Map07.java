package project2_webgame;

import java.awt.Image;
import java.awt.Point;

public class Map07 extends Map {

	public Map07(Image[][] sprites) {
		super.sprites = sprites;
	}

	@Override
	public void doStuff() {

		data[14][1] = true;
		data[15][1] = true;
		data[14][2] = true;
		data[15][2] = true;
		data[18][2] = true;
		data[19][2] = true;
		data[7][3] = true;
		data[8][3] = true;
		data[18][3] = true;
		data[19][3] = true;
		data[7][4] = true;
		data[8][4] = true;
		data[13][7] = true;
		data[14][7] = true;
		data[15][7] = true;
		data[16][7] = true;
		data[17][7] = true;
		data[21][7] = true;
		data[22][7] = true;
		data[13][8] = true;
		data[14][8] = true;
		data[15][8] = true;
		data[16][8] = true;
		data[17][8] = true;
		data[21][8] = true;
		data[22][8] = true;
		data[13][9] = true;
		data[14][9] = true;
		data[16][9] = true;
		data[17][9] = true;
		data[5][10] = true;
		data[6][10] = true;
		data[13][10] = true;
		data[14][10] = true;
		data[15][10] = true;
		data[16][10] = true;
		data[17][10] = true;
		data[5][11] = true;
		data[6][11] = true;
		data[13][11] = true;
		data[14][11] = true;
		data[15][11] = true;
		data[16][11] = true;
		data[17][11] = true;
		data[21][14] = true;
		data[22][14] = true;
		data[6][15] = true;
		data[7][15] = true;
		data[21][15] = true;
		data[22][15] = true;
		data[6][16] = true;
		data[7][16] = true;
		
		startPositions = new Point[] { new Point(11, 3), new Point(4, 2),
				new Point(3, 8), new Point(7, 8), new Point(9, 13),
				new Point(2, 16), new Point(15, 16), new Point(26, 14),
				new Point(30, 8), new Point(23, 5), };


		waypoints.add(new Point[] { new Point(0, 4), new Point(1, 4),
				new Point(2, 4), new Point(3, 4), new Point(3, 5),
				new Point(4, 5), new Point(5, 5), new Point(6, 5),
				new Point(7, 5), new Point(8, 5), new Point(9, 5),
				new Point(10, 5), new Point(10, 6), new Point(10, 7),
				new Point(11, 7), new Point(12, 7), new Point(13, 7), });

		waypoints.add(new Point[] { new Point(0, 12), new Point(1, 12),
				new Point(2, 12), new Point(3, 12), new Point(4, 12),
				new Point(5, 12), new Point(6, 12), new Point(7, 12),
				new Point(8, 12), new Point(8, 11), new Point(8, 10),
				new Point(9, 10), new Point(10, 10), new Point(10, 9),
				new Point(11, 9), new Point(12, 9), });

		waypoints.add(new Point[] { new Point(5, 19), new Point(5, 18),
				new Point(5, 17), new Point(6, 17), new Point(7, 17),
				new Point(8, 17), new Point(8, 16), new Point(9, 16),
				new Point(10, 16), new Point(10, 15), new Point(11, 15),
				new Point(11, 14), new Point(11, 13), new Point(12, 13),
				new Point(13, 13), new Point(13, 12), new Point(13, 11), });

		waypoints.add(new Point[] { new Point(23, 19), new Point(23, 18),
				new Point(23, 17), new Point(23, 16), new Point(22, 16),
				new Point(21, 16), new Point(20, 16), new Point(20, 15),
				new Point(20, 14), new Point(20, 13), new Point(19, 13),
				new Point(18, 13), new Point(17, 13), new Point(17, 12),
				new Point(17, 11), });

		waypoints.add(new Point[] { new Point(33, 6), new Point(32, 6),
				new Point(31, 6), new Point(30, 6), new Point(29, 6),
				new Point(28, 6), new Point(27, 6), new Point(26, 6),
				new Point(26, 7), new Point(25, 7), new Point(25, 8),
				new Point(24, 8), new Point(23, 8), new Point(23, 9),
				new Point(22, 9), new Point(21, 9), new Point(20, 9),
				new Point(20, 10), new Point(19, 10), new Point(18, 10), });

		waypoints.add(new Point[] { new Point(25, 0), new Point(25, 1),
				new Point(24, 1), new Point(23, 1), new Point(23, 2),
				new Point(22, 2), new Point(22, 3), new Point(21, 3),
				new Point(20, 3), new Point(20, 4), new Point(19, 4),
				new Point(18, 4), new Point(18, 5), new Point(18, 6),
				new Point(17, 6), new Point(17, 7), });

		waypoints.add(new Point[] { new Point(13, 0), new Point(13, 1),
				new Point(13, 2), new Point(13, 3), new Point(14, 3),
				new Point(15, 3), new Point(15, 4), new Point(15, 5),
				new Point(15, 6), });
		
		// 22 - 25
		// 7 waves
		
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
				new Wave(6, 10, 5, 140, 2f, sprites[22], waypoints.get(0),
						player, waveManager, 12, 1),
				new Wave(6, 0, 5, 140, 2f, sprites[23], waypoints.get(4),
						player, waveManager, 12, 1),
				new Wave(6, 0, 5, 140, 2f, sprites[24], waypoints.get(2),
						player, waveManager, 12, 1),
				new Wave(6, 30, 5, 140, 2f, sprites[23], waypoints.get(5),
						player, waveManager, 12, 1),
				new Wave(6, 0, 5, 140, 2f, sprites[22], waypoints.get(1),
						player, waveManager, 12, 1),
				new Wave(6, 0, 5, 140, 2f, sprites[24], waypoints.get(3),
						player, waveManager, 12, 1),
				new Wave(6, 45, 5, 180, 2f, sprites[23], waypoints.get(6),
						player, waveManager, 12, 1),
				new Wave(10, 0, 5, 180, 3f, sprites[21], waypoints.get(3),
						player, waveManager, 12, 1),
						
				new Wave(10, 65, 6, 160, 2f, sprites[24], waypoints.get(0),
						player, waveManager, 12, 1),
				new Wave(10, 0, 6, 170, 2f, sprites[23], waypoints.get(2),
						player, waveManager, 12, 1),
				new Wave(15, 0, 6, 170, 3f, sprites[21], waypoints.get(1),
						player, waveManager, 12, 1),
						
				new Wave(10, 70, 4, 170, 2f, sprites[24], waypoints.get(5),
						player, waveManager, 12, 1),
				new Wave(10, 0, 4, 170, 2f, sprites[23], waypoints.get(3),
						player, waveManager, 12, 1),
				new Wave(15, 0, 4, 170, 3f, sprites[21], waypoints.get(4),
						player, waveManager, 12, 1),
						
				new Wave(1, 10, 6, 3000, 0.5f, sprites[25], waypoints.get(4),
						player, waveManager, 12, 10),		
						};
		
		
		
	}
}