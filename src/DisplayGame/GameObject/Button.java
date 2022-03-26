package DisplayGame.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import DisplayGame.Game;
import DisplayGame.Secret.HackDisplay;
import GuiScreen.CharacterCustomScreen;
import GuiScreen.MenuScreen;
import GuiScreen.StoreScreen;
import GuiScreen.SkillEffects.Explode;

public class Button extends Rectangle implements MouseListener {
	public static Image playerCreeper = new ImageIcon("playerImage.png").getImage();
	public static Image playerWhite = new ImageIcon("playerImg.png").getImage();
	public static Image playerBlaze = new ImageIcon("playerBlaze.png").getImage();
	public static Image playerEnderman = new ImageIcon("playerEnderman.png").getImage();
	public static Image playerGalaxy = new ImageIcon("playerGalaxy.png").getImage();
	public static Image playerHerobrine = new ImageIcon("playerHerobrine.png").getImage();
	public static Image kaiser = new ImageIcon("kaiserImg.png").getImage();
	
	int Image;
	int Gui;
	boolean style;
	
	public Button(int x, int y, int width, int height, int Image, int Gui, boolean style) {
		setBounds(x, y, width, height);
		this.Image = Image;
		this.Gui = Gui;
		this.style = style;
		
	}
	
	public void draw(Graphics g) {
		if(!style) {
			if(Image == 0) {
				g.fillRect(this.x, this.y, this.width, this.height);
			}
			else if(Image == 1) {
				g.drawImage(playerCreeper, this.x, this.y, this.width, this.height, null);
			}
			else if(Image == 2) {
				g.drawImage(playerWhite, this.x, this.y, this.width, this.height, null);
			}
			else if(Image == 3) {
				g.drawImage(playerBlaze, this.x, this.y, this.width, this.height, null);
			}
			else if(Image == 4) {
				g.drawImage(playerEnderman, this.x, this.y, this.width, this.height, null);
			}
			else if(Image == 5) {
				g.drawImage(playerGalaxy, this.x, this.y, this.width, this.height, null);
			}
			else if(Image == 6) {
				g.drawImage(playerHerobrine, this.x, this.y, this.width, this.height, null);
			}
			else if(Image == 7) {
				g.drawImage(kaiser, this.x, this.y, this.width, this.height, null);
			}
		}
		else if(style) {
			if(Gui == -1) {
				if(MenuScreen.bestLevel < 10) { g.setColor(Color.gray); }
				if(MenuScreen.bestLevel >= 10) { g.setColor(Color.white); }
			}
			g.drawRect(this.x, this.y, this.width, this.height);
		}
		
	}
	
