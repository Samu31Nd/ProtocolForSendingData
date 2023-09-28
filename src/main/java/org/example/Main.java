package org.example;

import java.awt.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
    Boolean[] isActiveQCircle = new Boolean[]{false,false,false,false};
    Boolean[] isActiveQStrokes = new Boolean[]{false,false,false,false,false,false,false,false};
    Boolean isActive;
    int WIDTH = 700, HEIGHT = 700, HConst = 20,
    CIRCLES_SIZE = 180,
    INITIAL_ANGLE = 360/8,
    INNERConst = 40;
    Color ACTIVE = new Color(126, 206, 243),
            ACTIVELine = new Color(100, 159, 189),

    INACTIVE = new Color(172, 176, 182, 255),
            INACTIVELine = new Color(0, 0, 0),


    PASS = new Color(167, 233, 175),
            PASSLine = new Color(68, 130, 97),
    RECHAZED = new Color(255,0,0);
    char number = '-';


    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    @Override
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D qs = (Graphics2D) g;
        qs.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        qs.setStroke(new BasicStroke(3.5f));

        //OUTER LINES
        //UP
        qs.setColor(INACTIVELine);
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, INITIAL_ANGLE, INITIAL_ANGLE*2);
        //LEFT
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 3*INITIAL_ANGLE, INITIAL_ANGLE*2);
        //DOWN
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 5*INITIAL_ANGLE, INITIAL_ANGLE*2);
        //RIGHT
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 7*INITIAL_ANGLE, INITIAL_ANGLE*2);


        //INNER LINES
        //UP
        qs.drawArc(WIDTH/2 - (HEIGHT-20-(80-10)*2)/2 , -(HEIGHT-20-(80-10)*2)/2 - INNERConst, WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*5, INITIAL_ANGLE*2);
        //RIGHT
        qs.drawArc(WIDTH - (HEIGHT-20-(80-10)*2)/2 + INNERConst, -(-20-(80-10)*2)/2 - HConst/2 , WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*3, INITIAL_ANGLE*2);
        //LEFT
        qs.drawArc(-(HEIGHT-20-(80-10)*2)/2 - INNERConst , -(-20-(80-10)*2)/2 - HConst/2 , WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*7, INITIAL_ANGLE*2);
        //DOWN
        qs.drawArc(WIDTH/2 - (HEIGHT-20-(80-10)*2)/2 , HEIGHT/2  -(-(80-10)*2)/2 - HConst/2 + INNERConst, WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE, INITIAL_ANGLE*2);


        qs.setColor(ACTIVELine);
        //OUTER LINES
        //UP
        if(isActiveQStrokes[0])
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, INITIAL_ANGLE, INITIAL_ANGLE*2);
        //LEFT
        if(isActiveQStrokes[1])
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 3*INITIAL_ANGLE, INITIAL_ANGLE*2);
        //DOWN
        if(isActiveQStrokes[2])
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 5*INITIAL_ANGLE, INITIAL_ANGLE*2);
        //RIGHT
        if(isActiveQStrokes[3])
        qs.drawArc(80 + 10, 80 + 10, WIDTH-20-(80+10)*2, HEIGHT-20-(80+10)*2, 7*INITIAL_ANGLE, INITIAL_ANGLE*2);


        //INNER LINES
        //UP
        if(isActiveQStrokes[4])
        qs.drawArc(WIDTH/2 - (HEIGHT-20-(80-10)*2)/2 , -(HEIGHT-20-(80-10)*2)/2 - INNERConst, WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*5, INITIAL_ANGLE*2);
        //RIGHT
        if(isActiveQStrokes[5])
        qs.drawArc(WIDTH - (HEIGHT-20-(80-10)*2)/2 + INNERConst, -(-20-(80-10)*2)/2 - HConst/2 , WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*3, INITIAL_ANGLE*2);
        //LEFT
        if(isActiveQStrokes[6])
        qs.drawArc(-(HEIGHT-20-(80-10)*2)/2 - INNERConst , -(-20-(80-10)*2)/2 - HConst/2 , WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE*7, INITIAL_ANGLE*2);
        //DOWN
        if(isActiveQStrokes[7])
        qs.drawArc(WIDTH/2 - (HEIGHT-20-(80-10)*2)/2 , HEIGHT/2  -(-(80-10)*2)/2 - HConst/2 + INNERConst, WIDTH-20-(80-10)*2, HEIGHT-20-(80-10)*2, INITIAL_ANGLE, INITIAL_ANGLE*2);


        qs.setColor(INACTIVE);
        //q0
        qs.fillOval(80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);

        //q1
        qs.fillOval(WIDTH-CIRCLES_SIZE -80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);
        //q2
        qs.fillOval(80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE,CIRCLES_SIZE);
        //q3
        qs.fillOval(WIDTH-CIRCLES_SIZE -80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE, CIRCLES_SIZE);

        qs.setColor(INACTIVELine);
        qs.drawOval(80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);
        qs.drawOval(80+15,80+15,
                CIRCLES_SIZE-30,CIRCLES_SIZE-30);
        qs.drawOval(WIDTH-CIRCLES_SIZE -80,80,
                CIRCLES_SIZE,CIRCLES_SIZE);
        qs.drawOval(80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE,CIRCLES_SIZE);
        qs.drawOval(WIDTH-CIRCLES_SIZE -80,HEIGHT - CIRCLES_SIZE -80 -20,
                CIRCLES_SIZE, CIRCLES_SIZE);

        qs.setStroke(new BasicStroke(4.0f));
        //q0
        if(isActiveQCircle[0]){
            qs.setColor(ACTIVE);
            qs.fillOval(80,80,
                    CIRCLES_SIZE,CIRCLES_SIZE);
            qs.setColor(ACTIVELine);
            qs.drawOval(80,80,
                    CIRCLES_SIZE,CIRCLES_SIZE);
            qs.drawOval(80+15,80+15,
                    CIRCLES_SIZE-30,CIRCLES_SIZE-30);
        }
        //q1
        if(isActiveQCircle[1]){
            qs.setColor(ACTIVE);
            qs.fillOval(WIDTH-CIRCLES_SIZE -80,80,
                    CIRCLES_SIZE,CIRCLES_SIZE);
            qs.setColor(ACTIVELine);
            qs.drawOval(WIDTH-CIRCLES_SIZE -80,80,
                    CIRCLES_SIZE,CIRCLES_SIZE);
        }
        //q2
        if(isActiveQCircle[2]){
            qs.setColor(ACTIVE);
            qs.fillOval(80,HEIGHT - CIRCLES_SIZE -80 -20,
                    CIRCLES_SIZE,CIRCLES_SIZE);
            qs.setColor(ACTIVELine);
            qs.drawOval(80,HEIGHT - CIRCLES_SIZE -80 -20,
                    CIRCLES_SIZE,CIRCLES_SIZE);
        }
        //q3
        if(isActiveQCircle[3]) {
            qs.setColor(ACTIVE);
            qs.fillOval(WIDTH-CIRCLES_SIZE -80,HEIGHT - CIRCLES_SIZE -80 -20,
                    CIRCLES_SIZE, CIRCLES_SIZE);
            qs.setColor(ACTIVELine);
            qs.drawOval(WIDTH-CIRCLES_SIZE -80,HEIGHT - CIRCLES_SIZE -80 -20,
                    CIRCLES_SIZE, CIRCLES_SIZE);
        }

        qs.setColor(INACTIVELine);
        qs.setFont(new Font("Arial",Font.BOLD,30));
        qs.drawString("PROTOCOL FOR SENDING DATA", 110, 40);

        qs.setFont(new Font("Arial",Font.PLAIN,30));
        qs.drawString("Q0", 80 + CIRCLES_SIZE/2 - 20, 80 + CIRCLES_SIZE/2 + 10);
        qs.drawString("Q1", 90 - 20 + WIDTH-CIRCLES_SIZE -80, 80 + CIRCLES_SIZE/2 + 10);

        qs.drawString("Q2", 80 + CIRCLES_SIZE/2 - 20, 80 + CIRCLES_SIZE/2 + 10 + HEIGHT/2 - HConst/2);
        qs.drawString("Q3", 90 - 20 + WIDTH-CIRCLES_SIZE -80, 80 + CIRCLES_SIZE/2 + 10 + HEIGHT/2 - HConst/2);
        qs.drawString(String.valueOf(number), WIDTH/2, HEIGHT -50);

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

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("Protocol");
        Function fun = new Function();

        String[] binaryCode = new String[1000000];

        fileManager fm = new fileManager();
        String acepted = "";
        String rechazed = "";

        Main protocol = new Main();
        int i = 0, j = 0;
        int circle = 0, line = 0;

        frame.add(protocol);

        frame.setSize(protocol.WIDTH, protocol.HEIGHT + protocol.HConst);
        frame.setLocation(protocol.dim.width/2-frame.getSize().width/2, protocol.dim.height/2-frame.getSize().height/2);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fm.createBinaryFile();

        while (( protocol.isActive = Utils.genRanBool() ) && i < 1000000) {
            protocol.isActiveQCircle[0] = true;

            TimeUnit.SECONDS.sleep(2);
            binaryCode[j] = Utils.generateBinary();
            protocol.isActiveQCircle[0] = false;

            for(char c : binaryCode[j].toCharArray()){
                protocol.isActiveQCircle[circle] = false;
                protocol.isActiveQStrokes[line] = false;

                protocol.repaint();
                Thread.sleep(10);

                protocol.number = c;
                circle = fun.Moviment(c);
                line = fun.strokeLine;

                protocol.isActiveQCircle[circle] = true;
                protocol.isActiveQStrokes[line] = true;

                protocol.repaint();
                Thread.sleep(10);

                TimeUnit.MILLISECONDS.sleep(100);

            }
            fm.appendBinaryString(binaryCode[j]);
            binaryCode[j] += " ";
            if(fun.currentState == 0){
                acepted += binaryCode[j++];
                System.out.println("Acepted");
            }
            else{
                rechazed += binaryCode[j++];
                System.out.println("Rechazed");

                protocol.isActiveQCircle[circle] = false;
                protocol.isActiveQStrokes[line] = false;

                protocol.repaint();
                Thread.sleep(10);
            }
        }

        frame.dispose();
        fm.writeFiles(acepted,rechazed);
        System.out.println("Program finished.");
    }
}

