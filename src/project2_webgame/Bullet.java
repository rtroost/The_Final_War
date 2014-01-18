package project2_webgame;

import java.awt.Graphics2D;
import java.awt.Image;

public class Bullet {

	// private Game gameRef;
	private Unit unitRef;
	private Enemy target;
	private float x;
	private float y;
	private int dmg;
	private Image sprite;
	private float ang;

	public Bullet(Enemy _e, float _x, float _y, int _dmg, Image _sprite,
			Unit _unitRef) {
		this.target = _e;
		this.x = _x;
		this.y = _y;
		this.dmg = _dmg;
		this.sprite = _sprite;
		// this.setGameRef(_gameRef);
		this.unitRef = _unitRef;
		// System.out.println("BULLET AANGEMAAKT");
	}

	public void paint(Graphics2D g) {
		int xp = (int) (Playfield.TILE_SIZE * x);
		int yp = (int) (Playfield.TILE_SIZE * y);

		g.rotate(ang, xp, yp);
		// g.setColor(Color.BLACK);
		g.drawImage(sprite, xp - (15 / 2), yp - (9 / 2), null);
		g.rotate(-ang, xp, yp);
	}

	public void update(long delta) {

		// double nx = (this.x * MapBase.TILE_SIZE) - (target.getX() *
		// MapBase.TILE_SIZE),
		// ny = (this.y * MapBase.TILE_SIZE) - (target.getY() *
		// MapBase.TILE_SIZE);
		double nx = (target.getX() * Playfield.TILE_SIZE) + 16
				- (this.x * Playfield.TILE_SIZE), ny = (target.getY() * Playfield.TILE_SIZE)
				+ 16 - (this.y * Playfield.TILE_SIZE);
		double distance = Math.hypot(nx, ny);
		if (distance >= 1) {
			move((float) (nx / distance) * delta * 0.008f,
					(float) (ny / distance) * delta * 0.008f);
		} else {
			// IMPACT + DESTROY |THIS|
			
				target.doDamage(this.dmg * 10);
			
			this.unitRef.delBullet(this);
		}

	}

	public boolean move(float dx, float dy) {

		// work out what the new position of this entity will be
		float nx = x + dx;
		float ny = y + dy;

		x = nx;
		y = ny;

		// and calculate the angle we're facing based on our last move
		ang = (float) (Math.atan2(dy, dx) - (Math.PI / 1));
		return true;
	}
}