	static boolean MouseOver(int mouseX, int mouseY, int x, int y, int width, int height) {
		if(mouseX >= x && mouseX <= x + width) {
			if(mouseY >= y && mouseY <= y + height) {
				return true;
			}
			else {
				return false;
			}
		}
		else return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		if(MouseOver(mouseX, mouseY, 180, 200, 140, 40)) {
			if(Game.GuiScreen == 0) {
				Game.GuiScreen = 1;
			}
		}
		if(MouseOver(mouseX, mouseY, 180, 250, 140, 40)) {
			if(Game.GuiScreen == 0) {
				Game.GuiScreen = 3;
			}
		}
		if(MouseOver(mouseX, mouseY, 180, 300, 140, 40)) {
			if(Game.GuiScreen == 0 && MenuScreen.bestLevel >= 10) {
				Game.GuiScreen = 4;
			}
		}
//		if(MouseOver(mouseX, mouseY, 180, 350, 140, 40)) {
//			if(Game.GuiScreen == 0) {
//				System.exit(1);
//			}
//		}
		
		
		//Skin
		if(MouseOver(mouseX, mouseY, 220, 100, 50, 50)) {
			if(Game.GuiScreen == 4) {
				CharacterCustomScreen.skin = "Creeper";
			}
		}
		else if(MouseOver(mouseX, mouseY, 310, 100, 50, 50)) {
			if(Game.GuiScreen == 4) {
				CharacterCustomScreen.skin = "White";
			}
		}
		else if(MouseOver(mouseX, mouseY, 405, 100, 50, 50)) {
			if(Game.GuiScreen == 4) {
				CharacterCustomScreen.skin = "Yellow";
			}
		}
		else if(MouseOver(mouseX, mouseY, this.x, this.y, this.width, this.height)) {
			if(Game.GuiScreen == 4) {
				if(Gui == 10) {
					CharacterCustomScreen.skin = "Blaze";
				}
				if(Gui == 11) {
					CharacterCustomScreen.skin = "Enderman";
				}
				if(Gui == 12) {
					CharacterCustomScreen.skin = "Galaxy";
				}
				if(Gui == 14) {
					CharacterCustomScreen.skin = "Herobrine";
				}
				if(Gui == 15) {
					CharacterCustomScreen.skin = "Kaizereich";
				}
			}
		}
		
		
		if(MouseOver(mouseX, mouseY, this.x, this.y, this.width, this.height)) {
			if(Game.GuiScreen == 2) {
				if(Gui == 1) {
					if(!HackDisplay.FBuy) {
						if(Game.Score >= 500) {
							Game.Score -= 500;
							Game.healthBar.width += 100;
							
							if(Game.healthBar.width >= 200) {
								Game.healthBar.width =+ 200;
							}
							Game.GuiScreen = 1;
						}
					}
					else if(HackDisplay.FBuy) {
						Game.healthBar.width += 100;
						
						if(Game.healthBar.width >= 200) {
							Game.healthBar.width =+ 200;
						}
						Game.GuiScreen = 1;
					}
				}
				if(Gui == 2) {
					if(!HackDisplay.FBuy) {
						if(Game.Score >= 300) {
							Game.Score -= 300;
							Game.speed = true;
							
							Game.GuiScreen = 1;
						}
					}
					else if(HackDisplay.FBuy) {
						Game.speed = true;
						Game.GuiScreen = 1;
					}
				}
				if(Gui == 3) {
					if(!HackDisplay.FBuy) {
						if(Game.Score >= 1000) {
							Game.Score -= 1000;
							StoreScreen.FScore = true;
							
							Game.GuiScreen = 1;
						}
					}
					else if(HackDisplay.FBuy) {
						StoreScreen.FScore = true;
						Game.GuiScreen = 1;
					}
				}
				if(Gui == 4) {
					if(!HackDisplay.FBuy) {
						if(Game.Score >= 800) {
							Game.Score -= 800;
							Game.healthBar.width = 200;
							
							Game.GuiScreen = 1;
						}
					}
					else if(HackDisplay.FBuy) {
						Game.healthBar.width = 200;
						Game.GuiScreen = 1;
					}
				}
				
				
				//skill
				if(Gui == 5) {
					if(CharacterCustomScreen.skin == "Creeper") {
						if(!HackDisplay.FBuy) {
							if(Game.Score >= 900) {
								Game.Score -= 900;
								Game.explode += 1;
								
								Game.GuiScreen = 1;
							}
						}
						else if(HackDisplay.FBuy) {
							Game.explode += 1;
							Game.GuiScreen = 1;
						}
					}
					else if(CharacterCustomScreen.skin == "Blaze") {
						if(!HackDisplay.FBuy) {
							if(Game.Score >= 900) {
								Game.Score -= 900;
								Game.fireball += 1;
								
								Game.GuiScreen = 1;
							}
						}
						else if(HackDisplay.FBuy) {
							Game.fireball += 1;
							Game.GuiScreen = 1;
						}
					}
					else if(CharacterCustomScreen.skin == "Enderman") {
						if(!HackDisplay.FBuy) {
							if(Game.Score >= 900) {
								Game.Score -= 900;
								Game.teleport += 1;
								Explode.cooldown = 5;
								
								Game.GuiScreen = 1;
							}
						}
						else if(HackDisplay.FBuy) {
							Game.teleport += 1;
							Game.GuiScreen = 1;
						}
					}
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
