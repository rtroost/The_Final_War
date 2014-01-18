package project2_webgame;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Intro {

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
			       "21-12-2021, Jack Sparrow: \"Fellow heroes from earth, I'm currently in Egypt for some promotion work",
			       "for one of my great movies...",
			       "  ",
			       "It seems like there are very strange things going on over here; As far as I saw the old president",
			       "from Egypt, Mubarak is reviving dead bodies to create and unbeatable army...",
			       "  ",
			       "I can't believe my own eyes. I'm going to take a closer look! Argh... Why is there always something",
			       "going on in this world, I just want to enjoy my woman and my rum!",
			       "  ",
			       "I will report back to you guys and Doutzen within 2 days.\"" }),

			   new Typewriter(
			     new String[] {
			       "03-01-2022, Jack Sparrow: \"Thanks for your fast response my dear friends.",
			       "  ",
			       "I off course didn't expect anything else from you, haha! We're currently heading to South-Korea.",
			       "  ",
			       "Headquarters send spies to all countries in the world to keep us up to date with all the necessary",
			       "information about the war.",
			       "  ",
			       "HQ told me that the HADES corp. army is currently attacking the gates of Seoul in South-Korea.",
			       "  ",
			       "We are going to defend the civilians of South-Korea, Hooooray!\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow: \"This is insane! Moammar al-Qadhafi joined the HADES corp.",
			       "and is using the Libyan army to attack civilians, is he out of his mind?",
			       "  ",
			       "Is world domination thousands and thousands of dead civilians worth it?",
			       "  ",
			       "..At least killing woman is not worth it... I'm getting sick of this!",
			       "  ",
			       "Heroes, pick up your weapons and fight!",
			       "  ",
			       "FREE LIBYA and KILL this freak called Qadhafi! Oh... and don't forget to kill his generals either...\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow:  \"Heroes, you can't believe this! Of all possible places, HADES corp.",
			       "is currently attacking Serbia.",
			       "  ",
			       "Luckily you all had some food and rest to fight again...",
			       "  ",
			       "I actually don't know why they are attacking Serbia, let's find out!",
			       "  ",
			       "Unite in the main capital Belgrade to finish this dirty jobs fast!",
			       "  ",
			       "And don't forget your warm clothes... It'll be freezing... I guess...\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow: \"The coldest winter ever, and where are we?! In damned Russia!...",
			       "  ",
			       "I'm glad Doutzen is such a pretty girl, now at least something is pretty in Russia...",
			       "  ",
			       "Ok friends, this is what happened. Those idiots revived Stalin and Stalin killed president Poetin.",
			       "  ",
			       "Stalin wants to kill everyone in Russia except the HADES corp. army, he is doing this by stopping",
			       "the food supplies and thus creating a famine... And no supply means no rum, we have to stop him!",
			       "  ",
			       "We have no choice, follow my lead to the centre of the capital!\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow: \"Wow! What a party! A well earned party!...",
			       "  ",
			       "But it's over friends, were heading immediately to Iraq. HADES corp. launched a nuclear bomb on Iraq,",
			       "about 60% of the population died, we are going to save the others!",
			       "  ", "Gather in my plane within 1 hour...\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow: \"Fellow heroes and pretty Doutzen, I feel immortality!",
			       "  ",
			       "I there anyone that can defeat us? Muhaha, of course not!",
			       "  ",
			       "They are attacking Rome this time, they probably revived some Italian loser.",
			       "  ",
			       "Well... have fun guys, sharpen your blades, kiss your parrot and let's end this horrible nightmare!",
			       "  ",
			       "Free rum for everyone when we are victorious!\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow: \"I'm fit again and ready to fight!",
			       "  ",
			       "President Nikolas Sarkozy and his wife Carla Bruni are murdered in France by some revived freak...",
			       "  ",
			       "What idiot kills such as elegant woman as Carla Bruni! Is this ever going to end?",
			       "  ",
			       "They can't keep this up forever, every country is defending their walls as never before.",
			       "  ",
			       "They cannot invade that easy anymore. HQ ordered us to go to Paris, move, move, move!!\"" }),

			   new Typewriter(
			     new String[] {
			       "Jack Sparrow: \"My friends, my heroes and my Doutzen! HQ told us that we are going to Cuba!",
			       "  ",
			       "Oh men, I love Cuba! They have the best rum in the world! I'm not letting HADES destroy MY rum!",
			       "  ",
			       "I heard some rumors that Fidel Castro joined HADES corp. and is destroying my beautiful rum...",
			       "  ",
			       "Well ok, if thats what he want, this will be his end!\"" }),

			   new Typewriter(
			     new String[] {
			       "12-03-2024, Jack Sparrow: \"I'm sorry me dear friends and Doutzen, I drunk to much rum in Cuba.",
			       "  ",
			       "But that's what you get when you set a country free from a dictator and everybody is feeding you rum",
			       "like there is no tomorrow and guess what, I'm an evil pirate and evil pirates love rum!",
			       "  ",
			       "We even love rum more than we love women!",
			       "  ",
			       "Nevertheless, we are going to prepare us for the final battle!",
			       "I just received information from HQ that HADES corp. is making a final offense.",
			       "  ",
			       "They are attacking the capital of Rotterdam in The Netherlands for a final push to take over Europe.",
			       "  ",
			       "Haha those losers, do they actually think that they can win from us?",
			       "  ",
			       "Head to the bunkers of Hoek van Holland, it's a small town just 30 minutes away from Rotterdam.",
			       "We gather in Hoek van Holland to stop the final push of HADES corp.",
			       "  ",
			       "Be fast! HADES corp. already started bombing Rotterdam!\"" }) };
	private boolean running = false;

	private AudioClip[] audio;

	public Intro(Image[] sprites, AudioClip[] audio, Font[] fonts, int mapnumber) {
		this.sprites = sprites;
		this.audio = audio;
		this.fonts = fonts;
		this.mapnumber = mapnumber;
	}

	public void run() {
		this.running = true;

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

		if(!this.slideInn && !this.slideOut) {
			String[] str = intro[mapnumber - 1].getText();
			for(int i = 0; i < str.length; i++) {
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
	}
}
