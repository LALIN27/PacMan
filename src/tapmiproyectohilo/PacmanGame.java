/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapmiproyectohilo;

/**
 *
 * @author eduar
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class PacmanGame extends Game {
  private ArrayList<Point> points;
  private final Pacman pacman;
  

  public PacmanGame(String title, int width, int height) {
    super(title, width, height);
    points = new ArrayList<Point>();
    initPoints();
    pacman = new Pacman(320, 240, 32, 32, Color.YELLOW);
    
  }

  private void initPoints() {
    Random rand = new Random();
    for (int i = 0; i < 20; i++) {
      int x = rand.nextInt(640);
      int y = rand.nextInt(480);
      points.add(new Point(x, y, 10, 10));
    }
  }

  @Override
  public void update() {
    pacman.update();
    
    checkCollisions();
  }

  private void checkCollisions() {
    for (int i = 0; i < points.size(); i++) {
      if (pacman.intersects(points.get(i))) {
        points.remove(i);
        i--;
      }
    }
  }

  @Override
  public void render(Graphics g) {
    g.clearRect(0, 0, getWidth(), getHeight());
    for (int i = 0; i < points.size(); i++) {
      points.get(i).render(g);
    }
    pacman.render(g);
    
  }
}
