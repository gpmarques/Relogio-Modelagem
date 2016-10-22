package Model;

import javax.swing.Timer;

public class ExhibitionState extends ClockState {
	
	public String status() {
		return "Exibição";
	}
	
	public ClockState aPressed(Timer timer) {
		timer.stop();
		return new SetHourState();
	}
	
	public ClockState bPressed(TimeManager time) {
		return null;
	}

	public ClockState aReleased() {
		return null;
	}	
	

}
