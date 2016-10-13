package Controller;

import javax.swing.Timer;
import View.*;

public class ClockController {
	
	private Timer timer;
	private AnalogueClockView analogueClock;
	private DigitalClockView digitalClock;
	
	public ClockController() { 
		
		timer = new Timer(1000, null);
		analogueClock = new AnalogueClockView("Relogio Analogico");
		digitalClock = new DigitalClockView("Relogio Digital");
	}
	

}
