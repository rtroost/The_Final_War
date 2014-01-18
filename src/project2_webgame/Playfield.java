package project2_webgame;

import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.net.URL;

public class Playfield extends Canvas implements MouseMotionListener,
		MouseListener, KeyListener {

	private static final long serialVersionUID = 5445398101018047693L;
	private BufferStrategy strategy;

	int mapnumber = 1;

	private boolean firstTimeLoad = true;

	/** General game settings */
	public static final int WIDTH = 34;
	public static final int HEIGHT = 20;
	public static final int TILE_SIZE = 32;

	/** Game-object Instances */
	private MainMenu mainMenu;
	private Briefing briefing;
	private Map map;
	private Player player;
	private Player playerBackup;
	private WaveManager waveManager;
	private SideMenu sideMenu;
	private Credits credits;
	private Intro intro;
	private Outro outro;
	private Instructions instructions;

	/** In what window is the game currently? */
	private static final int MAINMENU = 1;
	private static final int INSTRUCTIONS = 2;
	private static final int BRIEFING = 3;
	private static final int PLAYFIELD = 4;
	private static final int INTRO = 5;
	private static final int OUTRO = 6;
	private static final int CREDITS = 7;
	private int windowState;

	private Thread mainThread;

	/** CONTENT */

	/** Load textures and instantiate variables */
	Image[] instructionTextures = new Image[] { getImage("resources/images/instructions_window.png"),
			getImage("resources/images/introoutro/skip.png"),
			getImage("resources/images/introoutro/skip_over.png"), };
	Image[] introOutroTextures = new Image[] {
			getImage("resources/images/introoutro/background_1.gif"),
			getImage("resources/images/introoutro/skip.png"),
			getImage("resources/images/introoutro/skip_over.png"),
			getImage("resources/images/introoutro/tro_rechts.png"),
			getImage("resources/images/introoutro/tro_links.png") };

	AudioClip[] introOutroAudio = new AudioClip[] {
			Sounds.getSound("resources/sounds/fade_sound.wav"),
			Sounds.getSound("resources/sounds/mainmenu_outro.wav"), };

	AudioClip[] waveManagerAudio = new AudioClip[] { Sounds
			.getSound("resources/sounds/loopmusic.wav"), };

	/** Load MainMenu textures */
	Image[][] mainMenuTextures = new Image[][] {
			{
					getImage("resources/images/mainmenu/background_1.gif"),
					getImage("resources/images/mainmenu/background.gif"),
					getImage("resources/images/mainmenu/background.png"),
					getImage("resources/images/mainmenu/Instruction_left.png"),
					getImage("resources/images/mainmenu/Instructions_right.png"),
					getImage("resources/images/mainmenu/Background_links.png"),
					getImage("resources/images/mainmenu/Background_rechts.png"), },
			{ getImage("resources/images/mainmenu/new_game.png"),
					getImage("resources/images/mainmenu/new_game_rollover.png") },
			{
					getImage("resources/images/mainmenu/instructions.png"),
					getImage("resources/images/mainmenu/instructions_rollover.png") },
			{ getImage("resources/images/mainmenu/credits.png"),
					getImage("resources/images/mainmenu/credits_rollover.png"), }, };

	AudioClip[] mainMenuAudio = new AudioClip[] {
			Sounds.getSound("resources/sounds/mainmenu_intro.wav"),
			Sounds.getSound("resources/sounds/buttons_intro.au"),
			Sounds.getSound("resources/sounds/mainmenu_mouseover.wav"),
			Sounds.getSound("resources/sounds/mainmenu_outro.wav"), };

	/** Load briefing textures */
	Image[][] briefingTextures = new Image[][] {
			{ getImage("resources/images/briefing/sidebar_right.png"),
					getImage("resources/images/briefing/sidebar_left.png"),
					getImage("resources/images/briefing/Jack_Sparrow.gif"),
					getImage("resources/images/briefing/startlevel.png"),
					getImage("resources/images/briefing/money.png"),
					getImage("resources/images/briefing/no_buy.png"),
					getImage("resources/images/briefing/background_1.png"),
					getImage("resources/images/briefing/background_2.png"),
					getImage("resources/images/briefing/background_3.png"),
					getImage("resources/images/briefing/background_4.png"),
					getImage("resources/images/briefing/background_5.png"),
					getImage("resources/images/briefing/background_6.png"),
					getImage("resources/images/briefing/background_7.png"),
					getImage("resources/images/briefing/background_8.png"),
					getImage("resources/images/briefing/background_9.png"),
					getImage("resources/images/briefing/background_10.png"), },
			{
					/** Avatars */
					getImage("resources/images/briefing/Jack_Sparrow.png"),
					getImage("resources/images/briefing/Doutzen_Kroes.png"),
					getImage("resources/images/briefing/Michael_Jackson.png"),
					getImage("resources/images/briefing/Steve_Jobs.png"),
					getImage("resources/images/briefing/Johan_Derksen.png"),
					getImage("resources/images/briefing/Stephen_Hawking.png"),
					getImage("resources/images/briefing/Martin_Luther_King.png"),
					getImage("resources/images/briefing/Mr_Bean.png"),
					getImage("resources/images/briefing/Mario_Balotelli.png"),
					getImage("resources/images/briefing/Albert_Al_Gore.png"), },
			{ getImage("resources/images/briefing/Info_frame_big.png"),
					getImage("resources/images/briefing/Info_frame_small.png"), },
			{ getImage("resources/images/briefing/buy.png"),
					getImage("resources/images/briefing/buyOver.png"), },
			{ getImage("resources/images/briefing/plus.png"),
					getImage("resources/images/briefing/plusOver.png"), }, };

	AudioClip[][] briefingAudio = new AudioClip[][] {
			{ Sounds.getSound("resources/sounds/briefing_menu.wav"),
					Sounds.getSound("resources/sounds/mainmenu_outro.wav"), },
			{ Sounds.getSound("resources/sounds/Jack_Sparrow.wav"),
					Sounds.getSound("resources/sounds/Doutzen_Kroes.wav"),
					Sounds.getSound("resources/sounds/Michael_Jackson.wav"),
					Sounds.getSound("resources/sounds/Steve_Jobs.wav"),
					Sounds.getSound("resources/sounds/Johan_Derksen.wav"),
					Sounds.getSound("resources/sounds/Stephen_Hawking.wav"),
					Sounds.getSound("resources/sounds/Martin_Luther_King.wav"),
					Sounds.getSound("resources/sounds/Mr_Bean.wav"),
					Sounds.getSound("resources/sounds/Mario_Balotelli.wav"),
					Sounds.getSound("resources/sounds/Albert_Al_Gore.wav"), }, };

	/** Load map textures */
	Image[][] mapTextures = new Image[][] {
			{ getImage("resources/images/maps/map1.png"),
					getImage("resources/images/maps/map2.png"),
					getImage("resources/images/maps/map3.png"),
					getImage("resources/images/maps/map4.png"),
					getImage("resources/images/maps/map5.png"),
					getImage("resources/images/maps/map6.png"),
					getImage("resources/images/maps/map7.png"),
					getImage("resources/images/maps/map8.png"),
					getImage("resources/images/maps/map9.png"),
					getImage("resources/images/maps/map10.png"), },
			{ // MAP 1 1-3
			getImage("resources/images/enemies/Egypte/Male/walk.gif"),
					getImage("resources/images/enemies/Egypte/Male/die.gif"), },
			{ getImage("resources/images/enemies/Egypte/Female/walk.gif"),
					getImage("resources/images/enemies/Egypte/Female/die.gif") },
			{
					getImage("resources/images/enemies/Egypte/Cleopatra/walk.gif"),
					getImage("resources/images/enemies/Egypte/Cleopatra/die.gif") },
			{ // Map 2 4 -6
			getImage("resources/images/enemies/map2/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map2/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map2/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map2/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map2/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map2/Enemy3/die.gif") },
			{ // MAP 3 7-9
			getImage("resources/images/enemies/map3/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map3/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map3/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map3/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map3/Qadhafi/walk.gif"),
					getImage("resources/images/enemies/map3/Qadhafi/die.gif") },
			{ // MAP 4 10 -13
			getImage("resources/images/enemies/map4/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map4/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map4/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map4/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map4/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map4/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map4/Mladic/walk.gif"),
					getImage("resources/images/enemies/map4/Mladic/die.gif") },
			{ // MAP 5 14 - 17
			getImage("resources/images/enemies/map5/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map5/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map5/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map5/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map5/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map5/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map5/Stalin/walk.gif"),
					getImage("resources/images/enemies/map5/Stalin/die.gif") },
			{ // MAP 6 18 - 21
			getImage("resources/images/enemies/map6/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map6/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map6/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map6/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map6/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map6/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map6/Hoessein/walk.gif"),
					getImage("resources/images/enemies/map6/Hoessein/die.gif") },
			{ // MAP 7 22 - 25
			getImage("resources/images/enemies/map7/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map7/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map7/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map7/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map7/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map7/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map7/Caesar/walk.gif"),
					getImage("resources/images/enemies/map7/Caesar/die.gif") },
			{ // MAP 8 26 - 29
			getImage("resources/images/enemies/map8/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map8/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map8/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map8/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map8/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map8/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map8/Napoleon/walk.gif"),
					getImage("resources/images/enemies/map8/Napoleon/die.gif") },
			{ // MAP 9 30 - 33
			getImage("resources/images/enemies/map9/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map9/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map9/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map9/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map9/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map9/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map9/Castro/walk.gif"),
					getImage("resources/images/enemies/map9/Castro/die.gif") },
			{ // MAP 10 34 - 38
			getImage("resources/images/enemies/map10/Enemy1/walk.gif"),
					getImage("resources/images/enemies/map10/Enemy1/die.gif") },
			{ getImage("resources/images/enemies/map10/Enemy2/walk.gif"),
					getImage("resources/images/enemies/map10/Enemy2/die.gif") },
			{ getImage("resources/images/enemies/map10/Enemy3/walk.gif"),
					getImage("resources/images/enemies/map10/Enemy3/die.gif") },
			{ getImage("resources/images/enemies/map10/Il/walk.gif"),
					getImage("resources/images/enemies/map10/Il/die.gif") },
			{ getImage("resources/images/enemies/map10/Mubarak/walk.gif"),
					getImage("resources/images/enemies/map10/Mubarak/die.gif") },

	};

	/** Load player textures */
	Image[][] playerTextures = new Image[][] {
			{
					getImage("resources/images/heroes/Cpt_Jack_Sparrow/stand.gif"),
					getImage("resources/images/heroes/Cpt_Jack_Sparrow/run.gif"),
					getImage("resources/images/heroes/Cpt_Jack_Sparrow/jump.gif"),
					getImage("resources/images/heroes/Cpt_Jack_Sparrow/attack.gif"),
					getImage("resources/images/heroes/Cpt_Jack_Sparrow/projectile.png"),
					getImage("resources/images/heroes/Cpt_Jack_Sparrow/Jack_Sparrow_sideMenu.png"), },

			{
					getImage("resources/images/heroes/Doutzen_Kroes/stand.gif"),
					getImage("resources/images/heroes/Doutzen_Kroes/run.gif"),
					getImage("resources/images/heroes/Doutzen_Kroes/jump.gif"),
					getImage("resources/images/heroes/Doutzen_Kroes/attack.gif"),
					getImage("resources/images/heroes/Doutzen_Kroes/projectile.png"),
					getImage("resources/images/heroes/Doutzen_Kroes/Doutzen_Kroes_sideMenu.png"), },
			{
					getImage("resources/images/heroes/Michael_Jackson/stand.gif"),
					getImage("resources/images/heroes/Michael_Jackson/run.gif"),
					getImage("resources/images/heroes/Michael_Jackson/jump.gif"),
					getImage("resources/images/heroes/Michael_Jackson/attack.gif"),
					getImage("resources/images/heroes/Michael_Jackson/projectile.png"),
					getImage("resources/images/heroes/Michael_Jackson/Michael_Jackson_sideMenu.png"), },
			{
					getImage("resources/images/heroes/Steve_Jobs/stand.gif"),
					getImage("resources/images/heroes/Steve_Jobs/run.gif"),
					getImage("resources/images/heroes/Steve_Jobs/jump.gif"),
					getImage("resources/images/heroes/Steve_Jobs/attack.gif"),
					getImage("resources/images/heroes/Steve_Jobs/projectile.png"),
					getImage("resources/images/heroes/Steve_Jobs/Steve_Jobs_sideMenu.png"), },
			{
					getImage("resources/images/heroes/Johan_Derksen/stand.gif"),
					getImage("resources/images/heroes/Johan_Derksen/run.gif"),
					getImage("resources/images/heroes/Johan_Derksen/jump.gif"),
					getImage("resources/images/heroes/Johan_Derksen/attack.gif"),
					getImage("resources/images/heroes/Johan_Derksen/projectile.png"),
					getImage("resources/images/heroes/Johan_Derksen/Johan_Derksen_sideMenu.png"), },
					
			{ 		getImage("resources/images/heroes/Stephen_Hawking/stand.gif"),
					getImage("resources/images/heroes/Stephen_Hawking/run.gif"),
					getImage("resources/images/heroes/Stephen_Hawking/jump.gif"),
					getImage("resources/images/heroes/Stephen_Hawking/attack.gif"),
					null,
					getImage("resources/images/heroes/Stephen_Hawking/Stephen_Hawking_sideMenu.png"),
							},
			{
					getImage("resources/images/heroes/Martin_Luther_King/stand.gif"),
					getImage("resources/images/heroes/Martin_Luther_King/run.gif"),
					getImage("resources/images/heroes/Martin_Luther_King/jump.gif"),
					getImage("resources/images/heroes/Martin_Luther_King/attack.gif"),
					null,
					getImage("resources/images/heroes/Martin_Luther_King/Martin_Luther_King_sideMenu.png"), },
			{
					getImage("resources/images/heroes/Mr_Bean/stand.gif"),
					getImage("resources/images/heroes/Mr_Bean/run.gif"),
					getImage("resources/images/heroes/Mr_Bean/jump.gif"),
					getImage("resources/images/heroes/Mr_Bean/attack.gif"),
					getImage("resources/images/heroes/Mr_Bean/projectile.png"),
					getImage("resources/images/heroes/Mr_Bean/Mr_Bean_sideMenu.png"), },
			{
					getImage("resources/images/heroes/Mario_Balotelli/stand.gif"),
					getImage("resources/images/heroes/Mario_Balotelli/run.gif"),
					getImage("resources/images/heroes/Mario_Balotelli/jump.gif"),
					getImage("resources/images/heroes/Mario_Balotelli/attack.gif"),
					null,
					getImage("resources/images/heroes/Mario_Balotelli/Mario_Balotelli_sideMenu.png"), },
			{
					getImage("resources/images/heroes/Albert_Arnold_Al_Gore/stand.gif"),
					getImage("resources/images/heroes/Albert_Arnold_Al_Gore/run.gif"),
					getImage("resources/images/heroes/Albert_Arnold_Al_Gore/jump.gif"),
					getImage("resources/images/heroes/Albert_Arnold_Al_Gore/attack.gif"),
					getImage("resources/images/heroes/Albert_Arnold_Al_Gore/projectile.png"),
					getImage("resources/images/heroes/Albert_Arnold_Al_Gore/Albert_Al_Gore_sideMenu.png"), } };
	
	AudioClip[] playerAudio = new AudioClip[] {
			 Sounds.getSound("resources/sounds/leven_kwijt.wav"),
			 };
	
	Image[] sideMenuTextures = new Image[] {
			getImage("resources/images/game_menu/game_menu.png"),
			getImage("resources/images/game_menu/game_menu_life_bar.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl1.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl2.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl3.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl4.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl5.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl6.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl7.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl8.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl9.png"),
			getImage("resources/images/game_menu/game_menu_button_lvl10.png"), };

	Font[] fonts = new Font[] { Fonts.getFont("resources/fonts/TFW.ttf"),
			Fonts.getFont("resources/fonts/Fixedsys.ttf"), };
	
	/** END OF CONTENT */

	public Playfield() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		loadContent();
	}

	@Override
	public void addNotify() {
		super.addNotify();
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}

	private void loadContent() {
		if (mapnumber == 1) {
			map = new Map01(mapTextures);
		} else if (mapnumber == 2) {
			map = new Map02(mapTextures);
		} else if (mapnumber == 3) {
			map = new Map03(mapTextures);
		} else if (mapnumber == 4) {
			map = new Map04(mapTextures);
		} else if (mapnumber == 5) {
			map = new Map05(mapTextures);
		} else if (mapnumber == 6) {
			map = new Map06(mapTextures);
		} else if (mapnumber == 7) {
			map = new Map07(mapTextures);
		} else if (mapnumber == 8) {
			map = new Map08(mapTextures);
		} else if (mapnumber == 9) {
			map = new Map09(mapTextures);
		} else if (mapnumber == 10) {
			map = new Map10(mapTextures);
		}

		intro = new Intro(introOutroTextures, introOutroAudio, fonts, mapnumber);
		outro = new Outro(introOutroTextures, introOutroAudio, fonts, mapnumber);

		briefing = new Briefing(briefingTextures, briefingAudio, fonts, mapnumber);
		waveManager = new WaveManager(waveManagerAudio);
		if (firstTimeLoad) {
			instructions = new Instructions(instructionTextures);
			mainMenu = new MainMenu(mainMenuTextures, mainMenuAudio);
			sideMenu = new SideMenu(sideMenuTextures, fonts);
			player = new Player(playerTextures, playerAudio);
			credits = new Credits();

			firstTimeLoad = false;
		}
		sideMenu.setReferences(player, waveManager, mapnumber);
		player.setReferences(map, waveManager);
		map.setReferences(player, waveManager, mapnumber);
		waveManager.setReferences(map);
		sideMenu.setReferences(player, waveManager, mapnumber);
		credits.setReferences(player);
		briefing.setReferences(player);
	}

	private void setBackup() {
		try {
			this.playerBackup = (Player) this.player.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	private void restoreBackup() {
		this.player = this.playerBackup;
		this.player.restoreBackup();
	}

	private Image getImage(String s) {
		System.out.println("Fetching image -> " + s);
		ClassLoader cl = this.getClass().getClassLoader();
		URL url = cl.getResource(s);
		Image img = Toolkit.getDefaultToolkit().createImage(url);
		return img;
	}

	public void showCanvas() {
		goMainMenu();
	}

	/** Main Menu */

	private void goMainMenu() {
		this.windowState = MAINMENU;
		//mainMenu = new MainMenu(mainMenuTextures, mainMenuAudio);
		mainMenu.setRunning(true);
		/** Start the new thread */
		mainThread = new Thread(new mainMenuLoop());
		mainThread.start();
	}

	private class mainMenuLoop extends Thread {

		@Override
		public void run() {
			mainMenuLoop();
		}
	}

	private void mainMenuLoop() {
		long lastLoopTime = System.nanoTime();

		while (mainMenu.isRunning()) {
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++)
				mainMenu.update(5);
			if ((delta % 5) != 0)
				mainMenu.update(delta % 5);

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				mainMenu.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}

	/** Instructions */

	private void goInstructions() {
		this.windowState = INSTRUCTIONS;

		instructions.run();

		/** Start the new thread */
		mainThread = new Thread(new InstructionsLoop());
		mainThread.start();
	}

	private class InstructionsLoop extends Thread {

		@Override
		public void run() {
			InstructionsLoop();
		}
	}

	private void InstructionsLoop() {
		long lastLoopTime = System.nanoTime();

		while (instructions.isRunning()) {
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++)
				instructions.update(5);
			if ((delta % 5) != 0)
				instructions.update(delta % 5);

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				instructions.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}

	/** Briefing */

	private void goBriefing() {
		this.windowState = BRIEFING;
		briefing.run();

		this.setBackup();

		/** Start the new thread */
		mainThread = new Thread(new BriefingLoop());
		mainThread.start();
	}

	private class BriefingLoop extends Thread {

		@Override
		public void run() {
			BriefingLoop();
		}
	}

	private void BriefingLoop() {

		long lastLoopTime = System.nanoTime();

		while (briefing.isRunning()) {
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++)
				briefing.update(5);
			if ((delta % 5) != 0)
				briefing.update(delta % 5);

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				briefing.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}

	/** Briefing */

	private void goIntro() {
		this.windowState = INTRO;

		intro.run();

		/** Start the new thread */
		mainThread = new Thread(new IntroLoop());
		mainThread.start();
	}

	private class IntroLoop extends Thread {

		@Override
		public void run() {
			IntroLoop();
		}
	}

	private void IntroLoop() {
		long lastLoopTime = System.nanoTime();

		while (intro.isRunning()) {
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++)
				intro.update(5);
			if ((delta % 5) != 0)
				intro.update(delta % 5);

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				intro.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}

		this.goPlayfield();
	}

	/** Game */

	private void goPlayfield() {
		this.windowState = PLAYFIELD;
		waveManager.run();
		player.setStartPositions(map.getStartPositions());
		// player.setBackup();

		/** Start the new thread */
		mainThread = new Thread(new GamefieldLoop());
		mainThread.start();
	}

	private class GamefieldLoop extends Thread {

		@Override
		public void run() {
			GamefieldLoop();
		}
	}

	private void GamefieldLoop() {
		createBufferStrategy(2);
		strategy = getBufferStrategy();

		long lastLoopTime = System.nanoTime();
		
		while (player.getLives() > 0 && waveManager.isRunning()) { // IsNotDead?
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++) {
				map.update(5);
				player.update(5);
				waveManager.update(5);
				sideMenu.update(5);
			}
			if ((delta % 5) != 0) {
				map.update(delta % 5);
				player.update(delta % 5);
				waveManager.update(delta % 5);
				sideMenu.update(delta % 5);
			}

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				map.paint(g);
				player.paint(g);
				waveManager.paint(g);
				sideMenu.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}

		/** Game ended */
		
		//if(mapnumber == 1)
			//player.setLives(10);
		
		goOutro();
	}

	/** Outro */

	private void goOutro() {
		this.windowState = OUTRO;
		if(player.getLives() > 0)
			outro.run(false);
		else
			outro.run(true);

		/** Start the new thread */
		mainThread = new Thread(new OutroLoop());
		mainThread.start();
	}

	private class OutroLoop extends Thread {

		@Override
		public void run() {
			OutroLoop();
		}
	}

	private void OutroLoop() {
		long lastLoopTime = System.nanoTime();

		while (outro.isRunning()) { // IsNotDead?
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++) {
				outro.update(5);
			}
			if ((delta % 5) != 0) {
				outro.update(delta % 5);
			}

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				outro.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}

		if (mapnumber != 10) {
			if (player.getLives() <= 0 && this.mapnumber != 1) {
				this.restoreBackup();
			} else {
				this.mapnumber++;
			}
			player.mapChange();
			waveManager.mapChange();
			this.loadContent();
			this.goBriefing();
		} else {
			if(player.getLives() <= 0){
				this.restoreBackup();
				player.mapChange();
				waveManager.mapChange();
				this.loadContent();
				this.goBriefing();
			} else {
				goCredits();
			}
		}
		
	}

	/** Credits */

	private void goCredits() {
		this.windowState = CREDITS;
		credits.run();

		/** Start the new thread */
		mainThread = new Thread(new CreditsLoop());
		mainThread.start();
	}

	private class CreditsLoop extends Thread {

		@Override
		public void run() {
			CreditsLoop();
		}
	}

	private void CreditsLoop() {
		long lastLoopTime = System.nanoTime();

		while (credits.isRunning()) {
			long delta = (System.nanoTime() - lastLoopTime) / 1000000;
			lastLoopTime = System.nanoTime();

			/** Update */
			for (int i = 0; i < delta / 5; i++) {
				credits.update(5);
			}
			if ((delta % 5) != 0) {
				credits.update(delta % 5);
			}

			/** Draw */
			if (this.isShowing()) {
				Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

				credits.paint(g);

				/** Render */
				g.dispose();
				strategy.show();
			}

			/** Sleep */
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Invoked when a mouse button is pressed on a component and then
		// dragged.
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Invoked when the mouse cursor has been moved onto a component but no
		// buttons have been pushed.

		if (this.windowState == MAINMENU && mainMenu.isSlideIn()) {
			// New game
			if (e.getX() > 90 && e.getX() < 340 && e.getY() > 457
					&& e.getY() < 492) {
				mainMenu.setNewGamePic(1);
			} else {
				mainMenu.setNewGamePic(0);
			}

			// Instructions
			if (e.getX() > 505 && e.getX() < 805 && e.getY() > 453
					&& e.getY() < 495) {
				mainMenu.setInstructionsPic(1);
			} else {
				mainMenu.setInstructionsPic(0);
			}

			// Credits
			if (e.getX() > 981 && e.getX() < 1164 && e.getY() > 458
					&& e.getY() < 493) {
				mainMenu.setCreditsPic(1);
			} else {
				mainMenu.setCreditsPic(0);
			}
			return;
		}
		
		if (this.windowState == INSTRUCTIONS) {
			if (e.getX() > 1149 && e.getX() < 1249 && e.getY() > 494
					&& e.getY() < 594) {
				instructions.setSkip(2);
			} else {
				instructions.setSkip(1);
			}
			return;
		}
		
		if (this.windowState == BRIEFING && briefing.isSlideIn()) {

			// damage button
			if (e.getX() > 1237 && e.getX() < 1270 && e.getY() > 360
					&& e.getY() < 394) {
				briefing.setPlus1(1);
			} else {
				briefing.setPlus1(0);
			}

			// speed
			if (e.getX() > 1237 && e.getX() < 1270 && e.getY() > 402
					&& e.getY() < 435) {
				briefing.setPlus2(1);
			} else {
				briefing.setPlus2(0);
			}

			// range
			if (e.getX() > 1237 && e.getX() < 1270 && e.getY() > 444
					&& e.getY() < 477) {
				briefing.setPlus3(1);
			} else {
				briefing.setPlus3(0);
			}

			// fire speed
			if (e.getX() > 1237 && e.getX() < 1270 && e.getY() > 486
					&& e.getY() < 519) {
				briefing.setPlus4(1);
			} else {
				briefing.setPlus4(0);
			}

			if (e.getX() > 1101 && e.getX() < 1245 && e.getY() > 584
					&& e.getY() < 616) {
				briefing.setBuyButtonNumber(1);
			} else {
				briefing.setBuyButtonNumber(0);
			}
			return;
		}
		if (this.windowState == PLAYFIELD) {
			return;
		}

		if (this.windowState == INTRO) {
			if (e.getX() > 1149 && e.getX() < 1249 && e.getY() > 494
					&& e.getY() < 594) {
				intro.setSkip(2);
			} else {
				intro.setSkip(1);
			}
			return;
		}
		


		if (this.windowState == OUTRO) {
			if (e.getX() > 1149 && e.getX() < 1249 && e.getY() > 494
					&& e.getY() < 594) {
				outro.setSkip(2);
			} else {
				outro.setSkip(1);
			}
			return;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (this.windowState == MAINMENU) {
			int state = mainMenu.doClick(e.getPoint());
			if (state == 1)
				this.goBriefing();
			if (state == 2)
				this.goInstructions();
			if (state == 3)
				this.goCredits();
			return;
		}
		
		if (this.windowState == INSTRUCTIONS) {
			int state = instructions.doClick(e.getPoint());
			if (state == 1) {
				//System.out.println("true");
				//instructions.setRunning(false);
				goMainMenu();
			}
			return;
		}
		
		if (this.windowState == INTRO) {
			int state = intro.doClick(e.getPoint());
			if (state == 1) {
				this.goPlayfield();
			}
			return;
		}

		if (this.windowState == OUTRO) {
			int state = outro.doClick(e.getPoint());
			if (state == 1) {
				outro.setRunning(false);
			}
			return;
		}

		if (this.windowState == BRIEFING) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				briefing.doRightClick(e.getPoint());
			} else {
				int state = briefing.doClick(e.getPoint());
				if (state == 1) {
					this.goIntro();
				}
			}
			return;
		}
		if (this.windowState == PLAYFIELD) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				if (e.getX() < (WIDTH * TILE_SIZE)
						&& e.getY() < (HEIGHT * TILE_SIZE)) {
					/** Do stuff when player clicks in the playground-area */
					Unit _u = player.requestUnitOnSpot(e.getX(), e.getY());
					if (_u != null) {
						return;
					} else {
						if (player.getSelectedUnit() != null) {
							player.setSelectedUnit(null);
						}
					}
				} else {
					/** Do stuff when player clicks outside the playground-area */
					// sideMenu.doClick(e.getPoint());
				}
			} else {
				if (e.getX() < (WIDTH * TILE_SIZE)
						&& e.getY() < (HEIGHT * TILE_SIZE)) {
					/** Do stuff when player clicks in the playground-area */
					Unit _u = player.requestUnitOnSpot(e.getX(), e.getY());
					if (_u != null) {
						player.setSelectedUnit(_u);
					} else {
						if (player.getSelectedUnit() != null) {
							player.getSelectedUnit().newPosition(e.getX(),
									e.getY());
						}
					}
				} else {
					/** Do stuff when player clicks outside the playground-area */
					sideMenu.doClick(e.getPoint());
				}
				return;
			}
		}
		return;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (this.windowState == CREDITS) {
			
			int id = arg0.getKeyCode();
			System.out.println(id);
			if (id == 27) {
//				System.out.println("true");
//				//instructions.setRunning(false);
				System.out.println("true");
				credits.setRunning(false);
				goMainMenu();
			}
			return;
		}
		if (this.windowState == PLAYFIELD) {
			int id = arg0.getKeyCode();
			int f = 0;
			switch (id) {
			case 112:
			case 49:
				f = 1;
				break;
			case 113:
			case 50:
				f = 2;
				break;
			case 114:
			case 51:
				f = 3;
				break;
			case 115:
			case 52:
				f = 4;
				break;
			case 116:
			case 53:
				f = 5;
				break;
			case 117:
			case 54:
				f = 6;
				break;
			case 118:
			case 55:
				f = 7;
				break;
			case 119:
			case 56:
				f = 8;
				break;
			case 120:
			case 57:
				f = 9;
				break;
			case 121:
			case 48:
				f = 10;
				break;
			}
			Unit[] activeunits = player.getUnits();
			for (int i = 0; i < activeunits.length; i++) {
				if (activeunits[i].getEnabled()) {
					if (f == (i + 1)) {
						player.setSelectedUnit(activeunits[i]);
						// _selectedUnit = activeunits[i];
						break;
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public Player getPlayer() {
		return player;
	}

	public Map getMap() {
		return map;
	}

	public WaveManager getWaveManager() {
		return waveManager;
	}

	public SideMenu getSideMenu() {
		return sideMenu;
	}
}
