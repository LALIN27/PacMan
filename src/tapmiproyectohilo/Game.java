/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapmiproyectohilo;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public abstract class Game extends Canvas implements Runnable {
  private static final long serialVersionUID = 1L;

  private JFrame frame;
  private boolean running = false;

  public Game(String title, int width, int height) {
    frame = new JFrame(title);
    setPreferredSize(new Dimension(width, height));
    frame.add(this);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public abstract void update();
  public abstract void render(Graphics g);

  public void start() {
    running = true;
    new Thread(this).start();
  }

  public void stop() {
    running = false;
  }

  public void run() {
    while (running) {
      update();
      render(getBufferStrategy().getDrawGraphics());
      getBufferStrategy().show();
    }
  }

  public JFrame getFrame() {
    return frame;
  }
}

