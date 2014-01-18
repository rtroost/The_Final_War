package project2_webgame;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Outro {

	Font[] fonts;
	private Timer t;
	private int linksX = -640;
	private int rechtsX = 1280;
	private int mapnumber = 1;
	private int skipOver = 1;
	private boolean pixelAdd = false;
	private boolean pixelAdd2 = false;
	private boolean slideInn = true;
	private boolean slideOut = false;
	private Image[] sprites;
	private Typewriter[] intro = new Typewriter[] {
			new Typewriter(
					new String[] {
							"Jack Sparrow: \"Friends, I need your help immediately, Mubarak created an extraordinary army together",
							"with Cleopatra.",
							"  ",
							"I don't know how they managed to do this but they revived Cleopatra,",
							"she's living and fighting again...!",
							"  ",
							"And this is not all the news that I have, Mubarak and Cleopatra revived",
							"a lot of bodies to create the army. I don't know how this is even possible..",
							"  ",
							"I couldn't win the fight so I fled from Egypt to save the rest of the world.",
							"  ",
							"I received some intelligence that the army is currently heading to North- and South-Korea.",
							"  ",
							"They call themselves THE HADES corporation.",
							"  ",
							"All assistance is immediately required! Leave your ships and parrots and report for duty!\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"Well done heroes! We managed to defend South-Korea from the evil HADES corporation",
							"  ",
							"We even killed Cleopatra, one of their strongest generals!",
							"I actually don't know why I just called her strong haha, she couldn't even resist",
							"some of my blaster bullets, haha...!",
							"  ",
							"Thanks to killing Cleopatra we got a lot of information about the HADES corporation.",
							"She was carrying allot of intelligence...",
							"  ",
							"It seems like Mubarak created and alliance together",
							"with Kim-Jong Il to start a third world war and dominate the world after they win the war.",
							"They also created a special recipe to revive dead people...",
							"Are they serious..? They developed this recipe in North-Korea",
							"in all secret and used it on Cleopatra and probably many others as well.",
							"  ",
							"The latest spy informed HQ that Libya is currently under attack!",
							"  ",
							"Enter your vehicles and fly immediately to Libya to assist me and defeat the HADES corporation!!\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"I'm so proud guys.. and Doutzen! Keep up this work!",
							"  ",
							"We managed to free Libya and kill Qadhafi after week of fighting.",
							"I showed his dead body on the main square of Tripoli, the crowd was insane and",
							"ripped his body in pieces, haha!",
							"  ",
							"I'm glad tot we could free Libya so fast, this is what the civilians from Libya",
							"had been waiting for, for about 30 years...",
							"  ",
							"I didn't receive any red code information from HQ yet.",
							"  ",
							"So head to New York, hide in our bunker and get some",
							"well earned sleep, food, rum and play with your parrot!\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"Ratko Mladic... Ratko Mladic... what's going on with this HADES corporation?",
							"  ",
							"I'm glad that we have such a strong and talented team,",
							"but we were lucky in this fight.",
							"  ",
							"We could have easily been defeated which could result in the end of the world!",
							"We have to stay focused!",
							"  ",
							"Mladic is dead, again.. Let's hope he's never coming back! Congratulations!",
							"We will be in the hearts of the Serbian people forever! I'm willing you guys to",
							"travel to Russia as soon as possible, our next job lies ahead.",
							"  ", "Gather in our temporarily HQ in Moscow...",
							"Oh and Doutzen, please don’t forget my bottle of rum this time!\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"Hahahah *hig* I love this Russian vodka *hig*.",
							"  ",
							"He's dead, he's dead, he's dead, dead, dead!",
							"We killed Stalin an put him under the eternal Russian ice *hig* Muahaha.",
							"  ",
							"Enjoy your vodka as long as you can, grab another bottle and enjoy this party",
							"with the rest of the Russian civilians *hig*.",
							"  ",
							"I will report back to you in 2 days...*hig*\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"It seems like yet another day in the office. We fought and we won!",
							"  ",
							"Saddam Hoessein got revived and we killed him! We are unbeatable for HADES corp.!",
							"  ",
							"Are we ready for the next fight? Of course we are!",
							"Are we going to kill some badass HADES generals? Of course!",
							"  ",
							"Start your engines and head to Italy, lets save the world and be the heroes forever!\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"I'm glad we won, the fight wasn't that easy!",
							"  ",
							"I'm not feeling that good! I need some rest, rum and a woman!",
							"  ",
							"Head to our HQ for a well earned break! We will not be fighting for a week!\"", }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"The loss of president Nikolas Sarkozy and his wife is terrible.",
							"  ",
							"They revived Napoleon Bonaparte, how can you even think about that crazy little men!",
							"  ",
							"Paris and the Eiffel tower are destroyed but HADES is defeated!",
							"  ",
							"I feel that this war is coming to an end, I'm willing to finish it right now!",
							"  ",
							"I'm going to call HQ immediately to ask if there are still some countries under attack!",
							"  ", "Will report back to you in a day.\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: *hig* I think we won?! *hig* I don't know?! *hig* This is my rum paradise! *hig*",
							"  ",
							"I want more RUM and I want it now, Doutzen..!!",
							"  ",
							"..By the way Doutzen, why don't you spend the night in my apartment...? *hig*",
							"  ", "*hig* Such a pretty girls... *hig*\"" }),

			new Typewriter(
					new String[] {
							"Jack Sparrow: \"I'm proud of all of you my fellow heroes and my pretty, pretty Doutzen!",
							"  ",
							"These were probably the most terrifying years for the whole population of earth!",
							"But we could withstand the enormous powers of HADES corp.",
							"  ",
							"Kim Jong-Il and Hosni Mubarak made a final push in Rotterdam but we defeated",
							"them with our enormous powers!",
							"  ",
							"It's over now... all countries are rebuilding their destroyed capitals and are working",
							"together to create a better world.",
							"  ",
							"They are even talking about merging the countries on all continents so that",
							"the world only has a couple of big continents instead of countries!..",
							"  ",
							"Whahah who is actually the mastermind of that crazy idea?",
							"  ",
							"Nevertheless I just received my own island in the Atlantic ocean",
							"to live the rest of my life in peace together with my parrot and bottle of rum..",
							"  ",
							"You are of course always welcome to visit me! Peace..!",
							"  ",
							"Ohhh... Doutzen! Are you coming with me, we're going to have some fun!\"" }),
			new Typewriter(
					new String[] {
							"Jack Sparrow: \"You dissapoint me, lad. Do you want to reset your last spent points and try again?\"" }), };
	private boolean running = false;
	private boolean hasLost = false;

	private AudioClip[] audio;

	public Outro(Image[] sprites, AudioClip[] audio, Font[] fonts, int mapnumber) {
		this.sprites = sprites;
		this.audio = audio;
		this.fonts = fonts;
		this.mapnumber = mapnumber;
	}

	public void run(boolean hasLost) {
		this.running = true;
		this.hasLost = hasLost;

		t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (slideInn) {
					if (linksX < -280) {
						linksX += 15;
					} else if (linksX >= -280 && linksX < -180) {
						linksX += 10;
					} else if (linksX >= -180 && linksX <= -120) {
						linksX += 5;
					} else if (linksX >= -120 && linksX <= -80) {
						linksX += 3;
					} else if (linksX >= -80 && linksX <= -45) {
						linksX += 2;
					} else if (linksX >= -45 && linksX <= -20) {
						linksX += 1;
					} else if (linksX >= -20 && linksX <= 0) {
						if (pixelAdd == true) {
							linksX += 1;
							pixelAdd = false;
						} else {
							pixelAdd = true;
						}
					}
					if (rechtsX > 920) {
						rechtsX -= 15;
					} else if (rechtsX <= 920 && rechtsX > 820) {
						rechtsX -= 10;
					} else if (rechtsX <= 820 && rechtsX >= 760) {
						rechtsX -= 5;
					} else if (rechtsX <= 760 && rechtsX >= 720) {
						rechtsX -= 3;
					} else if (rechtsX <= 720 && rechtsX >= 685) {
						rechtsX -= 2;
					} else if (rechtsX <= 685 && rechtsX >= 660) {
						rechtsX -= 1;
					} else if (rechtsX <= 660 && rechtsX >= 640) {
						if (pixelAdd2 == true) {
							rechtsX -= 1;
							pixelAdd2 = false;
						} else {
							pixelAdd2 = true;
						}
					} else {
						slideInn = false;
					}
				}
				if (slideOut == true) {
					if (linksX > -360) {
						linksX -= 15;
					} else if (linksX <= -360 && linksX > -460) {
						linksX -= 10;
					} else if (linksX <= -460 && linksX >= -520) {
						linksX -= 5;
					} else if (linksX <= -520 && linksX >= -560) {
						linksX -= 3;
					} else if (linksX <= -560 && linksX >= -595) {
						linksX -= 2;
					} else if (linksX <= -595 && linksX >= -620) {
						linksX -= 1;
					} else if (linksX <= -620 && linksX >= -640) {
						if (pixelAdd2 == true) {
							linksX -= 1;
							pixelAdd2 = false;
						} else {
							pixelAdd2 = true;
						}
					}

					if (rechtsX < 1000) {
						rechtsX += 15;
					} else if (rechtsX >= 1000 && rechtsX < 1100) {
						rechtsX += 10;
					} else if (rechtsX >= 1100 && rechtsX <= 1160) {
						rechtsX += 5;
					} else if (rechtsX >= 1160 && rechtsX <= 1200) {
						rechtsX += 3;
					} else if (rechtsX >= 1200 && rechtsX <= 1235) {
						rechtsX += 2;
					} else if (rechtsX >= 1235 && rechtsX <= 1260) {
						rechtsX += 1;
					} else if (rechtsX >= 1260 && rechtsX <= 1280) {
						if (pixelAdd == true) {
							rechtsX += 1;
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

	public void update(long delta) {

	}

	public void paint(Graphics2D g) {
		if (!running) {
			return;
		}

		g.drawImage(sprites[0], 0, 0, null);
		g.setFont(fonts[1].deriveFont(Font.PLAIN, 16));
		g.setColor(new Color(97, 184, 109));
		g.drawImage(sprites[4], linksX, 0, null);
		g.drawImage(sprites[3], rechtsX, 0, null);

		if (!this.slideInn && !this.slideOut) {
			String[] str = null;
			if(!this.hasLost || mapnumber == 1)
				str = intro[mapnumber - 1].getText();
			else
				str = intro[10].getText();
			for (int i = 0; i < str.length; i++) {
				g.drawString(str[i], 185, 68 + (i * 20));
			}
		}
		g.drawImage(sprites[skipOver], 499 + rechtsX, 484, null);

	}

	public int doClick(Point c) {
		if (c.getX() > 1149 && c.getX() < 1249 && c.getY() > 494
				&& c.getY() < 594) {
			if(!slideInn){
				audio[1].play();
				slideOut = true;
			}
			// return 1;
		}
		return 0;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setSkip(int i) {
		skipOver = i;
		// System.out.println(skipOver);
	}
}
