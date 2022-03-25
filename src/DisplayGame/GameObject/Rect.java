package DisplayGame.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import GuiScreen.CharacterCustomScreen;

public class Rect extends Rectangle {
	public int dx, dy;
	public int image;
	
	Image playerCreeper = new ImageIcon("playerImage.png").getImage();
	Image playerWhite = new ImageIcon("playerImg.png").getImage();
	Image playerBlaze = new ImageIcon("playerBlaze.png").getImage();
	Image playerEnderman = new ImageIcon("playerEnderman.png").getImage();
	Image playerGalaxy = new ImageIcon("playerGalaxy.png").getImage();
	Image playerHerobrine = new ImageIcon("playerHerobrine.png").getImage();
	Image playerKaiser = new ImageIcon("kaiserImg.png").getImage();
	Image croshair = new ImageIcon("croshairImg.png").getImage();
	
	public Rect(int x, int y, int width, int height, int dx, int dy, int image) {
		setBounds(x, y, width, height);
		this.dx = dx;
		this.dy = dy;
		this.image = image;
	}
	
	public void tick() {
		this.x += dx;
		this.y += dy;
	}
	
	public void draw(Graphics g) {
		if(image == 1) {
			if(CharacterCustomScreen.skin == "Creeper") {
				g.drawImage(playerCreeper, this.x, this.y, this.width, this.height, null);
			}
			else if(CharacterCustomScreen.skin == "White") {
				g.drawImage(playerWhite, this.x, this.y, this.width, this.height, null);
			}
			else if(CharacterCustomScreen.skin == "Yellow") {
				g.setColor(Color.yellow);
				g.fillRect(this.x, this.y, this.width, this.height);
			}
			else if(CharacterCustomScreen.skin == "Blaze") {
				g.drawImage(playerBlaze, this.x, this.y, this.width, this.height, null);
			}
			else if(CharacterCustomScreen.skin == "Enderman") {
				g.drawImage(playerEnderman, this.x, this.y, this.width, this.height, null);
			}
			else if(CharacterCustomScreen.skin == "Galaxy") {
				g.drawImage(playerGalaxy, this.x, this.y, this.width, this.height, null);
			}
			else if(CharacterCustomScreen.skin == "Herobrine") {
				g.drawImage(playerHerobrine, this.x, this.y, this.width, this.height, null);
			}
			else if(CharacterCustomScreen.skin == "Kaizereich") {
				g.drawImage(playerKaiser, this.x, this.y, this.width, this.height, null);
			}
		}
		else if(image == 2) {
			g.drawImage(croshair, this.x, this.y, this.width, this.height, null);
		}
		else if(image == 0) {
			g.fillRect(this.x, this.y, this.width, this.height);
		}
		
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}


}
