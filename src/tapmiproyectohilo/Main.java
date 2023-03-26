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
public class Main {
  public static void main(String[] args) {
    Game game = new PacmanGame("Pacman", 640, 480);
    game.start();
  }
}