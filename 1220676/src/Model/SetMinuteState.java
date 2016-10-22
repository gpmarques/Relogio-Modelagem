package Model;

import javax.swing.Timer;

public class SetMinuteState extends ClockState {
	
	public String status() {
		return "Ajusta Minuto";
	}
	
	public ClockState aPressed(Timer timer) {
		timer.start();
		return new ExhibitionState();
	}
	
	public ClockState bPressed(TimeManager time) {
		time.incrementMinute();
		return null;
	}

	public ClockState aReleased() {
		return null;
	}

}
