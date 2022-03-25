package GuiScreen.SkillEffects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import DisplayGame.Game;

public class Explode extends Rectangle {
	static Image explode = new ImageIcon("explodeImg.png").getImage();
	public static boolean start;
	
	public static int cooldown;
	
	int opacity = 255;
	
	int dx, dy, dwidth, dheight;
	
	public Explode(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
//		this.dx = dx;
//		this.dy = dy;
//		this.dwidth = dwidth;
//		this.dheight = dheight;
	}
	
//	public void tick() {
//		this.x += dx;
//		this.y += dy;
//		this.width += dwidth;
//		this.height += dheight;
//	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(148, 148, 148, opacity));
		g.fillArc(this.x, this.y, this.width, this.height, 0, 360);
		g.setColor(new Color(255, 149, 0, opacity));
		g.fillArc(this.x + 20, this.y + 20, this.width - 40, this.height - 40, 0, 360);
		
		if(start) {
			x -= 2;
			y -= 2;
			width += 4;
			height += 4;
			opacity -= 4;
		}
		if(opacity <= 5) {
			x = 1;
			y = 1;
			width = 1;
			height = 1;
			opacity = 255;
			start = false;
			Game.explode -= 1;
		}
	}

}
