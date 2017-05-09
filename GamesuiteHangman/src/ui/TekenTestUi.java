package ui;


import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by tiebe on 9/05/2017.
 */
public class TekenTestUi extends Canvas {

    public static void main(String[] args)
    {
        final String title = "Test Window";
        final int width = 400;
        final int height = 400;

        //Creating the frame.
        JFrame frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        //Creating the canvas.
        Canvas canvas = new Canvas();

        canvas.setSize(width, height);
        canvas.setBackground(Color.WHITE);
        canvas.setVisible(true);
        canvas.setFocusable(false);


        //Putting it all together.
        frame.add(canvas);

        canvas.createBufferStrategy(3);

        boolean running = true;

        BufferStrategy bufferStrategy;
        Graphics graphics;

        while (running) {
            bufferStrategy = canvas.getBufferStrategy();
            graphics = bufferStrategy.getDrawGraphics();
            graphics.clearRect(0, 0, width, height);

            Tekening huisMetSchouw = new Tekening("Huis");

            Rechthoek gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
            Driehoek dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
            Rechthoek deur = new Rechthoek(new Punt(130, 280), 50,100);
            Rechthoek raam = new Rechthoek(new Punt(210, 220), 80, 60);
            Cirkel deurknop = new Cirkel(new Punt(170, 320), 2);
            LijnStuk raambalk1 = new LijnStuk(new Punt(210, 250), new Punt(290, 250));
            LijnStuk raambalk2 = new LijnStuk(new Punt(250, 220), new Punt(250, 280));
            Rechthoek schouwNietInTekening = new Rechthoek(new Punt(150, 150), 20,40);


            huisMetSchouw.voegToe(gebouw);
            huisMetSchouw.voegToe(dak);
            huisMetSchouw.voegToe(deur);
            huisMetSchouw.voegToe(raam);
            huisMetSchouw.voegToe(deurknop);
            huisMetSchouw.voegToe(raambalk1);
            huisMetSchouw.voegToe(raambalk2);
            huisMetSchouw.voegToe(schouwNietInTekening);

            huisMetSchouw.teken(graphics);


            bufferStrategy.show();
            graphics.dispose();
        }
    }
}
