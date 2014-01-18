package project2_webgame;

import java.applet.Applet;

public class App extends Applet {

	private static final long serialVersionUID = 1L;
	Playfield gui;

	@Override
	public void init() {
		gui = new Playfield();
		gui.setSize(1280, 640);
		gui.setFocusable(true);
		gui.requestFocus();
		this.setSize(1280, 640);
		this.setLayout(null);
		this.add(gui);
		this.setVisible(true);

		gui.showCanvas();
	}
}
