package DisplayGame.Secret;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import DisplayGame.Display;

public class HackDisplay extends JPanel implements KeyListener, ActionListener {
	public static boolean Ihealth = false;
	public static boolean FBuy = false;
	public static boolean SizeChanger = false;
	
	Timer timer = new Timer(15, this);
	
	HackDisplay() {
		addKeyListener(this);
		setFocusable(true);
		
		timer.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		if(!Ihealth) {
			g.drawString("Infinite Health || off (Toggle: i)", 5, 15);
		}
		else if(Ihealth) {
			g.drawString("Infinite Health || on (Toggle: i)", 5, 15);
		}
		
		if(!FBuy) {
			g.drawString("Free Shop || off (Toggle: f)", 5, 30);
		}
		else if(FBuy) {
			g.drawString("Free Shop || on (Toggle: f)", 5, 30);
		}
		
		if(!SizeChanger) {
			g.drawString("Size Changer || off (Toggle: s)", 5, 45);
		}
		else if(SizeChanger) {
			g.drawString("Size Changer || on (Toggle: s)", 5, 45);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_I:
			if(!Ihealth) {
				Ihealth = true;
			}
			else if(Ihealth) {
				Ihealth = false;
			}
			break;
			
		case KeyEvent.VK_F:
			if(!FBuy) {
				FBuy = true;
			}
			else if(FBuy) {
				FBuy = false;
			}
			break;
			
		case KeyEvent.VK_S:
			if(!SizeChanger) {
				Display.window.setResizable(true);
				SizeChanger = true;
			}
			else if(SizeChanger) {
				Display.window.setResizable(false);
				SizeChanger = false;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

}
