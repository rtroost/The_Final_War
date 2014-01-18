package project2_webgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Wave {

	Player player;
	WaveManager waveManager;

	private int money;
	private int lives;

	private int numberOfEnemies, delay;
	private boolean running;
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private Timer t;

	private boolean complete = false;
	private int currentEnemy = 0;

	/** Enemy specifics */
	private Point[] waypoints;
	private int health;
	private float speedMultiplier;
	private Image[] enemyTex;
	private int timeBetweenSpawn;

	public Wave(int _numberOfEnemies, int _delay, int _timeBetweenSpawn,
			int _health, float _speedMultiplier, Image[] _enemyTex, Point[] _p,
			Player player, WaveManager waveManager, int money, int lives) {
		this.player = player;
		this.waveManager = waveManager;

		this.numberOfEnemies = _numberOfEnemies;
		this.delay = _delay;
		this.timeBetweenSpawn = _timeBetweenSpawn;
		this.health = _health;
		this.speedMultiplier = _speedMultiplier;
		this.enemyTex = _enemyTex;
		this.waypoints = _p;
		this.money = money;
		this.lives = lives;
	}

	public void run() {
		running = true;
		t = new Timer();
		for (int i = 0; i < numberOfEnemies; i++) {
			int delay = this.timeBetweenSpawn; // In seconds
			t.schedule(new TimerTask() {

				@Override
				public void run() {
					getEnemyList().add(
							new Enemy(health, speedMultiplier, enemyTex,
									waypoints, Wave.this));
					currentEnemy++;
				}
			}, (delay * 1000) * i);
		}
	}

	public void delEnemy(Enemy _e) {
		enemyList.remove(_e);
	}

	public void paint(Graphics2D g) {
		if (!running)
			return;

		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			
				e.paint(g);
		}
	}

	public void update(long delta) {
		if (!running)
			return;

		for (int i = 0; i < enemyList.size(); i++) {
			Enemy e = enemyList.get(i);
			e.update(delta);

			/** Check if he's dead */
			if (e.getHealth() <= 0 && e.getSTATE() != 2) {
				e.setStateDead();
				e.setEnable(false);
				player.incMoney(this.money);
				waveManager.incredimentKillCounter();
			}

			/** Check if he reached the end */
			if (e.getEndReached()) {
				e.setEnable(false);
				enemyList.remove(e);
				
				player.setLives(-this.lives);
			}
		}

		if (currentEnemy == numberOfEnemies && enemyList.isEmpty()) {
			this.complete = true;
		}
	}

	public boolean isEnabled() {
		return this.running;
	}

	public int getDelay() {
		return this.delay;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public boolean getComplete() {
		return this.complete;
	}
}
