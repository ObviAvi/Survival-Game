package gamePackage;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {

		scoreKeep = hud.getScore();

		if (scoreKeep % 200 == 0) {
			//scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);

			if (hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}
			if (hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}
			if (hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
			}
			if (hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));
			}
			if (hud.getLevel() == 6) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
			}
			if (hud.getLevel() == 7) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}
			if (hud.getLevel() == 10) {
				handler.clearEnemys();
				handler.addObject(new EnemyBoss(Game.WIDTH /2 - 64, -120, ID.EnemyBoss, handler));
				handler.addObject(new Player( 288, 208, ID.Player, handler, hud));
				
			}
		}
	}
}
