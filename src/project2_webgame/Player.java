package project2_webgame;

import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public class Player implements Cloneable {
	private Unit[] units = null;
	private Unit[] unitBackup = new Unit[10];
	private int money = 0;
	// lvl 10 7500
	private int kills = 0;
	private int lives = 10;
	Unit selectedUnit;

	Image[][] sprites;
	AudioClip[] audio;

	private boolean running = true;

	public Player(Image[][] sprites, AudioClip[] audio) {
		this.sprites = sprites;
		this.audio = audio;
	}

	public void setReferences(Map map, WaveManager waveManager) {
		/** Create our units */
		if (this.units == null) {
			units = new Unit[] {
					new Unit("Cpt. Jack Sparrow", 2, 1, 2, 1 ,
							sprites[0], map, waveManager, this, 15, 5),
					new Unit("Doutzen Kroes",  1, 2, 1, 2 ,
							sprites[1], map, waveManager, this, 30, 1),
					new Unit("Michael Jackson", 2, 1, 1, 3 ,
							sprites[2], map, waveManager, this, 15, 5),
					new Unit("Steve Jobs", 1, 3, 2, 1 ,
							sprites[3], map, waveManager, this, 30, 10),
					new Unit("Johan Derksen", 3, 1, 2, 1 ,
							sprites[4], map, waveManager, this, 60, 1),
					new Unit("Prof. Stephen Hawking", 6, 3, 1, 2 ,
							sprites[5], map, waveManager, this, 30, 5),
					new Unit("Martin L. King", 6, 2, 1, 3 ,
							sprites[6], map, waveManager, this, 30, 1),
					new Unit("Mr. Bean", 1, 1, 2, 3 , sprites[7],
							map, waveManager, this, 45, 1),
					new Unit("Mario Balotelli", 1, 4, 1, 2 ,
							sprites[8], map, waveManager, this, 45, 10),
					new Unit("Albert Arnold Al Gore", 2, 1, 2, 2 ,
							sprites[9], map, waveManager, this, 30, 5) };
			units[0].setEnabled(true);
			units[1].setEnabled(true);
		} else {
			for (Unit u : this.units) {
				u.setReferences(map, waveManager, this);
			}
		}
	}
	
	public void restoreBackup(){
		this.units = unitBackup;
	}
	
	public void mapChange() {
		/** Clear remainder of the bullets */
		for(Unit u : units) {
			u.clearBullets();
		}
		
		/** Reset lives */
//		if(this.lives > 0) {
			this.lives = 10;
//		}
	}
	
	public void setStartPositions(Point[] startPositions) {
		for(int i = 0; i < startPositions.length; i++) {
			Unit u = units[i];
			u.setPosition(startPositions[i]);
		}
	}

	public void paint(Graphics2D g) {
		if (!running)
			return;

		for (int i = 0; i < units.length; i++) {
			Unit _u = units[i];
			if (_u.getEnabled()) {
				_u.paint(g);
			}
		}
	}

	public Unit unitByName(String naam) {
		Unit selected = null;
		for (int i = 0; i < units.length; i++) {
			if (units[i].getUnitName().equals(naam)) {
				selected = units[i];
			}
		}
		return selected;
	}


	public void setLives(int lives) {
		if(lives < 0){
			audio[0].play();
		}
		this.lives += lives;
	}

	public Unit requestUnitOnSpot(int cx, int cy) {
		Unit _returnUnit = null;
		for (int i = 0; i < units.length; i++) {
			Unit _u = units[i];
			if (_u.getEnabled()) {
				if ((((_u.getX() * Playfield.TILE_SIZE) - (Unit.SIZE / 2)) <= cx)
						&& (((_u.getX() * Playfield.TILE_SIZE) + (Unit.SIZE / 2)) >= cx)
						&& (((_u.getY() * Playfield.TILE_SIZE) - (Unit.SIZE / 2)) <= cy)
						&& (((_u.getY() * Playfield.TILE_SIZE) + (Unit.SIZE / 2)) >= cy)) {
					_returnUnit = _u;
				}
			}
		}
		return _returnUnit;
	}

	public void incMoney(int money) {
		this.money += money;
	}

	public void decreaseMoney(int money) {
		this.money -= money;
	}

	public Boolean enableUnit(int _index) {
		units[_index].setEnabled(Boolean.TRUE);
		return true;
	}

	public void update(long delta) {
		if (!running)
			return;

		for (Unit u : units) {
			if (u.getEnabled()) {
				u.update(delta);
			}
		}
	}

	public Unit[] getUnits() {
		return units;
	}

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(Unit selectedUnit) {
		this.selectedUnit = selectedUnit;
	}

	public Unit getSelected() {
		return selectedUnit;
	}

	public int getMoney() {
		return money;
	}

	public int getKills() {
		return kills;
	}

	public int getLives() {
		return lives;
	}

	public boolean isRunning() {
		return running;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
        for(int i = 0; i < units.length; i++){
        	this.unitBackup[i] = (Unit)units[i].clone();
        }
		return super.clone();
    }
	
	public void setRunning(boolean x){
		this.running = x;
	}
}
