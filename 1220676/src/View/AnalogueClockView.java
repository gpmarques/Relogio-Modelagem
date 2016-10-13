package View;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AnalogueClockView extends JFrame {
		
	private Timer timer;
	private AnalogueClockPanel panel;
	private float second;
	
	public AnalogueClockView(String title) {
		super();
		// TODO Auto-generated constructor stub
		
		setTitle(title);
		setSize(550, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		this.second = 0;
		panel = new AnalogueClockPanel();
		panel.setSeconds(second);
		panel.setLayout(null);
		getContentPane().add(panel);
		
        ActionListener incrementingTime = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                second += 1;
                panel.setSeconds(second);
                getContentPane().validate();
                getContentPane().repaint();
            }
        };
        
		timer = new Timer(1000, incrementingTime);
		startTimer();

	}
	
	private void startTimer() {
		timer.start();
	}
	
	private void stopTimer() {
		timer.stop();
	}
	
}
