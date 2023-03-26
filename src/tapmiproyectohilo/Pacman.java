/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tapmiproyectohilo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author eduar
 */
public class Pacman extends Thread{
     private int x, y;
    private int speed;
    private int direction;

    public Pacman(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = 0;
    }

    Pacman(int i, int i0, int i1, int i2, Color YELLOW) {
       
    }

    public void move() {
        switch (this.direction) {
            case 0: // mover hacia la derecha
                this.x += this.speed;
                break;
            case 1: // mover hacia la izquierda
                this.x -= this.speed;
                break;
            case 2: // mover hacia abajo
                this.y += this.speed;
                break;
            case 3: // mover hacia arriba
                this.y -= this.speed;
                break;
            default:
                break;
        }
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void run() {
        while (true) {
            int newDirection = (int) (Math.random() * 4);
            this.setDirection(newDirection);
            this.move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void update() {
        // Actualiza la posición de Pacman según la lógica de tu juego
    x += 1;
    y += 1;
    }

    boolean intersects(Point get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
   