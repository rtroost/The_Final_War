package project2_webgame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Unit implements Cloneable {

	Map map;
	WaveManager waveManager;
	Player player;
	/** Name of the unit */
	private String unitName;
	/** Small icon of the unit */
	private Image icon = null;
	/** Textures used for this unit */
	private Image[] spriteTex;
	/**
	 * Battle statistics of the unit: Strength, movement-speed, weapon-range and
	 * fire-rate
	 */
	private int dmg = 0;
	private int speed = 0;
	private int range = 0;
	private int fireRate = 0;
	// private int[] statistics = new int[] { 0, 0, 0, 0 };
	/** Is this unit enabled yet? */
	private Boolean enabled = false;
	/** Static stance modifiers */
	private static final int STAND = 0;
	private static final int RUN = 1;
	private static final int JUMP = 2;
	private static final int ATTACK = 3;
	/** Current visual state the unit is in */
	private int state = STAND;
	/** Current state of movement */
	private boolean isMoving = false;
	/** General size in pixels of the units */
	public static final int SIZE = 32;
	/** Coordinates of the unit in tiles (x * MapBase.TILE_SIZE) */
	private float x = 0f;
	private float y = 0f;
	/** Angle that the unit is in */
	private float ang;
	/** Target x and y we're moving towards */
	private int tx;
	private int ty;
	private Enemy target;
	private Timer timeToShoot;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

	float fl[] = { 12.0f };
	BasicStroke basicStroke = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
			BasicStroke.JOIN_MITER, 12.0f, fl, 0.0f);

	public Unit(String _unitName, int dmg, int speed, int range, int fireRate,
			Image[] _spritetex, Map map, WaveManager waveManager,
			Player player, int cooldown, int duration) {
		this.map = map;
		this.waveManager = waveManager;
		this.player = player;
		this.unitName = _unitName;
		this.dmg = dmg;
		this.speed = speed;
		this.range = range;
		this.fireRate = fireRate;
		// this.statistics = startStatistics;
		this.spriteTex = _spritetex;
	}

	public void setFireTimer() {

		if (this.timeToShoot != null) {
			this.timeToShoot.cancel();
		}

		this.timeToShoot = new Timer();

		int FireTimer = 0;
		if (this.fireRate > 5) {
			FireTimer = (1000 - (this.fireRate * 100)) + 200;
		} else {
			FireTimer = (1000 - (this.fireRate * 100)) + 100;
		}

		timeToShoot.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!isMoving && enabled) {
					fireBullet();
				}

			}
		}, 0, FireTimer);
	}

	public void setReferences(Map map, WaveManager waveManager, Player player) {
		this.map = map;
		this.waveManager = waveManager;
		this.player = player;
	}

	public void setPosition(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public void fireBullet() {
		if (!checkTarget()) {
			if (!aquireTarget()) {
				return;
			}
		}

		double nx = (this.x * Playfield.TILE_SIZE)
				- (target.getX() * Playfield.TILE_SIZE), ny = (this.y * Playfield.TILE_SIZE)
				- (target.getY() * Playfield.TILE_SIZE);
		double distance = Math.hypot(nx, ny);
		ang = (float) (Math.atan2((ny / distance), (nx / distance)) - (Math.PI / 2));

		state = ATTACK;

		if (this.unitName.equals("Martin L. King")
				|| this.unitName.equals("Prof. Stephen Hawking")) {
			target.doDamage(dmg * 15);
		} else {
			bullets.add(new Bullet(this.target, this.x, this.y, dmg,
					spriteTex[4], this));
		}
	}

	public void delBullet(Bullet b) {
		bullets.remove(b);
	}

	public void newPosition(int cx, int cy) {
		if (!map.isRoad(
				(cx - (cx % Playfield.TILE_SIZE)) / Playfield.TILE_SIZE,
				(cy - (cy % Playfield.TILE_SIZE)) / Playfield.TILE_SIZE)) {
			this.isMoving = true;
			state = RUN;
			tx = cx;
			ty = cy;
		}
	}

	public boolean checkDead() {
		if (target == null) {
			return true;
		}
		if (target.isEnabled() == false) {
			target = null;
			state = STAND;
			return true;
		}

		if (waveManager.getAllEnemies() != null && target != null
				&& waveManager.getAllEnemies().contains(target))
			return false;

		return true;
	}

	public boolean move(float dx, float dy) {

		// work out what the new position of this entity will be
		float nx = x + dx;
		float ny = y + dy;

		// check if the new position of the entity collides with
		// anything
		if (map.isRoad(nx, ny)) {
			/** Change to jumping state */
			state = JUMP;
		} else {
			/** Change back */
			state = RUN;
		}
		x = nx;
		y = ny;

		// and calculate the angle we're facing based on our last move
		ang = (float) (Math.atan2(dy, dx) - (Math.PI / 0.65));
		return true;
	}

	private boolean aquireTarget() {
		/** Get a new target */
		ArrayList<Enemy> allEnemies = waveManager.getAllEnemies();

		if (allEnemies == null)
			return false;

		int shortestDistance = 0;
		for (int i = 0; i < allEnemies.size(); i++) {
			Enemy e = allEnemies.get(i);
			if (e.isEnabled()) {
				double cx = Math.abs((this.x * Playfield.TILE_SIZE)
						- (e.getX() * Playfield.TILE_SIZE)), cy = Math
						.abs((this.y * Playfield.TILE_SIZE)
								- (e.getY() * Playfield.TILE_SIZE));
				double distance = Math.hypot(cx, cy);
				if ((distance <= ((range * Playfield.TILE_SIZE) + SIZE))
						&& (distance < shortestDistance || shortestDistance == 0)) {
					target = e;
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkTarget() {
		if (target == null) {
			return false;
		}
		if (target.isEnabled() == false) {
			target = null;
			state = STAND;
			return false;
		}

		/** Check if target is still in range */
		double cx = Math.abs((this.x * Playfield.TILE_SIZE)
				- (target.getX() * Playfield.TILE_SIZE)), cy = Math
				.abs((this.y * Playfield.TILE_SIZE)
						- (target.getY() * Playfield.TILE_SIZE));
		double distance = Math.hypot(cx, cy);
		if ((distance > ((range * Playfield.TILE_SIZE) + SIZE))
				|| this.checkDead()) {
			target = null;
			state = STAND;
			return false;
		}
		return true;
	}

	public void update(long delta) {
		if (!enabled)
			return;

		if (isMoving) {
			double nx = this.tx - (this.x * Playfield.TILE_SIZE), ny = this.ty
					- (this.y * Playfield.TILE_SIZE);
			double distance = Math.hypot(nx, ny);
			if (distance >= 1) {
				move((float) (nx / distance) * delta * 0.003f
						* ((float) this.speed / 2f),
						(float) (ny / distance) * delta * 0.003f
								* ((float) this.speed / 2f));
			} else {
				state = STAND;
				this.isMoving = false;
			}
		}
		// this.abilityCheckActive();
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i) != null) {
				bullets.get(i).update(delta);
			}
		}
	}

	public void paint(Graphics2D g) {
		if (!enabled)
			return;

		int xp = (int) (Playfield.TILE_SIZE * x);
		int yp = (int) (Playfield.TILE_SIZE * y);

		g.rotate(ang, xp, yp);
		g.setColor(Color.BLACK);
		g.drawImage(spriteTex[state], xp - (SIZE / 2) - 44, yp - (SIZE / 2)
				- 44, null);
		g.rotate(-ang, xp, yp);
		if (!isMoving && this.player.getSelectedUnit() != null
				&& this.player.getSelectedUnit() == this) {
			g.setColor(Color.RED);
			int range = ((this.range * Playfield.TILE_SIZE) + (SIZE / 2));
			g.setStroke(basicStroke);
			// g.drawOval(xp - range, yp - range, (range * 2), (range * 2));
			g.draw(new Ellipse2D.Double(xp - range, yp - range, (range * 2),
					(range * 2)));
		}
		for (int i = 0; i < bullets.size(); i++) {
			// if(bullets.get(i) != null){
			if (i > bullets.size()) {
				return;
			} else {
				bullets.get(i).paint(g);
			}
			// }
		}
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
		this.setFireTimer();
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

//	public int[] getStatistics() {
//		return statistics;
//	}
//
//	public void setStatistics(int[] statistics) {
//		this.statistics = statistics;
//	}

	public void setDmg(int x) {
		this.dmg = x;
	}

	public void setSpeed(int x) {
		this.speed = x;
	}

	public void setRange(int x) {
		this.range = x;
	}

	public void setFireRate(int x) {
		this.fireRate = x;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setIsMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public boolean getIsMoving() {
		return isMoving;
	}

	public Image getSideMenuImage() {
		return spriteTex[5];
	}

	public void clearBullets() {
		this.bullets.clear();
	}
	
	
	public int getdmg(){
		return this.dmg;
	}
	public int getspeed(){
		return this.speed;
	}
	public int getrange(){
		return this.range;
	}
	public int getfireRate(){
		return this.fireRate;
	}
	public void setdmg(int x){
		this.dmg = x;
	}
	public void setspeed(int x){
		this.speed = x;
	}
	public void setrange(int x){
		this.range = x;
	}
	public void setfireRate(int x){
		this.fireRate = x;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
