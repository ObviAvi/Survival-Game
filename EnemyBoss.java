package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	Random r = new Random();

	private int timer = 86;
	private int timer2 = 50;

	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);

		this.handler = handler;

		velX = 0;
		velY = 2;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	}

	public void tick() {

		x += velX;
		y += velY;

		int spawn = r.nextInt(10);

		if (timer <= 0) {
			velY = 0;
		} else {
			timer--;
		}

		if (timer <= 0) {
			timer2--;
		}
		if (timer2 <= 0) {

			if (velX == 0) {
				velX = 3;
			}
			if (spawn == 0) {
				handler.addObject(new EnemyBossBullet((int) (x + 40), (int) (y + 96), ID.BasicEnemy, handler));
			}
			if (velX > 0) {
				velX += 0.005;
			}
			if (velX < 0) {
				velX -= 0.005;
			}

			velX = Game.clamp(velX, -10, 10);

		}

		if (x <= 0 || x > Game.WIDTH - 100) {
			velX *= -1;
		}

	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 96, 96);
	}

}
