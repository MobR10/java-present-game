package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    static GraphicsDevice device=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    public static void main(String[] args) throws Exception {
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D GAME");

        GamePanel gamePanel=new GamePanel(window); // THE GAMEPANEL
        window.add(gamePanel);

        window.pack();


        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
