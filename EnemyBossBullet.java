package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(10) - 5);
		velY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 8, 8);
	}

	public void tick() {
		x += velX;
		y += velY;

		/*if (y <= 0 || y >= Game.HEIGHT - 42) {
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 18) {
			velX *= -1;
		}*/
		
		if(y >= Game.HEIGHT) {
			handler.removeObject(this);
		}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.ORANGE, 8, 8, (float) 0.04, handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int)x, (int)y, 8, 8);
	}

}
