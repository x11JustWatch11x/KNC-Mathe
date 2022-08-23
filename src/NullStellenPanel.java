import javax.swing.*;
import java.awt.*;

public class NullStellenPanel extends JPanel {

    public static NullStellenPanel Instance;

    NullStellenPanel(){
        this.setBackground(new java.awt.Color(40, 40, 40));
        this.setPreferredSize(new Dimension(1100, 600));
        this.setLayout(null);
    }

    public void paintComponent(Graphics g) {
        int a = NullStellenFrame.Instance.a;
        int b = NullStellenFrame.Instance.b;
        int c = NullStellenFrame.Instance.c;


        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(2));

        // Quadrat innerhalb der Wurzel
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        if (b >= 10 || b <= -10) g2d.drawString("2", 412, 285);
        else g2d.drawString("2", 402, 285);

        //Index abc-Formel
        g2d.drawString("1", 165, 320);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(172, 321, 175, 312);
        g2d.drawString("2", 177, 320);

        //funktion oben
        g2d.setColor(Color.WHITE);
        if (a < 0 || a >= 10) g2d.drawString("2", 578, 30);
        else g2d.drawString("2", 566, 30);
        g2d.setColor(Color.LIGHT_GRAY);

        //funktion bei "gleich 0 setzen"
        if (a < 0 || a >= 10) g2d.drawString("2", 409,  155);
        else g2d.drawString("2", 397, 155);

        g2d.setStroke(new BasicStroke(2));
        //Wurzel
        g2d.drawLine(373, 287, 377, 300);
        g2d.drawLine(377, 301, 384, 275);
        g2d.drawLine(384, 274, 580, 274);

        // Geteiltzeichen
        g2d.drawLine(270, 310, 590, 310);

        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        // Malzeichen im Nenner
        g2d.drawString(".", 410, 331);

        //Malzeichen in der Wurzel
        if(b <= -10 || b >= 10) {
            g2d.drawString(".", 470, 294);
            if (a < 0) g2d.drawString(".", 528, 294);
            else if (a >= 10) g2d.drawString(".", 512, 294);
            else g2d.drawString(".", 500, 294);
        }
        else{
            g2d.drawString(".", 450, 294);
            if (a < 0) g2d.drawString(".", 518, 294);
            else if (a >= 10) g2d.drawString(".", 502, 294);
            else g2d.drawString(".", 490, 294);
        }
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        g2d.drawString("+", 330, 290);
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        g2d.drawString("-", 332, 302);

        //Rechenwege
        g2d.drawLine(660, 280, 660, 330);
        g2d.drawLine(660, 390, 660, 440);
        g2d.drawLine(660, 150, 660, 200);

        //Wenn es eine Lösung gibt:
        //Index x1, x2
        if ((b * b) - (4 * a * c) > 0) {
            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
            g2d.drawString("1", 164, 415);
            g2d.drawString("2", 414, 415);

            g2d.setColor(new Color(229,184,11));
            g2d.drawString("1", 679, 537);
            g2d.drawString("2", 859, 537);
            g2d.setColor(Color.LIGHT_GRAY);
        }
        else{
            //Wenn es keine Lösung gibt:
            g2d.drawLine(83, 417, 87, 430);
            g2d.drawLine(87, 431, 94, 405);
            g2d.drawLine(94, 404, 290, 404);

            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
            if (b >= 10 || b <= -10) g2d.drawString("2", 126, 417);
            else g2d.drawString("2", 117, 417);

            g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            if(b >= 10 || b <= -10){
                g2d.drawString(".", 180, 425);
                if (a < 0) g2d.drawString(".", 243, 425);
                else if (a >= 10) g2d.drawString(".", 237, 425);
                else g2d.drawString(".", 215, 425);
            }
            else {
                g2d.drawString(".", 167, 425);
                if (a < 0) g2d.drawString(".", 240, 425);
                else if (a >= 10) g2d.drawString(".", 224, 425);
                else g2d.drawString(".", 202, 425);
            }
        }

        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        g2d.drawString("1", 683, 440);
        g2d.drawString("2", 757, 440);


    }



}
