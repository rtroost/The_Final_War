package project2_webgame;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Briefing {

	private int plus1Number = 0;
	private int plus2Number = 0;
	private int plus3Number = 0;
	private int plus4Number = 0;
	private int buyButtonNumber = 0;
	private boolean showBuy = false;
	private int[][] avatarCoords = new int[][] { { 1030, 224 }, { 1078, 224 },
			{ 1127, 224 }, { 1175, 224 }, { 1223, 224 }, { 1030, 281 },
			{ 1078, 281 }, { 1127, 281 }, { 1175, 281 }, { 1223, 281 } };
	private boolean[] bought = new boolean[] { false, false, false, false, false,
			false, false, false, false, false };
	// private boolean heroTimerStart = false;
	private boolean slideIn = false;
	private int avatarnumber = 0;
	private String[][] heroInfo = new String[][]{
			
	
			new String[] { "Cpt. Jack Sparrow",  "Attack: Ranged" },
			new String[] { "Doutzen Kroes",  "Attack: Ranged" },
			new String[] { "Michael Jackson", "Attack: Ranged" },
			new String[] { "Steve Jobs", "Attack: Ranged" },
			new String[] { "Johan Derksen", "Attack: Ranged" },
			new String[] { "Prof. Stephen Hawking", "Attack: Melee" },
			new String[] { "Martin L. King", "Attack: Melee" },
			new String[] { "Mr. Bean", "Attack: Ranged" },
			new String[] { "Mario Balotelli", "Attack: Ranged" },
			new String[] { "Albert Arnold Al Gore", "Attack: Ranged" }, };

	private Typewriter[] briefingText = new Typewriter[] {
			new Typewriter(new String[] { "Country: Egypt", " ", " ",
					"Capital: Cairo", " ", " ", "Enemy: Egyptian forces", " ",
					" ", "Waves: 9", " ", " ", "Type: Undead", " ", " ",
					"Speed: Medium", " ", " ", "Health: 30", }),
			new Typewriter(new String[] { "Country: South-Korea", " ", " ",
					"Capital: Seoul", " ", " ", "Enemy: Korean forces", " ",
					" ", "Waves: 6", " ", " ", "Type: Human", " ", " ",
					"Speed: medium", " ", " ", "Health: 30", }),
			new Typewriter(new String[] { "Country: Libya", " ", " ",
					"Capital: Tripoli", " ", " ", "Enemy: Libyan army", " ",
					" ", "Waves: 6", " ", " ", "Type: Human", " ", " ",
					"Speed: fast", " ", " ", "Health: 60", }),
			new Typewriter(new String[] { "Country: Serbia", " ", " ",
					"Capital: Belgrade", " ", " ", "Enemy: Serbian forces",
					" ", " ", "Waves: 8", " ", " ", "Type: Undead", " ", " ",
					"Speed: Medium", " ", " ", "Health: 80", }),
			new Typewriter(new String[] { "Country: Russia", " ", " ",
					"Capital: Moscow", " ", " ", "Enemy: Russian forces", " ",
					" ", "Waves: 11", " ", " ", "Type: Zombie", " ", " ",
					"Speed: medium", " ", " ", "Health: 100", }),
			new Typewriter(new String[] { "Country: Iraq", " ", " ",
					"Capital: Baghdad", " ", " ", "Enemy: Iraqi forces", " ",
					" ", "Waves: 13", " ", " ", "Type: Human", " ", " ",
					"Speed: fast", " ", " ", "Health: 120", }),
			new Typewriter(new String[] { "Country: Italy", " ", " ",
					"Capital: Rome", " ", " ", "Enemy: Rome forces", " ", " ",
					"Waves: 15", " ", " ", "Type: Undead", " ", " ", "Speed: medium",
					" ", " ", "Health: 140", }),
			new Typewriter(new String[] { "Country: France", " ", " ",
					"Capital: Paris", " ", " ", "Enemy: French forces", " ",
					" ", "Waves:16", " ", " ", "Type: Zombie", " ", " ",
					"Speed: medium", " ", " ", "Health: 170", }),
			new Typewriter(new String[] { "Country: Cuba", " ", " ",
					"Capital: Havana", " ", " ", "Enemy: Cuban forces", " ",
					" ", "Waves: 23", " ", " ", "Type: Human", " ", " ",
					"Speed: medium", " ", " ", "Health: 170", }),
			new Typewriter(new String[] { "Country: Holland", " ", " ",
					"Capital: Rotterdam", " ", " ", "Enemy: Dutch forces", " ",
					" ", "Waves: 21", " ", " ", "Type: Undead", " ", " ",
					"Speed: fast", " ", " ", "Health: 180", }) };

	//private Typewriter boughtHeroInfo;
	private String[] heroInfoBought = new String[8];

	int _mouseCoords0;
	int _mouseCoords1;
	int delay = 100;
	FontMetrics Metrics;
	private Timer t;
	private boolean avatarclicked = false;
	private int sidebarLeftX = -300;
	private int sidebarRightX = 1280;
	private int buyNowX = 1280;
	private int infoBigY = 357;
	private int jackSparrowCount = 0;
	private boolean startCurLevel = false;
	private int startLevelX = 485;
	private int startLevelY = 1300;
	private int moneyX = 485;
	private int moneyY = -190;

	private Image[][] sprites;
	private AudioClip[][] audio;
	private Font[] fonts;

	private Player player;

	private boolean running = false;

	// Hero Info Stats on Screen
	private int damage = 0;
	private int speed = 0;
	private int range = 0;
	private int fireRate = 0;

	private Unit selectedUnit;
	private int toUpdateDmg = 0;
	private int toUpdateSpeed = 0;
	private int toUpdateRange = 0;
	private int toUpdateFireRate = 0;
	private int updateMoney = 0;
	private int mapnumber = 1;

	public Briefing(Image[][] sprites, AudioClip[][] audio, Font[] fonts, int mapnumber) {
		this.sprites = sprites;
		this.audio = audio;
		this.fonts = fonts;
		this.mapnumber = mapnumber;
	}

	public void setReferences(Player player) {
		this.player = player;
	}

	public void run() {
		money();
		setBought();
		startlevel();

		briefingText[mapnumber-1].Start();
		sidebar();

		audio[0][0].play();
		this.running = true;
	}

	public void setBought() {
		Unit[] temp = this.player.getUnits();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].getEnabled()) {
				this.bought[i] = true;
			}
		}
	}

	public void setHeroInfoBought() {
		

		int dmgMoney = 0;
		if (this.damage != 10 || this.toUpdateDmg != 10) {
			dmgMoney = this.bedragBerekening(this.toUpdateDmg + 1);
		}

		int speedMoney = 0;
		if (this.speed != 10 || this.toUpdateSpeed != 10) {
			speedMoney = this.bedragBerekening(this.toUpdateSpeed + 1);
		}

		int rangeMoney = 0;
		if (this.speed != 10 || this.toUpdateRange != 10) {
			rangeMoney = this.bedragBerekening(this.toUpdateRange + 1);
		}

		int fireRateMoney = 0;
		if (this.fireRate != 10 || this.toUpdateFireRate != 10) {
			fireRateMoney = this.bedragBerekening(this.toUpdateFireRate + 1);
		}

		if (dmgMoney != 0 && this.toUpdateDmg > this.damage) {
			heroInfoBought[0] = "Damage: " + this.damage;
			heroInfoBought[1] = "Cost: €" + dmgMoney
					+ " | +"
					+ (this.toUpdateDmg - this.damage)
					;
		} else if (dmgMoney != 0) {
			heroInfoBought[0] = "Damage: " + this.damage;
			heroInfoBought[1] = "Cost: €" + dmgMoney;
		} else if (this.toUpdateDmg > this.damage) {
			heroInfoBought[0] = "Damage: " + this.damage;
			heroInfoBought[1] = " +" + (this.toUpdateDmg - this.damage);
		} else {
			heroInfoBought[0] = "Damage: " + this.damage;
			heroInfoBought[1] = " ";
		}

		// heroInfoBought[1] = "Cost: €500";
		// //heroInfoBought[2] = " ";

		if (speedMoney != 0 && this.toUpdateSpeed > this.speed) {
			heroInfoBought[2] = "Movement Speed: " + this.speed;
			heroInfoBought[3] = "Cost: €" + speedMoney
					+ " | +"
					+ (this.toUpdateSpeed - this.speed)
					;
		} else if (speedMoney != 0) {
			heroInfoBought[2] = "Movement Speed: " + this.speed;
			heroInfoBought[3] = "Cost: €" + speedMoney;
		} else if (this.toUpdateSpeed > this.speed) {
			heroInfoBought[2] = "Movement Speed: " + this.speed;
			heroInfoBought[3] = " +" + (this.toUpdateSpeed - this.speed);
		} else {
			heroInfoBought[2] = "Movement Speed: " + this.speed;
			heroInfoBought[3] = " ";
		}

		// heroInfoBought[3] = "Cost: €500";
		// heroInfoBought[5] = " ";

		
		if(this.selectedUnit.getUnitName().equals("Martin L. King")
				|| this.selectedUnit.getUnitName().equals(
						"Prof. Stephen Hawking")) {
				heroInfoBought[4] = "Weapon Range: melee";
				heroInfoBought[5] = " ";
		} else {
			if (rangeMoney != 0 && this.toUpdateRange > this.range) {
				heroInfoBought[4] = "Weapon Range: " + this.range;
				heroInfoBought[5] = "Cost: €" + rangeMoney
						+ " | +"
						+ (this.toUpdateRange - this.range)
						;
			} else if (rangeMoney != 0) {
				heroInfoBought[4] = "Weapon Range: " + this.range;
				heroInfoBought[5] = "Cost: €" + rangeMoney;
			} else if (this.toUpdateRange > this.range) {
				heroInfoBought[4] = "Weapon Range: " + this.range;
				heroInfoBought[5] = " +" + (this.toUpdateRange - this.range);
			} else {
				heroInfoBought[4] = "Weapon Range: " + this.range;
				heroInfoBought[5] = " ";
			}
		}

		// heroInfoBought[5] = "Cost: €500";
		// heroInfoBought[8] = " ";

		if (fireRateMoney != 0 && this.toUpdateFireRate > this.fireRate) {
			heroInfoBought[6] = "Attack Speed: " + this.fireRate;
			heroInfoBought[7] = "Cost: €" + fireRateMoney
					+ " | +"
					+ (this.toUpdateFireRate - this.fireRate)
					;
		} else if (fireRateMoney != 0) {
			heroInfoBought[6] = "Attack Speed: " + this.fireRate;
			heroInfoBought[7] = "Cost: €" + fireRateMoney;
		} else if (this.toUpdateFireRate > this.fireRate) {
			heroInfoBought[6] = "Attack Speed: " + this.fireRate;
			heroInfoBought[7] = " +" + (this.toUpdateFireRate - this.fireRate);
		} else {
			heroInfoBought[6] = "Attack Speed: " + this.fireRate;
			heroInfoBought[7] = " ";
		}
		// heroInfoBought[7] = "Cost: €500";

//		this.boughtHeroInfo = new Typewriter(heroInfoBought);
//		this.boughtHeroInfo.Start();
	}
	
	public void setHeroInfoNotBought() {
		
		for(String[] x : this.heroInfo){
			if(x[0].equals(this.selectedUnit.getUnitName())){
				heroInfoBought[0] = x[0];
				heroInfoBought[1] = x[1];
			}
		}
		
		heroInfoBought[2] = "Damage: " + this.damage;
		heroInfoBought[3] = "Movement Speed: " + this.speed;
		if(this.selectedUnit.getUnitName().equals("Martin L. King")
				|| this.selectedUnit.getUnitName().equals(
						"Prof. Stephen Hawking")) {
			heroInfoBought[4] = "Weapon Range: melee";
		} else {
			heroInfoBought[4] = "Weapon Range: " + this.range;
		}
		heroInfoBought[5] = "FireRate: " + this.fireRate;
		heroInfoBought[6] = " ";
		heroInfoBought[7] = " ";
		
	}

	public void selectUnit(String naam) {
		if (this.selectedUnit != null
				&& this.selectedUnit.getUnitName().equals(naam)) {
			return;
		}
		Unit selected = this.player.unitByName(naam);
		if (selected != null) {
			this.selectedUnit = selected;
			this.damage = this.selectedUnit.getdmg();
			this.speed = this.selectedUnit.getspeed();
			this.range = this.selectedUnit.getrange();
			this.fireRate = this.selectedUnit.getfireRate();
			this.toUpdateDmg = this.damage;
			this.toUpdateSpeed = this.speed;
			this.toUpdateRange = this.range;
			this.toUpdateFireRate = this.fireRate;
			
		}
		if (this.selectedUnit.getEnabled()) {
			setHeroInfoBought();
			this.updateMoney = 0;
		} else {
			setHeroInfoNotBought();
			this.updateMoney = this.bedragBerekeningUnit();
		}
	}

	public void sidebar() {

		t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (sidebarLeftX < -100) {
					sidebarLeftX += 3;
				} else if (sidebarLeftX < -20 && sidebarLeftX > -100) {
					sidebarLeftX += 2;
				} else if (sidebarLeftX <= 0 && sidebarLeftX > -20) {
					sidebarLeftX += 1;
				} else {
					if (jackSparrowCount <= 100) {
						jackSparrowCount++;
					}
					
					slideIn = true;
				}

				if (sidebarRightX > 1080) {
					sidebarRightX -= 3;
				} else if (sidebarRightX > 1000 && sidebarRightX < 1080) {
					sidebarRightX -= 2;
				} else if (sidebarRightX > 980 && sidebarRightX < 1000) {
					sidebarRightX -= 1;
				}

				if (showBuy == true) {
					if (buyNowX >= 1091) {
						buyNowX -= 1;
					}
				} else {
					if (buyNowX <= 1280) {
						buyNowX += 1;
					}

				}
			}
		}, 0, 5);
	}

	public void startlevel() {

		t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (startLevelY > 595) {
					startLevelY -= 1;
				} else {
					startCurLevel = true;
				}
			}
		}, 0, 5);
	}

	public void money() {

		t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (moneyY < 0) {
					moneyY += 1;
				}
			}
		}, 0, 5);
	}

	public void doRightClick(Point c) {
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 360
				&& c.getY() < 394) {
			// setDamage();
			decToUpdateDmg();
		}

		// run speed
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 402
				&& c.getY() < 435) {
			// setRunSpeed();
			decToUpdateSpeed();
		}

		// range
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 444
				&& c.getY() < 477) {
			// setRange();
			decToUpdateRange();
		}

		// fire speed
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 486
				&& c.getY() < 519) {
			// setFireSpeed();
			decToUpdateFireRate();
		}

		if (this.damage == this.toUpdateDmg && this.speed == this.toUpdateSpeed
				&& this.range == this.toUpdateRange
				&& this.fireRate == this.toUpdateFireRate) {
			showBuy = false;
		}
	}

	public int doClick(Point c) {
		// jack Sparrow
		if (c.getX() > 1030 && c.getX() < 1074 && c.getY() > 220 && c.y < 267) {
			setAvatarnumber(0);
			selectUnit("Cpt. Jack Sparrow");
		}

		// doutzen kroes
		if (c.x > 1078 && c.x < 1122 && c.y > 220 && c.y < 267) {
			setAvatarnumber(1);
			selectUnit("Doutzen Kroes");
		}

		// Michael jackson
		if (c.x > 1127 && c.x < 1170 && c.y > 220 && c.y < 267) {
			setAvatarnumber(2);
			selectUnit("Michael Jackson");
		}

		// steve jobs
		if (c.x > 1175 && c.x < 1217 && c.y > 220 && c.y < 267) {
			setAvatarnumber(3);
			selectUnit("Steve Jobs");
		}

		// johan derksen
		if (c.x > 1223 && c.x < 1264 && c.y > 220 && c.y < 267) {
			setAvatarnumber(4);
			selectUnit("Johan Derksen");
		}

		// stephen hawkin
		if (c.x > 1030 && c.x < 1074 && c.y > 277 && c.y < 324) {
			setAvatarnumber(5);
			selectUnit("Prof. Stephen Hawking");
		}

		// martin luther king
		if (c.x > 1078 && c.x < 1122 && c.y > 277 && c.y < 324) {
			setAvatarnumber(6);
			selectUnit("Martin L. King");
		}

		// mr bean
		if (c.x > 1127 && c.x < 1170 && c.y > 277 && c.y < 324) {
			setAvatarnumber(7);
			selectUnit("Mr. Bean");
		}

		// baliotelli
		if (c.x > 1175 && c.x < 1217 && c.y > 277 && c.y < 324) {
			setAvatarnumber(8);
			selectUnit("Mario Balotelli");
		}

		// al gore
		if (c.x > 1223 && c.x < 1264 && c.y > 277 && c.y < 324) {
			setAvatarnumber(9);
			selectUnit("Albert Arnold Al Gore");
		}

		// start level
		if (getStartCurLevel() == true) {
			if (c.x > 521 && c.x < 757 && c.y > 612 && c.y < 640) {
				audio[0][1].play();
				this.running = false;
				
				return 1;
			}
		}
		// damage button
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 360
				&& c.getY() < 394) {
			// setDamage();
			incToUpdateDmg();
		}

		// run speed
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 402
				&& c.getY() < 435) {
			// setRunSpeed();
			incToUpdateSpeed();
		}

		// range
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 444
				&& c.getY() < 477) {
			// setRange();
			incToUpdateRange();
		}

		// fire speed
		if (c.getX() > 1237 && c.getX() < 1270 && c.getY() > 486
				&& c.getY() < 519) {
			// setFireSpeed();
			incToUpdateFireRate();
		}

		// Buy button
		if (c.getX() > 1100 && c.getX() < 1245 && c.getY() > 584
				&& c.getY() < 616) {
			if (this.selectedUnit.getEnabled()) {
				buyUpdates();
			} else {
				buyUnit();
			}

		}

		return 0;
	}

	public void buyUpdates() {
		// decrease money
		this.player.decreaseMoney(this.updateMoney);
		this.updateMoney = 0;
		this.selectedUnit.setDmg(this.toUpdateDmg);
		this.selectedUnit.setSpeed(this.toUpdateSpeed);
		this.selectedUnit.setRange(this.toUpdateRange);
		this.selectedUnit.setFireRate(this.toUpdateFireRate);

		this.damage = this.selectedUnit.getdmg();
		this.speed = this.selectedUnit.getspeed();
		this.range = this.selectedUnit.getrange();
		this.fireRate = this.selectedUnit.getfireRate();
		this.toUpdateDmg = this.damage;
		this.toUpdateSpeed = this.speed;
		this.toUpdateRange = this.range;
		this.toUpdateFireRate = this.fireRate;
		setHeroInfoBought();
		showBuy = false;
		this.selectedUnit.setFireTimer();
	}

	public void buyUnit() {
		if (this.bedragBerekeningUnit() > this.player.getMoney()) {
			return;
		}
		this.player.decreaseMoney(this.bedragBerekeningUnit());
		this.updateMoney = 0;
		this.selectedUnit.setEnabled(true);
		this.setBought();
		showBuy = false;
		this.selectedUnit.setFireTimer();
		setHeroInfoBought();
	}

	public void update(long delta) {

	}

	public void paint(Graphics2D g) {
		if (!this.running)
			return;

		g.drawImage(sprites[0][5+mapnumber], 0, 0, null);
		g.setFont(fonts[1].deriveFont(Font.PLAIN, 16));
		g.setColor(new Color(97, 184, 109));

		g.drawImage(sprites[0][1], sidebarLeftX, 0, null);
		g.drawImage(sprites[0][0], sidebarRightX, 0, null);
		if (bought[avatarnumber] == true) {
			g.drawImage(sprites[2][1], sidebarRightX + 48, infoBigY, null);
			if (avatarclicked == true) {
				// g.drawImage(sprites[4][plus1Number], sidebarRightX + 257,
				// 360,
				// null);
				// g.drawImage(sprites[4][plus2Number], sidebarRightX + 257,
				// 402,
				// null);
				// g.drawImage(sprites[4][plus3Number], sidebarRightX + 257,
				// 444,
				// null);
				// g.drawImage(sprites[4][plus4Number], sidebarRightX + 257,
				// 486,
				// null);
				g.drawImage(sprites[4][plus1Number], sidebarRightX + 257, 372,
						null);
				g.drawImage(sprites[4][plus2Number], sidebarRightX + 257, 412,
						null);
				g.drawImage(sprites[4][plus3Number], sidebarRightX + 257, 452,
						null);
				g.drawImage(sprites[4][plus4Number], sidebarRightX + 257, 492,
						null);
			}
		} else {
			g.drawImage(sprites[2][1], sidebarRightX + 48, infoBigY, null);
		}

		g.drawImage(sprites[0][4], moneyX, moneyY, null);
		g.drawImage(sprites[0][3], startLevelX, startLevelY, null);

		if (jackSparrowCount > 75) {
			g.drawImage(sprites[0][2], 32, 29, null);
			for (int i = 0; i < bought.length; i++) {
				if (bought[i] == false) {
					g.drawImage(sprites[0][5], avatarCoords[i][0],
							avatarCoords[i][1], null);
				}
			}
		}

		if(this.slideIn) {
			String[] briefingtext = briefingText[mapnumber-1].getText();
			for (int i = 0; i < briefingtext.length; i++) {
				g.drawString(briefingtext[i], 34, 240 + (i * 20));
			}
		}

		if (heroInfoBought != null && heroInfoBought[0] != null) {
			if (avatarclicked == true && bought[avatarnumber] == true) {
				for (int i = 0; i < heroInfoBought.length; i++) {
					g.drawString(heroInfoBought[i], 1044, 385 + (i * 20));
				}
			}

			if (avatarclicked == true && bought[avatarnumber] == false) {
				for (int i = 0; i < heroInfoBought.length; i++) {
					g.drawString(heroInfoBought[i], 1044, 385 + (i * 20));
				}
			}
		}

		if (avatarclicked == true) {
			g.drawImage(sprites[1][avatarnumber], 1042, 34, null);
		}
		
		g.drawImage(sprites[3][buyButtonNumber], buyNowX, 576, null);

		g.setFont(fonts[1].deriveFont(Font.PLAIN, 20));
		g.setColor(new Color(97, 184, 109));
		g.drawString("$" + player.getMoney(), 610, this.moneyY + 21);

		if (updateMoney != 0) {
			g.drawString("Cost: $" + this.updateMoney, 1080, 554);
		}
	}

	public void setAvatarnumber(int avatarnumber) {
		this.avatarnumber = avatarnumber;
		avatarclicked = true;
		audio[1][avatarnumber].play();

		if (bought[avatarnumber] == true) {
			showBuy = false;
		} else {
			showBuy = true;
		}
	}

	public boolean getStartCurLevel() {
		return startCurLevel;
	}

	public void setavatarnumber(int avatarnumber) {
	}

	public void setPlus1(int plus1Number) {
		this.plus1Number = plus1Number;
	}

	public void setPlus2(int plus2Number) {
		this.plus2Number = plus2Number;
	}

	public void setPlus3(int plus3Number) {
		this.plus3Number = plus3Number;
	}

	public void setPlus4(int plus4Number) {
		this.plus4Number = plus4Number;
	}

	public void setBuyButtonNumber(int buyButtonNumber) {
		this.buyButtonNumber = buyButtonNumber;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void decToUpdateDmg() {
		if (this.toUpdateDmg > this.damage) {
			this.updateMoney -= bedragBerekening(this.toUpdateDmg);
			this.toUpdateDmg--;
			setHeroInfoBought();
			showBuy = true;
		}
	}

	public void decToUpdateSpeed() {
		if (this.toUpdateSpeed > this.speed) {
			this.updateMoney -= bedragBerekening(this.toUpdateSpeed);
			this.toUpdateSpeed--;
			setHeroInfoBought();
			showBuy = true;
		}
	}

	public void decToUpdateRange() {
		if (this.toUpdateRange > this.range) {
			this.updateMoney -= bedragBerekening(this.toUpdateRange);
			this.toUpdateRange--;
			setHeroInfoBought();
			showBuy = true;
		}
	}

	public void decToUpdateFireRate() {
		if (this.toUpdateFireRate > this.fireRate) {
			this.updateMoney -= bedragBerekening(this.toUpdateFireRate);
			this.toUpdateFireRate--;
			setHeroInfoBought();
			showBuy = true;
		}
	}

	public void incToUpdateDmg() {
		if (this.toUpdateDmg + 1 > 10
				|| this.player.getMoney() < bedragBerekening(this.toUpdateDmg + 1)
						+ this.updateMoney) {
			return;
		}
		this.updateMoney += bedragBerekening(this.toUpdateDmg + 1);
		this.toUpdateDmg++;
		setHeroInfoBought();
		showBuy = true;
	}

	public void incToUpdateSpeed() {
		if (this.toUpdateSpeed + 1 > 10
				|| this.player.getMoney() < bedragBerekening(this.toUpdateSpeed + 1)
						+ this.updateMoney) {
			return;
		}
		this.updateMoney += bedragBerekening(this.toUpdateSpeed + 1);
		this.toUpdateSpeed++;
		setHeroInfoBought();
		showBuy = true;
	}

	public void incToUpdateRange() {
		if (this.toUpdateRange + 1 > 10
				|| this.player.getMoney() < bedragBerekening(this.toUpdateRange + 1)
						+ this.updateMoney
				|| this.selectedUnit.getUnitName().equals("Martin L. King")
				|| this.selectedUnit.getUnitName().equals(
						"Prof. Stephen Hawking")) {
			return;
		}
		this.updateMoney += bedragBerekening(this.toUpdateRange + 1);
		this.toUpdateRange++;
		setHeroInfoBought();
		showBuy = true;
	}

	public void incToUpdateFireRate() {
		if (this.toUpdateFireRate + 1 > 10
				|| this.player.getMoney() < bedragBerekening(this.toUpdateFireRate + 1)
						+ this.updateMoney) {
			return;
		}
		this.updateMoney += bedragBerekening(this.toUpdateFireRate + 1);
		this.toUpdateFireRate++;
		setHeroInfoBought();
		showBuy = true;
	}

	public int bedragBerekening(int nummer) {
		int bedrag = 0;
		switch (nummer) {
		case 1:
			bedrag = 10;
			break;
		case 2:
			bedrag = 25;
			break;
		case 3:
			bedrag = 50;
			break;
		case 4:
			bedrag = 100;
			break;
		case 5:
			bedrag = 180;
			break;
		case 6:
			bedrag = 260;
			break;
		case 7:
			bedrag = 480;
			break;
		case 8:
			bedrag = 690;
			break;
		case 9:
			bedrag = 920;
			break;
		case 10:
			bedrag = 1250;
			break;
		}
		return bedrag;
	}

	public int bedragBerekeningUnit() {
		
		if (this.selectedUnit.getUnitName().equals("Cpt. Jack Sparrow")) {
			return 0;
		}
		if (this.selectedUnit.getUnitName().equals("Doutzen Kroes")) {
			return 0;
		}
		if (this.selectedUnit.getUnitName().equals("Michael Jackson")) {
			return 200;
		}
		if (this.selectedUnit.getUnitName().equals("Steve Jobs")) {
			return 400;
		}
		if (this.selectedUnit.getUnitName().equals("Johan Derksen")) {
			return 350;
		}
		if (this.selectedUnit.getUnitName().equals("Prof. Stephen Hawking")) {
			return 500;
		}
		if (this.selectedUnit.getUnitName().equals("Martin L. King")) {
			return 450;
		}
		if (this.selectedUnit.getUnitName().equals("Mr. Bean")) {
			return 550;
		}
		if (this.selectedUnit.getUnitName().equals("Mario Balotelli")) {
			return 700;
		}
		if (this.selectedUnit.getUnitName().equals("Albert Arnold Al Gore")) {
			return 600;
		}
		return 0;
	}
	
	public boolean isSlideIn() {
		return slideIn;
	}
}