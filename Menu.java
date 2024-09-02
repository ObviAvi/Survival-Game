package gamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import gamePackage.Game.STATE;

public class Menu extends MouseAdapter {

	//private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;

	public Menu(Game game, Handler handler, HUD hud) {
		//this.game = game;
		this.handler = handler;
		this.hud = hud;

	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (Game.gameState == STATE.Menu) {
			if (mouseOver(mx, my, 220, 100, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler, hud));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}

			if (mouseOver(mx, my, 220, 180, 200, 64)) {
				Game.gameState = STATE.Help;
			}

			if (mouseOver(mx, my, 220, 260, 200, 64)) {
				System.exit(1);
			}
		}
		if (Game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 220, 260, 200, 64)) {
				Game.gameState = STATE.Menu;
				return;
			}
		}
		if (Game.gameState == STATE.End) {
			if (mouseOver(mx, my, 220, 260, 200, 64)) {
				Game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler, hud));
				handler.clearEnemys();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
		}


	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void tick() {

	}

	public void render(Graphics g) {

		if (Game.gameState == STATE.Menu) {

			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			g.setColor(Color.white);

			g.setFont(font);

			g.drawString("Menu", 256, 50);

			g.setFont(font2);

			g.drawRect(220, 100, 200, 64);
			g.drawString("Play", 290, 144);

			g.drawRect(220, 180, 200, 64);
			g.drawString("Help", 290, 224);

			g.drawRect(220, 260, 200, 64);
			g.drawString("Quit", 290, 304);

		} else if (Game.gameState == STATE.Help) {

			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			Font font3 = new Font("arial", 1, 20);

			g.setColor(Color.white);

			g.setFont(font);
			g.drawString("Help", 262, 50);

			g.setFont(font2);
			g.drawRect(220, 260, 200, 64);
			g.drawString("Back", 288, 304);

			g.setFont(font3);
			g.drawString("Use arrow keys to move and try to dodge all enemies", 65, 175);

		} else if (Game.gameState == STATE.End) {

			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			Font font3 = new Font("arial", 1, 20);

			g.setColor(Color.white);

			g.setFont(font);
			g.drawString("Game Over", 186, 50);

			g.setFont(font2);
			g.drawRect(220, 260, 200, 64);
			g.drawString("Retry", 286, 304);

			g.setFont(font3);
			g.drawString("You lost with a score of " + hud.getScore(), 185, 175);
		}
	}
}
