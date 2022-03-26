package gameMod;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import DisplayGame.Game;
import DisplayGame.GameObject.Rect;
import GuiScreen.GameScreen;

public class drawScreen extends JPanel {
	public static Rect enemy = new Rect(220, 220, 20, 20, -6, 4, 0);
	public static Rect enemy1 = new Rect(220, 220, 20, 20, -4, 6, 0);
	public static Rect enemy2 = new Rect(220, 220, 20, 20, 6, -4, 0);
	public static Rect enemy3 = new Rect(220, 220, 20, 20, -6, -4, 0);
	
	public static Rect enemy4round2 = new Rect(220, 0, 60, 60, -6, 0, 0);
	public static Rect enemy5round2 = new Rect(250, 0, 20, 20, 0, 0, 0);
	public static Rect enemy6round2 = new Rect(250, 0, 20, 20, 0, 0, 0);
	public static Rect enemy7round2 = new Rect(250, 0, 20, 20, 0, 0, 0);
	public static Rect enemy8round2 = new Rect(250, 0, 20, 20, 0, 0, 0);
	public static Rect enemy9round2 = new Rect(250, 0, 20, 20, 0, 0, 0);
	public static Rect enemy10round2 = new Rect(250, 0, 20, 20, 0, 0, 0);
	
	public static Rect enemy11round3 = new Rect(0, 0, 25, 25, 1, 6, 0);
	
	public static Rect chasingEnemy = new Rect(-21, 210, 20, 20, 0, 0, 0);
	
	static Random random = new Random();
	public static int randomBounce;
	public static int randomBounce1;
	public static int randomBounce2;
	public static int randomBounce3;
	public static int randomBounce4;
	public static int randomBounce5;
	public static int randomBounce6;
	
	public static void draw(Graphics g) {
		g.setColor(Color.blue);
		if(!Game.gameOver) {
			if(!Game.enemyDie) { enemy.draw(g); }
			if(!Game.enemyDie1) { enemy1.draw(g); }
			if(!Game.enemyDie2) { enemy2.draw(g); }
			if(!Game.enemyDie3) { enemy3.draw(g); }
			
			enemy4round2.draw(g);
			if(!Game.enemyDie4) { enemy5round2.draw(g); }
			if(!Game.enemyDie5) { enemy6round2.draw(g); }
			if(!Game.enemyDie6) { enemy7round2.draw(g); }
			if(!Game.enemyDie7) { enemy8round2.draw(g); }
			if(!Game.enemyDie8) { enemy9round2.draw(g); }
			if(!Game.enemyDie9) { enemy10round2.draw(g); }

			g.setColor(Color.cyan);
			enemy11round3.draw(g);

			g.setColor(new Color(212, 229, 255));
			chasingEnemy.draw(g);
		}
		collision();
	}
	
