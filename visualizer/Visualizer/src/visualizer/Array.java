package visualizer;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.*;

public class Array extends JPanel {
	
	
	public int[] array;
	public boolean sorted;
	JFrame window;
	
	public Array(JFrame window) {
		this.window = window;
		this.setBackground(new Color(100,100,20,0));
		this.setOpaque(false);
		this.setBounds(0, 300, 600, 400);
		array = new int[100];
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}	
		this.sorted = true;
		
	}
	
	public void updateArray(int delay) throws Exception {
		Thread.sleep(delay);
		
		this.removeAll();
		this.revalidate();
		this.paintImmediately(0, 0, 1280, 720);
		
		window.repaint();
		
	}
	
	public void shuffle() {
		int index, temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	    sorted = false;
    }
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D)g;
		super.paintComponent(graphics);
		
		graphics.setPaint(Color.DARK_GRAY);
		graphics.fillRect(0,0,window.getWidth(),window.getHeight());
		Color color1 = Color.GREEN;
        Color color2 = Color.CYAN;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, 900, color2);
        graphics.setPaint(gp);
		
		for(int i = 0; i < array.length; i++) {
			graphics.fillRect(2 * (i + 20) + (10 * i), 680 - (array[i] * 5), 10, array[i]*5);
		}
		
	}
}
