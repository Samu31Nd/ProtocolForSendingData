package org.example;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
    int WIDTH = 700, HEIGHT = 700, HConst = 20,
    CIRCLES_SIZE = 180,
    INITIAL_ANGLE = 360/8,
    INNERConst = 40;
    Color ACTIVE = new Color(126, 206, 243),
            ACTIVELine = new Color(22, 80, 113),

    INACTIVE = new Color(172, 176, 182, 255),
            INACTIVELine = new Color(0, 0, 0),

    ERROR = new Color(229, 102, 102, 255),
            ERRORLine = new Color(125, 0, 6),

    PASS = new Color(167, 233, 175),
            PASSLine = new Color(68, 130, 97);

    Color[] COLORCircles = new Color[]{INACTIVE,INACTIVE,INACTIVE,INACTIVE},
            COLORCirclesStrokes = new Color[]{INACTIVELine,INACTIVELine,INACTIVELine,INACTIVELine},
            COLORStrokes = new Color[]{INACTIVELine, INACTIVELine, INACTIVELine, INACTIVELine,
            INACTIVELine, INACTIVELine, INACTIVELine, INACTIVELine};

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    @Override
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D qs = (Graphics2D) g;
        qs.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        qs.setStroke(new BasicStroke(3.5f));

        //FULL CIRCLES TO BE ADDED LATER
        //OUTER LINES
        //UP
        qs.setColor(COLORStrokes[0]);
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, INITIAL_ANGLE, INITIAL_ANGLE*2);
        //LEFT
        qs.setColor(COLORStrokes[1]);
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 3*INITIAL_ANGLE, INITIAL_ANGLE*2);
        //DOWN
        qs.setColor(COLORStrokes[2]);
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 5*INITIAL_ANGLE, INITIAL_ANGLE*2);
        //RIGHT
        qs.setColor(COLORStrokes[3]);
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 7*INITIAL_ANGLE, INITIAL_ANGLE*2);


        //INNER LINES
        //UP
        qs.setColor(COLORStrokes[4]);
        qs.drawArc(WIDTH/2 - (HEIGHT-20-(80-10)*2)/2 , -(HEIGHT-20-(80-10)*2)/2 - INNERConst, WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*5, INITIAL_ANGLE*2);
        //RIGHT
        qs.setColor(COLORStrokes[5]);
        qs.drawArc(WIDTH - (HEIGHT-20-(80-10)*2)/2 + INNERConst, -(-20-(80-10)*2)/2 - HConst/2 , WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*3, INITIAL_ANGLE*2);
        //LEFT
        qs.setColor(COLORStrokes[6]);
        qs.drawArc(-(HEIGHT-20-(80-10)*2)/2 - INNERConst , -(-20-(80-10)*2)/2 - HConst/2 , WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*7, INITIAL_ANGLE*2);
        //DOWN
        qs.setColor(COLORStrokes[7]);
        qs.drawArc(WIDTH/2 - (HEIGHT-20-(80-10)*2)/2 , HEIGHT/2  -(-(80-10)*2)/2 - HConst/2 + INNERConst, WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE, INITIAL_ANGLE*2);


        //q0
        qs.setColor(COLORCircles[0]);
        qs.fillOval(80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);

        //q1
        qs.setColor(COLORCircles[1]);
        qs.fillOval(WIDTH-CIRCLES_SIZE -80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);

        //q2
        qs.setColor(COLORCircles[2]);
        qs.fillOval(80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE,CIRCLES_SIZE);

        //q3
        qs.setColor(COLORCircles[3]);
        qs.fillOval(WIDTH-CIRCLES_SIZE -80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE, CIRCLES_SIZE);


        qs.setStroke(new BasicStroke(4.0f));

        qs.setColor(COLORCirclesStrokes[0]);
        qs.drawOval(80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);
        qs.drawOval(80+15,80+15,
                CIRCLES_SIZE-30,CIRCLES_SIZE-30);


        qs.setColor(COLORCirclesStrokes[1]);
        qs.drawOval(WIDTH-CIRCLES_SIZE -80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);

        qs.setColor(COLORCirclesStrokes[2]);
        qs.drawOval(80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE,CIRCLES_SIZE);

        qs.setColor(COLORCirclesStrokes[3]);
        qs.drawOval(WIDTH-CIRCLES_SIZE -80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE, CIRCLES_SIZE);

        qs.setFont(new Font("Arial",Font.BOLD,30));
        qs.drawString("PROTOCOL FOR SENDING DATA", 110, 40);

        qs.setFont(new Font("Arial",Font.PLAIN,30));
        qs.drawString("Q0", 80 + CIRCLES_SIZE/2 - 20, 80 + CIRCLES_SIZE/2 + 10);
        qs.drawString("Q1", 90 - 20 + WIDTH-CIRCLES_SIZE -80, 80 + CIRCLES_SIZE/2 + 10);

        qs.drawString("Q2", 80 + CIRCLES_SIZE/2 - 20, 80 + CIRCLES_SIZE/2 + 10 + HEIGHT/2 - HConst/2);
        qs.drawString("Q3", 90 - 20 + WIDTH-CIRCLES_SIZE -80, 80 + CIRCLES_SIZE/2 + 10 + HEIGHT/2 - HConst/2);

        qs.setFont(new Font("Arial",Font.PLAIN,25));
        qs.drawString("1", 270, 90);
        qs.drawString("1", 410, 200);
        qs.drawString("1", 270, 500);
        qs.drawString("1", 410, 610);

        qs.drawString("0", 70, 400);
        qs.drawString("0", 200, 300);
        qs.drawString("0", 500, 400);
        qs.drawString("0", 600, 300);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Protocol");

        Main protocol = new Main();
        //Function fun = new Function();
        int i;

        frame.add(protocol);

        frame.setSize(protocol.WIDTH, protocol.HEIGHT + protocol.HConst);
        frame.setLocation(protocol.dim.width/2-frame.getSize().width/2, protocol.dim.height/2-frame.getSize().height/2);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        while (true) {
            TimeUnit.SECONDS.sleep(2);

            protocol.COLORCircles[0] = protocol.ACTIVE;
            protocol.COLORCirclesStrokes[0] = protocol.ACTIVELine;

//            Thread.sleep(10000);
//            for ( i = 0; i < 4 ; i++){
//                protocol.COLORCirclesStrokes[i] = protocol.INACTIVELine;
//                protocol.COLORStrokes[i] = protocol.INACTIVELine;
//                protocol.COLORCircles[i] = protocol.INACTIVE;
//            }

            //Here you insert the logic of the program
            protocol.repaint();
            Thread.sleep(10);

            TimeUnit.SECONDS.sleep(2);

            protocol.COLORCircles[0] = protocol.INACTIVE;
            protocol.COLORCirclesStrokes[0] = protocol.INACTIVELine;
        }
    }
}