	public static void collision() {
		if(enemy5round2.y <= 0) {
			enemy5round2.x = enemy4round2.x + 30;
		}
		if(enemy6round2.y <= 0) {
			enemy6round2.x = enemy4round2.x + 30;
		}
		if(enemy7round2.y <= 0) {
			enemy7round2.x = enemy4round2.x + 30;
		}
		if(enemy8round2.y <= 0) {
			enemy8round2.x = enemy4round2.x + 30;
		}
		if(enemy9round2.y <= 0) {
			enemy9round2.x = enemy4round2.x + 30;
		}
		if(enemy10round2.y <= 0) {
			enemy10round2.x = enemy4round2.x + 30;
		}
		
		if(Game.gameOver == false && Game.GuiScreen == 1)
		{
			if(GameScreen.realLevel >= 36) {
				GameScreen.realLevel = 15;
			}
			
			if(GameScreen.realLevel <= 4 || GameScreen.realLevel >= 15 && GameScreen.realLevel < 30) {
				if(GameScreen.realLevel >= 16 && GameScreen.realLevel <= 22 || GameScreen.realLevel >= 31 && GameScreen.realLevel <= 34) {
					if(enemy11round3.y <= 0) {
						enemy11round3.y = 0;
						enemy11round3.setDy(6);
					}
					if(enemy11round3.y >= 465) {
						enemy11round3.y = 465;
						enemy11round3.setDy(-6);
					}
					if(enemy11round3.x <= 0) {
						enemy11round3.x = 0;
						enemy11round3.setDx(1);
					}
					if(enemy11round3.x >= 475) {
						enemy11round3.x = 475;
						enemy11round3.setDx(-1);
					}
				}
				if(GameScreen.realLevel >= 18 && GameScreen.realLevel <= 21 || GameScreen.realLevel >= 23) {
					if(Game.rect.x >= chasingEnemy.x - 10) {
						chasingEnemy.setDx(1);
					}
					if(Game.rect.x <= chasingEnemy.x - 10) {
						chasingEnemy.setDx(-1);
					}
					if(Game.rect.y >= chasingEnemy.y - 10) {
						chasingEnemy.setDy(1);
					}
					if(Game.rect.y <= chasingEnemy.y - 10) {
						chasingEnemy.setDy(-1);
					}
				}
				else {
					chasingEnemy.x = -21;
				}
				
				//enemy
				if(enemy.x >= 440) {
					enemy.x = 440;
					enemy.setDx(-randomBounce);
					randomBounce = random.nextInt(6)+4;
				}
				if(enemy.x <= 0) {
					enemy.x = 0;
					enemy.setDx(randomBounce1);
					randomBounce1 = random.nextInt(6)+4;
				}
				if(enemy.y >= 421) {
					enemy.y = 421;
					enemy.setDy(-randomBounce2);
					randomBounce2 = random.nextInt(6)+4;
				}
				if(enemy.y <= 0) {
					enemy.y = 0;
					enemy.setDy(randomBounce3);
					randomBounce3 = random.nextInt(6)+4;
				}
				
				//enemy1
				if(GameScreen.realLevel >= 2 || GameScreen.realLevel >= 15) {
					if(enemy1.x >= 440) {
						enemy1.x = 440;
						enemy1.setDx(-randomBounce1);
						randomBounce1 = random.nextInt(6)+4;
					}
					if(enemy1.x <= 0) {
						enemy1.x = 0;
						enemy1.setDx(randomBounce2);
						randomBounce2 = random.nextInt(6)+4;
					}
					if(enemy1.y >= 421) {
						enemy1.y = 421;
						enemy1.setDy(-randomBounce3);
						randomBounce3 = random.nextInt(6)+4;
					}
					if(enemy1.y <= 0) {
						enemy1.y = 0;
						enemy1.setDy(randomBounce4);
						randomBounce4 = random.nextInt(6)+4;
					}
				}
				
				//enemy2
				if(GameScreen.realLevel >= 3 || GameScreen.realLevel >= 15) {
					if(enemy2.x >= 440) {
						enemy2.x = 440;
						enemy2.setDx(-randomBounce2);
						randomBounce2 = random.nextInt(6)+4;
					}
					if(enemy2.x <= 0) {
						enemy2.x = 0;
						enemy2.setDx(randomBounce3);
						randomBounce3 = random.nextInt(6)+4;
					}
					if(enemy2.y >= 421) {
						enemy2.y = 421;
						enemy2.setDy(-randomBounce4);
						randomBounce4 = random.nextInt(6)+4;
					}
					if(enemy2.y <= 0) {
						enemy2.y = 0;
						enemy2.setDy(randomBounce5);
						randomBounce5 = random.nextInt(6)+4;
					}
				}
				
				//enemy3
				if(GameScreen.realLevel >= 4 || GameScreen.realLevel >= 15) {
					if(enemy3.x >= 440) {
						enemy3.x = 440;
						enemy3.setDx(-randomBounce3);
						randomBounce3 = random.nextInt(6)+4;
					}
					if(enemy3.x <= 0) {
						enemy3.x = 0;
						enemy3.setDx(randomBounce4);
						randomBounce4 = random.nextInt(6)+4;
					}
					if(enemy3.y >= 421) {
						enemy3.y = 421;
						enemy3.setDy(-randomBounce5);
						randomBounce5 = random.nextInt(6)+4;
					}
					if(enemy3.y <= 0) {
						enemy3.y = 0;
						enemy3.setDy(randomBounce6);
						randomBounce6 = random.nextInt(6)+4;
					}
				}
			}
			else if(GameScreen.realLevel > 4 && GameScreen.realLevel <= 16 || GameScreen.realLevel >= 30 && GameScreen.realLevel <= 35) {
				if(GameScreen.realLevel >= 8 && GameScreen.realLevel <= 11) {
					if(enemy.x >= 440) {
						enemy.x = 440;
						enemy.setDx(-randomBounce);
						randomBounce = random.nextInt(6)+4;
					}
					if(enemy.x <= 0) {
						enemy.x = 0;
						enemy.setDx(randomBounce1);
						randomBounce1 = random.nextInt(6)+4;
					}
					if(enemy.y >= 421) {
						enemy.y = 421;
						enemy.setDy(-randomBounce2);
						randomBounce2 = random.nextInt(6)+4;
					}
					if(enemy.y <= 0) {
						enemy.y = 0;
						enemy.setDy(randomBounce3);
						randomBounce3 = random.nextInt(6)+4;
					}
				}
				
				if(enemy4round2.x <= -15) {
					enemy4round2.x = -15;
					enemy4round2.setDx(6);
				}
				else if(enemy4round2.x >= 440) {
					enemy4round2.x = 440;
					enemy4round2.setDx(-6);
				}
				
				enemy5round2.setDy(6);
				enemy6round2.setDy(5);
				enemy7round2.setDy(4);
				enemy8round2.setDy(3);
				enemy9round2.setDy(7);
				enemy10round2.setDy(8);
				
				if(enemy5round2.y >= 520) {
					enemy5round2.y = 0;
					enemy5round2.setDy(6);
					enemy5round2.x = enemy4round2.x + 30;
				}
				if(enemy6round2.y >= 520) {
					enemy6round2.y = 0;
					enemy6round2.setDy(5);
					enemy6round2.x = enemy4round2.x + 30;
				}
				if(enemy7round2.y >= 520) {
					enemy7round2.y = 0;
					enemy7round2.setDy(4);
					enemy7round2.x = enemy4round2.x + 30;
				}
				if(enemy8round2.y >= 520) {
					enemy8round2.y = 0;
					enemy8round2.setDy(3);
					enemy8round2.x = enemy4round2.x + 30;
				}
				if(enemy9round2.y >= 520) {
					enemy9round2.y = 0;
					enemy9round2.setDy(7);
					enemy9round2.x = enemy4round2.x + 30;
				}
				if(enemy10round2.y >= 520) {
					enemy10round2.y = 0;
					enemy10round2.setDy(8);
					enemy10round2.x = enemy4round2.x + 30;
				}
			}
		}
	}

}
