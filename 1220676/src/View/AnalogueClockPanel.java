package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class AnalogueClockPanel extends JPanel {
	
	private BufferedImage clockImage;
	private float second;
	private float minute;
	private float hour;
	private int centerX;
	private int centerY;
	private int size;
	private Calendar cal;
	
//	public AnalogueClockPanel(int size, float s) {
//		this.size = size;
//		this.second = s;
//		this.minute = s/60;
//		this.hour = minute/60;
//
//	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
        try {
        	clockImage = ImageIO.read(new File("Image/analogico.jpg"));
        } catch(IOException e) {
        	System.out.println(e.getMessage());
        	System.exit(1);
        }
		size = 550;
		centerY = size/2;
		centerX = size/2;
        g.drawImage(clockImage, 0, 0, size, size, null);
        drawHands(g2d);
        
	}
	
	public void setSeconds(float s) {
		this.second = s;
		this.minute = s/60;
		this.hour = minute/60;
		cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
	}
	
	
	private void drawHands(Graphics2D g) {
		
		double rsecond = (second*6)*(Math.PI)/180;
		double rminute = ((minute) * 6) * (Math.PI) / 180;
		double rhours = ((hour) * 30) * (Math.PI) / 180;
		System.out.println(rsecond);
		System.out.println(rminute);
		System.out.println(rhours);
				
		g.setColor(Color.RED);
		g.drawLine(centerX, centerY, centerX + (int) (150 * Math.cos(rsecond - (Math.PI / 2))), centerY + (int) (150 * Math.sin(rsecond - (Math.PI / 2))));
		g.setColor(Color.BLUE);
		g.drawLine(centerX, centerY, centerX + (int) (100 * Math.cos(rminute - (Math.PI / 2))), centerY + (int) (100 * Math.sin(rminute - (Math.PI / 2))));
		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, centerX + (int) (140 * Math.cos(rhours - (Math.PI / 2))), centerY + (int) (140 * Math.sin(rhours - (Math.PI / 2))));
		
	}

}
