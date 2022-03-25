package GuiScreen.SkillEffects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import DisplayGame.Game;
import GuiScreen.CharacterCustomScreen;

public class FireBall extends Rectangle {
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	Image fireball = new ImageIcon("ballImg.png").getImage();
	
	public FireBall(int x, int y, int width, int height) {
		setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.drawImage(fireball, this.x, this.y, this.width, this.height, null);
		
		if(Game.GuiScreen == 1 && CharacterCustomScreen.skin == "Blaze") {
			if(x >= 500 || y >= 500 || x <= -40 || y <= -40) {
				x = 1000;
				y = 1000;
				Game.fireball -= 1;
				Explode.cooldown = 600;
			}
		}
		
		if(up) { y += 5; }
		if(down) { y -= 5; }
		if(left) { x -= 5; }
		if(right) { x += 5; }
		
		if(Game.fireball >= 1 && CharacterCustomScreen.skin == "Blaze" && Explode.cooldown <= 0) {
			if(Game.GuiScreen == 1 && !Game.gameOver) {
				if(Game.shoot) {
					if(x >= Game.croshair.x - this.getWidth() / 4) {
						left = true;
						Game.shoot = false;
					}
					if(x <= Game.croshair.x - this.getWidth() / 4) {
						right = true;
						Game.shoot = false;
					}
					if(y >= Game.croshair.y - this.getHeight() / 4) {
						down = true;
						Game.shoot = false;
					}
					if(y <= Game.croshair.y - this.getHeight() / 4) {
						up = true;
						Game.shoot = false;
					}
				}
			}
		}
	}

}
