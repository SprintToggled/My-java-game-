package DisplayGame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.Timer;

import DisplayGame.GameObject.Rect;
import DisplayGame.Secret.HackDisplay;
import GuiScreen.CharacterCustomScreen;
import GuiScreen.GameScreen;
import GuiScreen.HelpScreen;
import GuiScreen.MenuScreen;
import GuiScreen.StoreScreen;
import GuiScreen.SkillEffects.Explode;
import gameMod.drawScreen;

import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener, KeyListener, MouseListener {
	Timer timer = new Timer(15, this);
	public static Rect rect = new Rect(210, 210, 40, 40, 0, 0, 1);
	public static Rect healthBar = new Rect(5, 5, 200, 30, 0, 0, 0);
	public static Rect croshair = new Rect(210, 210, 30, 30, 0, 0, 2);
	
	public static boolean speed;
	
	public static boolean[] fixingMoving = new boolean[4];
	
	public static boolean newBuy = true;
	
	public static int potionTimer = 1000;
	public static int boostTimer = 1050;
	
	public static int Score;
	public static boolean gameOver = true;
	
	public static int miliTime = 80;
	public static int Fps;
	
	Random random = new Random();
	
	//skill
	public static int fireball;
	public static boolean shoot = false;
	
	public static int explode;
	public static int teleport;
	
	
	//too long (no name)
	public static int dieTimer = 150;
	public static boolean enemyDie;
	public static int dieTimer1 = 150;
	public static boolean enemyDie1;
	public static int dieTimer2 = 150;
	public static boolean enemyDie2;
	public static int dieTimer3 = 150;
	public static boolean enemyDie3;
	public static int dieTimer4 = 150;
	public static boolean enemyDie4;
	public static int dieTimer5 = 150;
	public static boolean enemyDie5;
	public static int dieTimer6 = 150;
	public static boolean enemyDie6;
	public static int dieTimer7 = 150;
	public static boolean enemyDie7;
	public static int dieTimer8 = 150;
	public static boolean enemyDie8;
	public static int dieTimer9 = 150;
	public static boolean enemyDie9;
	
	//menu
	public static int GuiScreen;
	
	Game() {
		setFocusable(true);
		addKeyListener(this);
		setOpaque(true);
		
		loadFile();
		
		addMouseListener(MenuScreen.button);
		
		addMouseListener(CharacterCustomScreen.buttonCreeper);
		addMouseListener(CharacterCustomScreen.buttonWhite);
		addMouseListener(CharacterCustomScreen.buttonYellow);
		addMouseListener(CharacterCustomScreen.buttonBlaze);
		addMouseListener(CharacterCustomScreen.buttonEnderman);
		addMouseListener(CharacterCustomScreen.buttonGalaxy);
		addMouseListener(CharacterCustomScreen.buttonHerobrine);
		addMouseListener(CharacterCustomScreen.buttonKaiser);
		
		addMouseListener(StoreScreen.buttonHealing);
		addMouseListener(StoreScreen.buttonSpeed);
		addMouseListener(StoreScreen.buttonFillHealth);
		addMouseListener(StoreScreen.buttonScoreBoost);
		addMouseListener(StoreScreen.buttonSkill);
		
		addMouseListener(this);
		
		fixingMoving[0] = false;
		fixingMoving[1] = false;
		fixingMoving[2] = false;
		fixingMoving[3] = false;
		
		timer.start();
	}
	
	public static void collision() {
		if(rect.x <= 0) {
			rect.x =+ 0;
		}
		if(rect.x > 440) {
			rect.x =+ 440;
		}
		if(rect.y <= 0) {
			rect.y =+ 0;
		}
		if(rect.y > 421) {
			rect.y =+ 421;
		}
		
		//collision player to enemy
		if(GuiScreen == 1) {
			if(!HackDisplay.Ihealth) {
				if(!gameOver) {
					if(drawScreen.enemy.intersects(rect) && !enemyDie) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy1.intersects(rect) && !enemyDie1) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy2.intersects(rect) && !enemyDie2) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy3.intersects(rect) && !enemyDie3) {
						healthBar.width -= 3;
					}
					
					//round 2
					if(drawScreen.enemy4round2.intersects(rect)) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy5round2.intersects(rect) && !enemyDie4) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy6round2.intersects(rect) && !enemyDie5) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy7round2.intersects(rect) && !enemyDie6) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy8round2.intersects(rect) && !enemyDie7) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy9round2.intersects(rect) && !enemyDie8) {
						healthBar.width -= 3;
					}
					if(drawScreen.enemy10round2.intersects(rect) && !enemyDie9) {
						healthBar.width -= 3;
					}
					
					//round3
					if(drawScreen.enemy11round3.intersects(rect)) {
						healthBar.width -= 3;
					}
					
					if(drawScreen.chasingEnemy.intersects(rect)) {
						healthBar.width -= 3;
					}
				}
			}
			if(HackDisplay.Ihealth) {
				healthBar.width = 200;
			}
			
			
			//this is too long
			if(enemyDie) {
				dieTimer -= 1;
				if(dieTimer <= 0) {
					enemyDie = false;
					dieTimer = 150;
				}
			}
			if(enemyDie1) {
				dieTimer1 -= 1;
				if(dieTimer1 <= 0) {
					enemyDie1 = false;
					dieTimer1 = 150;
				}
			}
			if(enemyDie2) {
				dieTimer2 -= 1;
				if(dieTimer2 <= 0) {
					enemyDie2 = false;
					dieTimer2 = 150;
				}
			}
			if(enemyDie3) {
				dieTimer3 -= 1;
				if(dieTimer3 <= 0) {
					enemyDie3 = false;
					dieTimer3 = 150;
				}
			}
			if(enemyDie4) {
				dieTimer4 -= 1;
				if(dieTimer4 <= 0) {
					enemyDie4 = false;
					dieTimer4 = 150;
				}
			}
			if(enemyDie5) {
				dieTimer5 -= 1;
				if(dieTimer5 <= 0) {
					enemyDie5 = false;
					dieTimer5 = 150;
				}
			}
			if(enemyDie6) {
				dieTimer6 -= 1;
				if(dieTimer6 <= 0) {
					enemyDie6 = false;
					dieTimer6 = 150;
				}
			}
			if(enemyDie7) {
				dieTimer7 -= 1;
				if(dieTimer7 <= 0) {
					enemyDie7 = false;
					dieTimer7 = 150;
				}
			}
			if(enemyDie8) {
				dieTimer8 -= 1;
				if(dieTimer8 <= 0) {
					enemyDie8 = false;
					dieTimer8 = 150;
				}
			}
			if(enemyDie9) {
				dieTimer9 -= 1;
				if(dieTimer9 <= 0) {
					enemyDie9 = false;
					dieTimer9 = 150;
				}
			}
			
			if(GameScreen.explode.intersects(drawScreen.enemy) && GameScreen.explode.start) {
				enemyDie = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy1) && GameScreen.explode.start) {
				enemyDie1 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy2) && GameScreen.explode.start) {
				enemyDie2 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy3) && GameScreen.explode.start) {
				enemyDie3 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy4round2) && GameScreen.explode.start) {
				enemyDie4 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy5round2) && GameScreen.explode.start) {
				enemyDie5 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy6round2) && GameScreen.explode.start) {
				enemyDie6 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy7round2) && GameScreen.explode.start) {
				enemyDie7 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy8round2) && GameScreen.explode.start) {
				enemyDie8 = true;
			}
			if(GameScreen.explode.intersects(drawScreen.enemy9round2) && GameScreen.explode.start) {
				enemyDie9 = true;
			}
			
			
			if(GameScreen.fireball.intersects(drawScreen.enemy) && GameScreen.explode.start) {
				enemyDie = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy1) && GameScreen.explode.start) {
				enemyDie1 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy2) && GameScreen.explode.start) {
				enemyDie2 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy3) && GameScreen.explode.start) {
				enemyDie3 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy4round2) && GameScreen.explode.start) {
				enemyDie4 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy5round2) && GameScreen.explode.start) {
				enemyDie5 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy6round2) && GameScreen.explode.start) {
				enemyDie6 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy7round2) && GameScreen.explode.start) {
				enemyDie7 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy8round2) && GameScreen.explode.start) {
				enemyDie8 = true;
			}
			if(GameScreen.fireball.intersects(drawScreen.enemy9round2) && GameScreen.explode.start) {
				enemyDie9 = true;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(GuiScreen == 1) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				if(gameOver == false) {
					fixingMoving[0] = true;
					if(!speed) {rect.setDy(-6);}
					if(speed) {rect.setDy(-9);}
				}
				break;
			case KeyEvent.VK_S:
				if(gameOver == false) {
					fixingMoving[1] = true;
					if(!speed) {rect.setDy(6);}
					if(speed) {rect.setDy(9);}
				}
				break;
			case KeyEvent.VK_A:
				if(gameOver == false) {
					fixingMoving[2] = true;
					if(!speed) {rect.setDx(-6);}
					if(speed) {rect.setDx(-9);}
				}
				break;
			case KeyEvent.VK_D:
				if(gameOver == false) {
					fixingMoving[3] = true;
					if(!speed) {rect.setDx(6);}
					if(speed) {rect.setDx(9);}
				}
				break;
				
			case KeyEvent.VK_ENTER:
				if(gameOver) {
					gameOver = false;
					healthBar.width = 200;
					Score = 0;
					GameScreen.level = 1;
					GameScreen.realLevel = 1;
					rect.x = 210;
					rect.y = 210;
					GameScreen.levelTime = 300;
					StoreScreen.FScore = false;
					speed = false;
				}
				break;
				
			case KeyEvent.VK_E:
				GuiScreen = 2;
				break;
				
			case KeyEvent.VK_ESCAPE:
				if(GuiScreen == 1) {
					GuiScreen = 0;
				}
				break;
				
			case KeyEvent.VK_Q:
				if(explode >= 1 && Explode.cooldown <= 0) {
					GameScreen.explode.start = true;
					Explode.cooldown = 600;
				}
				break;
				
			case KeyEvent.VK_SPACE:
				if(GuiScreen == 1 && CharacterCustomScreen.skin == "Blaze" && Explode.cooldown <= 0 && fireball >= 1) {
					shoot = true;
					Explode.cooldown = 600;
				}
			    break;
			}
		}
		else if(GuiScreen == 2) {
			switch(e.getKeyCode()) {
//			case KeyEvent.VK_H:
//				if(!HackDisplay.FBuy) {
//					if(Score >= 500) {
//						Score -= 500;
//						healthBar.width += 100;
//						
//						if(healthBar.width >= 200) {
//							healthBar.width =+ 200;
//						}
//						GuiScreen = 1;
//					}
//				}
//				else if(HackDisplay.FBuy) {
//					healthBar.width += 100;
//					
//					if(healthBar.width >= 200) {
//						healthBar.width =+ 200;
//					}
//					GuiScreen = 1;
//				}
//				break;
//				
//			case KeyEvent.VK_S:
//				if(!HackDisplay.FBuy) {
//					if(Score >= 300) {
//						Score -= 300;
//						speed = true;
//						
//						GuiScreen = 1;
//					}
//				}
//				else if(HackDisplay.FBuy) {
//					speed = true;
//					GuiScreen = 1;
//				}
//				break;
//				
//			case KeyEvent.VK_C:
//				if(!HackDisplay.FBuy) {
//					if(Score >= 1000) {
//						Score -= 1000;
//						StoreScreen.FScore = true;
//						
//						GuiScreen = 1;
//					}
//				}
//				else if(HackDisplay.FBuy) {
//					StoreScreen.FScore = true;
//					GuiScreen = 1;
//				}
//				break;
//				
//			case KeyEvent.VK_F:
//				if(!HackDisplay.FBuy) {
//					if(Score >= 800) {
//						Score -= 800;
//						healthBar.width = 200;
//						
//						GuiScreen = 1;
//					}
//				}
//				else if(HackDisplay.FBuy) {
//					healthBar.width = 200;
//					GuiScreen = 1;
//				}
//				break;
				
			case KeyEvent.VK_ESCAPE:
				GuiScreen = 1;
				break;
				
			case KeyEvent.VK_E:
				GuiScreen = 1;
				break;
			}
		}
		else if(GuiScreen == 3) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				GuiScreen = 0;
				break;
			}
		}
		else if(GuiScreen == 4) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				GuiScreen = 0;
				break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			fixingMoving[0] = false;
			break;
		case KeyEvent.VK_S:
			fixingMoving[1] = false;
			break;
		case KeyEvent.VK_A:
			fixingMoving[2] = false;
			break;
		case KeyEvent.VK_D:
			fixingMoving[3] = false;
			break;
		}
		
		//key fixing
		if(!fixingMoving[0] && !fixingMoving[1]) {
			rect.setDy(0);
		}
		if(!fixingMoving[2] && !fixingMoving[3]) {
			rect.setDx(0);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		rect.tick();
		healthBar.tick();
		drawScreen.enemy.tick();
		drawScreen.enemy1.tick();
		drawScreen.enemy2.tick();
		drawScreen.enemy3.tick();
		
		//round 2
		drawScreen.enemy4round2.tick();
		drawScreen.enemy5round2.tick();
		drawScreen.enemy6round2.tick();
		drawScreen.enemy7round2.tick();
		drawScreen.enemy8round2.tick();
		drawScreen.enemy9round2.tick();
		drawScreen.enemy10round2.tick();
		
		//round3
		drawScreen.enemy11round3.tick();
		
		drawScreen.chasingEnemy.tick();
		
		croshair.tick();
		
		repaint();
		
		if(Explode.cooldown >= 1) {
			Explode.cooldown -= 1;
		}
	}
	
	public void paint(Graphics g) {
		fps();
		
		if(GuiScreen == 1) {
			g.clearRect(0, 0, getWidth(), getHeight());
			GameScreen.draw(g);
		}
		if(GuiScreen == 2) {
			if(gameOver == false) {
				g.clearRect(0, 0, getWidth(), getHeight());
				StoreScreen.draw(g);
			}
			else {
				GuiScreen = 1;
			}
		}
		if(GuiScreen == 0) {
			g.fillRect(0, 0, getWidth(), getHeight());
			MenuScreen.draw(g);
		}
		if(GuiScreen == 3) {
			g.fillRect(0, 0, getWidth(), getHeight());
			HelpScreen.draw(g);
		}
		if(GuiScreen == 4) {
			g.fillRect(0, 0, getWidth(), getHeight());
			CharacterCustomScreen.draw(g);
		}
		
		
		if(speed) {
			potionTimer -= 1;
			if(potionTimer <= 0) {
				potionTimer = 1000;
				speed = false;
			}
		}
		
		if(StoreScreen.FScore) {
			boostTimer -= 1;
			if(boostTimer <= 0) {
				boostTimer = 1000;
				StoreScreen.FScore = false;
			}
		}
		
		writeFile();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		if(teleport >= 1 && CharacterCustomScreen.skin == "Enderman" && Explode.cooldown <= 0 && GuiScreen == 1) {
			rect.x = e.getX() - 20;
			rect.y = e.getY() - 20;
			Explode.cooldown = 600;
			teleport -= 1;
		}
//		if(Game.GuiScreen == 1) {
//			croshair.x = mouseX - croshair.width / 2;
//			croshair.y = mouseY - croshair.height / 2;
//		}
		
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
	
	public void fps() {
		miliTime -= 1;
		
		Fps = random.nextInt(10)+51;
		if(miliTime <= 0) {
			Display.window.setTitle("Obcopusting | " + Game.Fps + " Fps");
			miliTime = 80;
		}
	}
	
	public void loadFile() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("File.txt"));
			
			MenuScreen.bestLevel = Integer.parseInt("" + bf.readLine());
			GameScreen.level = Integer.parseInt("" + bf.readLine());
			Score = Integer.parseInt("" + bf.readLine());
			CharacterCustomScreen.bestScore = Integer.parseInt("" + bf.readLine());
			
			bf.close();
		} catch (Exception e) {
			
		}
	}
	
	public void writeFile() {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("File.txt"));
			
			br.write("" + MenuScreen.bestLevel);
			br.newLine();
			br.write("" + GameScreen.level);
			br.newLine();
			br.write("" + Score);
			br.newLine();
			br.write("" + CharacterCustomScreen.bestScore);
			
			br.close();
		} catch (Exception e) {
			
		}
	}
}
