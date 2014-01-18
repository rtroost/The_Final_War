package project2_webgame;

import java.applet.AudioClip;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class MainMenu {

	boolean slideOut = false;
	private boolean pixelAdd = false;
	private boolean pixelAdd2 = false;
	private int backgroundPngLinksX = 0;
	private int backgroundPngRechtsX = 640;
	int delay = 100;
	FontMetrics Metrics;
	private Timer t;
	private int backgroundCount = 0;
	private int newGameCount = 0;
	private int instructionsCount = 0;
	private int creditsCount = 0;
	private int newGamePic = 0;
	private int instructionsPic = 0;
	private int creditsPic = 0;

	private boolean slideIn = false;

	private Image[][] sprites;
	private AudioClip[] audio;

	private boolean running = true;

	public MainMenu(Image[][] sprites, AudioClip[] audio) {
		this.sprites = sprites;
		this.audio = audio;
		audio[0].play();
		count();
	}

	public void count() {
		t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (backgroundCount <= 5000) {
					backgroundCount++;
				}
				if (newGameCount == 200 || instructionsCount == 222
						|| creditsCount == 244) {
					audio[1].play();
				}

				if (newGameCount <= 400) {
					newGameCount++;
				}

				if (instructionsCount <= 420) {
					instructionsCount++;
				}

				if (creditsCount <= 440) {
					creditsCount++;
					slideIn = true;
				}

				if (slideOut == true) {
					if (backgroundPngLinksX > -360) {
						backgroundPngLinksX -= 15;
					} else if (backgroundPngLinksX <= -360
							&& backgroundPngLinksX > -460) {
						backgroundPngLinksX -= 10;
					} else if (backgroundPngLinksX <= -460
							&& backgroundPngLinksX >= -520) {
						backgroundPngLinksX -= 5;
					} else if (backgroundPngLinksX <= -520
							&& backgroundPngLinksX >= -560) {
						backgroundPngLinksX -= 3;
					} else if (backgroundPngLinksX <= -560
							&& backgroundPngLinksX >= -595) {
						backgroundPngLinksX -= 2;
					} else if (backgroundPngLinksX <= -595
							&& backgroundPngLinksX >= -620) {
						backgroundPngLinksX -= 1;
					} else if (backgroundPngLinksX <= -620
							&& backgroundPngLinksX >= -640) {
						if (pixelAdd2 == true) {
							backgroundPngLinksX -= 1;
							pixelAdd2 = false;
						} else {
							pixelAdd2 = true;
						}
					}

					if (backgroundPngRechtsX < 1000) {
						backgroundPngRechtsX += 15;
					} else if (backgroundPngRechtsX >= 1000
							&& backgroundPngRechtsX < 1100) {
						backgroundPngRechtsX += 10;
					} else if (backgroundPngRechtsX >= 1100
							&& backgroundPngRechtsX <= 1160) {
						backgroundPngRechtsX += 5;
					} else if (backgroundPngRechtsX >= 1160
							&& backgroundPngRechtsX <= 1200) {
						backgroundPngRechtsX += 3;
					} else if (backgroundPngRechtsX >= 1200
							&& backgroundPngRechtsX <= 1235) {
						backgroundPngRechtsX += 2;
					} else if (backgroundPngRechtsX >= 1235
							&& backgroundPngRechtsX <= 1260) {
						backgroundPngRechtsX += 1;
					} else if (backgroundPngRechtsX >= 1260
							&& backgroundPngRechtsX <= 1280) {
						if (pixelAdd == true) {
							backgroundPngRechtsX += 1;
							pixelAdd = false;
						} else {
							pixelAdd = true;
						}
					} else {
						running = false;
					}
				}
			}
		}, 0, 10);
	}

	public int doClick(Point c) {
		if (this.getNewGameCount() >= 270) {
			// New game
			if (c.getX() > 90 && c.getX() < 340 && c.getY() > 457
					&& c.getY() < 492) {
				audio[3].play();
				slideOut = true;
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 1;
			}
		}

		if (this.getInstructionsCount() >= 290) {
			// Instructions
			if (c.getX() > 505 && c.getX() < 805 && c.getY() > 453
					&& c.getY() < 495) {
				this.running = false;
				return 2;
			}
		}

		if (this.getCreditsCount() >= 310) {
			// Credits
			if (c.getX() > 981 && c.getX() < 1164 && c.getY() > 458
					&& c.getY() < 493) {
				this.running = false;
				return 3;
			}
		}

		return 0;
	}

	public void update(long delta) {

	}

	public void paint(Graphics2D g) {
		if (!running)
			return;

		if (newGameCount >= 100) {
			g.drawImage(sprites[0][0], 0, 0, null);
			g.drawImage(sprites[0][5], backgroundPngLinksX, 0, null);
			g.drawImage(sprites[0][6], backgroundPngRechtsX, 0, null);
			g.drawImage(sprites[0][3], backgroundPngLinksX + 495, 444, null);
			g.drawImage(sprites[0][4], backgroundPngRechtsX, 444, null);
		}
		if (slideOut == false) {
			if (backgroundCount >= 5000) {
				g.drawImage(sprites[0][2], 0, 0, null);
			} else {
				g.drawImage(sprites[0][1], 0, 0, null);
			}
		}

		if (newGameCount >= 210) {
			g.drawImage(sprites[1][newGamePic], backgroundPngLinksX + 87, 449,
					null);
		}
		if (slideOut == false) {
			if (instructionsCount >= 240) {
				g.drawImage(sprites[2][instructionsPic], 495, 444, null);
			}
		}

		if (creditsCount >= 270) {
			g.drawImage(sprites[3][creditsPic], backgroundPngRechtsX + 330,
					444, null);
		}
	}

	public void setNewGamePic(int newGamePic) {
		if (!this.slideIn)
			return;
		if (this.newGamePic != newGamePic && newGameCount >= 210)
			audio[2].play();
		this.newGamePic = newGamePic;
	}

	public void setInstructionsPic(int instructionsPic) {
		if (!this.slideIn)
			return;
		if (this.instructionsPic != instructionsPic && instructionsCount >= 240)
			audio[2].play();
		this.instructionsPic = instructionsPic;
	}

	public void setCreditsPic(int creditsPic) {
		if (!this.slideIn)
			return;
		if (this.creditsPic != creditsPic && creditsCount >= 270)
			audio[2].play();
		this.creditsPic = creditsPic;
	}

	public int getCreditsCount() {
		return creditsCount;
	}

	public int getInstructionsCount() {
		return instructionsCount;
	}

	public int getNewGameCount() {
		return newGameCount;
	}

	public boolean isRunning() {
		return running;
	}
	
	public boolean isSlideIn() {
		return slideIn;
	}
	
	public void setRunning(boolean x){
		this.running = x;
	}
}