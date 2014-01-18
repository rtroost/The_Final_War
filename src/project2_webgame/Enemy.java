package project2_webgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Enemy {

	private float x;
	private float y;
	private Point[] waypoint;
	private float ang = 0f;
	private int newwaypoint = 1;
	private static final int SIZE = 16;
	private float health;
	private float maxHealth;
	private float speedMultiplier;
	private Image[] enemyTex;

	private Wave waveRef;

	private static final int RUN = 0;
	private static final int DEAD = 1;
	private int STATE = RUN;
	private Timer deadtimer;
	private boolean enabled = true;
	private int timerCounter = 0;

	private boolean endReached = false;

	public Enemy(int _health, float _speedMultiplier, Image[] _enemyTex,
			Point[] _waypoint, Wave _waveRef) {
		this.waveRef = _waveRef;
		this.speedMultiplier = _speedMultiplier;
		this.maxHealth = _health;
		this.health = this.maxHealth;
		this.enemyTex = _enemyTex;
		this.waypoint = _waypoint;
		this.x = waypoint[0].x;
		this.y = waypoint[0].y;

		this.deadtimer = new Timer();
		deadtimer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				timerCounter++;
			}
		}, 0, 500);
	}

	public void doDamage(int damage) {
		this.health -= damage;
	}

	public void setStateDead() {
		setSTATE(DEAD);
		setTimerCounter(0);
	}

	public void paint(Graphics2D g) {
		if (enabled) {
			int xp = (int) (Playfield.TILE_SIZE * getX()) + 16;
			int yp = (int) (Playfield.TILE_SIZE * getY()) + 16;

			if(this.health >= 500){
				
				Font f = new Font ("Serif", Font.PLAIN, 12);
				g.setColor(Color.RED);
				f = new Font ("Sanserif", Font.BOLD, 14);
				g.setFont (f);
				g.drawString("BOSS", xp - 16 -3, yp - 20);
			}
			
			g.setColor(Color.RED);
			g.fillRect(xp - 16, yp - 2 - 16, Playfield.TILE_SIZE, 5);
			g.setColor(Color.GREEN);
			g.fillRect(xp - 16, yp - 2 - 16,
					(int) (Playfield.TILE_SIZE * (health / maxHealth)), 5);

			g.rotate(ang, xp, yp);
			g.drawImage(enemyTex[STATE], xp - (SIZE / 2) - 27, yp - (SIZE / 2)
					- 27, null);
			g.rotate(-ang, xp, yp);
		} else {
			int xp = (int) (Playfield.TILE_SIZE * getX()) + 16;
			int yp = (int) (Playfield.TILE_SIZE * getY()) + 16;
			g.drawImage(enemyTex[STATE], xp - (SIZE / 2) - 27, yp - (SIZE / 2)
					- 27, null);
		}
	}

	public void update(long delta) {
		if (enabled) {
			Point np = waypoint[newwaypoint];

			double nx = np.x - this.getX(), ny = np.y - this.getY();
			double distance = Math.hypot(nx * Playfield.TILE_SIZE, ny
					* Playfield.TILE_SIZE);
			if (distance >= 1) {
				move((float) (nx / distance) * delta
						* (0.03f * this.speedMultiplier),
						(float) (ny / distance) * delta
								* (0.03f * this.speedMultiplier));
			} else {
				this.x = np.x;
				this.y = np.y;
				if (newwaypoint == waypoint.length - 1) {
					endReached = true;
				} else {
					newwaypoint++;
				}
			}
		}
		if (STATE == DEAD && getTimerCounter() == 3) {
			delThis();
		}
	}

	public boolean move(float dx, float dy) {
		// work out what the new position of this entity will be
		float nx = getX() + dx;
		float ny = getY() + dy;

		// if it doesn't then change our position to the new position
		x = nx;
		y = ny;

		// and calculate the angle we're facing based on our last move
		ang = (float) (Math.atan2(dy, dx) - (Math.PI / 0.65));
		return true;
	}

	public void delThis() {
		waveRef.delEnemy(this);
	}

	public boolean getEndReached() {
		return endReached;
	}

	public float getHealth() {
		return health;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnable(boolean enabled) {
		this.enabled = enabled;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	private int getTimerCounter() {
		return timerCounter;
	}

	private void setTimerCounter(int timerCounter) {
		this.timerCounter = timerCounter;
	}

	public int getSTATE() {
		if (this.STATE == DEAD) {
			return 2;
		} else {
			return 1;
		}
	}

	private void setSTATE(int sTATE) {
		STATE = sTATE;
	}
}
