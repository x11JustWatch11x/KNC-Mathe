import javax.swing.*;
import java.awt.*;

public class PanelErsteAbleitung extends JPanel {



    PanelErsteAbleitung(){
        this.setBackground(new java.awt.Color(40, 40, 40));
        this.setPreferredSize(new Dimension(900, 400));
        this.setLayout(null);
    }

    public void paintComponent(Graphics g){
        Integer[][] terme = FrameErsteAbleitung.Instance.Terme;


        // initialisere die Variablen



        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));


        //Exponenten der eingegebenen Funktion --> oben
        //PS: (SEHR WICHTIG) die Leerzeichen haben eine Länge von 0,5!!!
        int count = 0;
        int anzahlSpaces;
        if(terme[0][0] == 1) anzahlSpaces = 1;
        else if(terme[0][0] == -1) anzahlSpaces = 2;
        else anzahlSpaces = Integer.toString(terme[0][0]).length() + 1;
        while(terme[count][0] != null && terme[count][1] > 1) {
            g2d.drawString(Integer.toString(terme[count][1]), FrameErsteAbleitung.Instance.Funktionsgleichung.getX() + (int) Math.ceil(anzahlSpaces * 12.7), FrameErsteAbleitung.Instance.Funktionsgleichung.getY() + 5);
            count++;
            if (terme[count][0] != null) {
                if (terme[count][0] == 1 || terme[count][0] == -1) anzahlSpaces += 0;
                else if (terme[count][0] < 0) anzahlSpaces += (Integer.toString(terme[count][0]).length() - 1);
                else anzahlSpaces += (Integer.toString(terme[count][0])).length();
                anzahlSpaces += 3;
            }
        }

        int countAbleitung = 0;
        int countSpaces;
        if(terme[0][0] == 1) countSpaces = 4;
        else if(terme[0][0] == -1) countSpaces = 8;
        else countSpaces = Integer.toString(terme[0][0]).length() + 4;
        while(terme[countAbleitung][0] != null && terme[countAbleitung][1] > 0){
            g2d.drawString(terme[countAbleitung][1] + "-1",FrameErsteAbleitung.Instance.ableitung1.getX()+(int)Math.ceil(countSpaces*12.2),FrameErsteAbleitung.Instance.ableitung1.getY()+5);
            countAbleitung++;
            if(terme[countAbleitung][0] == 1 || terme[countAbleitung][0] == -1) countSpaces+=8;
            else if(terme[countAbleitung][0] < 0) countSpaces += (Integer.toString(terme[countAbleitung][0]).length() + 7);
            else countSpaces += (Integer.toString(terme[countAbleitung][0]).length() + 8);
        }

    }


}