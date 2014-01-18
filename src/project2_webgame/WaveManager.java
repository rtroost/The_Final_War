package project2_webgame;

import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class WaveManager {

	Map map;

	Wave[] waves;

	int timer = 0;
	int waveCounter = 0;
	int killCounter = 0;

	Timer waveTimer;
	Timer ticker;

	AudioClip[] audio;

	private boolean running = true;

	public WaveManager(AudioClip[] audio) {
		this.audio = audio;

		ticker = new Timer();
		ticker.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (timer > 0) {
					timer--;
				}
			}
		}, 0, 1000);
	}

	public void setReferences(Map map) {
		this.map = map;
		this.waves = map.getWaves();
	}

	public ArrayList<Enemy> getAllEnemies() {
		ArrayList<Enemy> returnlist = new ArrayList<Enemy>();

		if (waves == null)
			return null;

		for (int i = 0; i < waves.length; i++) {
			Wave wave = waves[i];
			returnlist.addAll(wave.getEnemyList());
		}

		if (returnlist.isEmpty())
			return null;

		return returnlist;
	}	
	
	public void mapChange() {
		audio[0].stop();
		this.running = false;
	}

	public void run() {
		if (waves == null) {
			return;
		}

		/** Start the music loop */
		audio[0].loop();

		timer = waves[0].getDelay();

		waveTimer = new Timer();
		int delaySum = 0;
		for (int i = 0; i < waves.length; i++) {
			final Wave _w = waves[i];
			final int counter = i;
			final int delay = _w.getDelay();
			waveTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					_w.run();
					waveCounter++;

					if (!((counter + 1) == waves.length)) {
						int d = waves[counter + 1].getDelay();
						if (d > 0) {
							timer = waves[counter + 1].getDelay();
						}
					}
				}
			}, delaySum + (delay * 1000));
			delaySum += (delay * 1000);
		}
	}

	public void incredimentKillCounter() {
		this.killCounter++;
	}

	public void update(long delta) {
		if (!running)
			return;

		if (waves == null)
			return;

		for (int i = 0; i < waves.length; i++) {
			Wave w = waves[i];
			w.update(delta);
		}

		/** Check if everything is cleared */
		boolean finished = true;
		// Do running false and stop music
		for (Wave w : waves) {
			if (!w.getComplete())
				finished = false;
		}
		if (finished || !this.isRunning()) {
			this.running = false;
		}
	}

	public void paint(Graphics2D g) {
		if (!running)
			return;

		if (waves == null)
			return;

		for (int i = 0; i < waves.length; i++) {
			Wave w = waves[i];
			w.paint(g);
		}
	}

	public int getTimer() {
		return timer;
	}

	public int getWaveCounter() {
		return waveCounter;
	}

	public int getKillCounter() {
		return killCounter;
	}

	public boolean isRunning() {
		return running;
	}	
}
