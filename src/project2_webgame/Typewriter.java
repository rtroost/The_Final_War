package project2_webgame;

import java.util.Timer;
import java.util.TimerTask;

public class Typewriter {

	private String[] fullText;
	private String[] currentText;
	private int line = 0;
	private Boolean enabled = false;
	
	public Typewriter(String[] fullText) {
		this.fullText = fullText;
		this.Reset();
	}
	
	public void Start() {
		this.Reset();
		enabled = true;
		
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if(fullText[line].length() != currentText[line].length())
				{
					currentText[line] += fullText[line].substring(currentText[line].length(), currentText[line].length() + 1);
				}
				else
				{
					if(line != (fullText.length - 1))
						line++;
				}
			}
		}, 0, 50);
	}
	
	public void Reset() {
		//Timer stop
		this.currentText = new String[fullText.length];
		for(int i = 0; i < currentText.length; i++) {
			currentText[i] = new String();
		}
		this.line = 0;
		enabled = false;
	}
	
	public String[] getText() {	
		if(!enabled)
			this.Start();
		return currentText;
	}
	
	public void AddLine(String s) {
		this.fullText[fullText.length] = s;
	}
}
