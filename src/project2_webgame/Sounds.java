package project2_webgame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sounds {
	public static AudioClip getSound(String filename) {

		URL url = Playfield.class.getClassLoader().getResource(filename);
		AudioClip clip = Applet.newAudioClip(url);

		return clip;
	}
}