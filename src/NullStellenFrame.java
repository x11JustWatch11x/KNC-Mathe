import javax.swing.*;
import java.awt.*;

public class NullStellenFrame extends JFrame {

    NullStellenPanel panel = new NullStellenPanel();

    public static NullStellenFrame Instance;

    int a, b, c;
    String funktion;


    NullStellenFrame(){

        this.setTitle("Nullstellen berechnen");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new java.awt.Color(60, 60, 60));
        this.setResizable(true);
        this.setVisible(true);

        this.add(panel);

        //Funktion implementieren
        funktion = MainFrame.Instance.funktion.replace(" ", "");
        // a, b, c bestimmen
        for(int i = 0; i < funktion.length(); i++){
            if(funktion.charAt(i) == '^' && funktion.charAt(i + 1) == '2'){
                // a
                if(i == 1){
                    a = 1;
                }
                else if(funktion.charAt(i - 2) == '-'){
                    a = -1;
                }
                else{
                    a = Integer.parseInt(funktion.substring(0, i - 1));
                }
            }
            //b
            if(funktion.charAt(i) == 'x' && funktion.charAt(i + 1) != '^'){
                if(funktion.charAt(i - 1) == '-'){
                    b = -1;
                }
                if(funktion.charAt(i - 1) == '+'){
                    b = 1;
                }
                else {
                    int j = i - 1;
                    String koef = "";
                    while (Character.isDigit(funktion.charAt(j))) {
                        koef = funktion.charAt(j) + koef;
                        j--;
                    }
                    if(funktion.charAt(j) == '-') b = Integer.parseInt(koef) * -1;
                    else b = Integer.parseInt(koef);
                }
            }
            //c
            if(funktion.charAt(funktion.length() - 1) == 'x') c = 0;
            else{
                int j = funktion.length() - 1;
                String koef = "";
                while (Character.isDigit(funktion.charAt(j))) {
                    koef = funktion.charAt(j) + koef;
                    j--;
                }
                if(funktion.charAt(j) == '-') c = Integer.parseInt(koef) * -1;
                else c = Integer.parseInt(koef);
            }
        }



        JLabel label1 = new JLabel();
        panel.add(label1);
        label1.setText("Funktion:     f(x) =");
        label1.setBounds(350, 10, 200, 50);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        JTextArea ta2_1 = new JTextArea();
        if(b < 0){
            if(c < 0) ta2_1.setText(a + "x" + " - " + b * -1 + "x" + " - " + c * -1);

            else ta2_1.setText(a + "x" + " - " + b * -1 + "x" + " + " + c);

        }
        else{
            if(c < 0) ta2_1.setText(a + "x" + " + " + b + "x" + " - " + c * -1);

            else ta2_1.setText(a + "x" + " + " + b + "x" + " + " + c);

        }
        ta2_1.setEditable(false);
        ta2_1.setBounds(372, 150, 320, 50);
        ta2_1.setOpaque(false);
        ta2_1.setBackground(new Color(0, 0, 0, 0));
        ta2_1.setForeground(Color.LIGHT_GRAY);
        ta2_1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        panel.add(ta2_1);

        JLabel label2 = new JLabel();
        panel.add(label2);
        label2.setText(ta2_1.getText());
        label2.setBounds(540, 10, 300, 50);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));




        JTextArea taErster = new JTextArea();
        panel.add(taErster);
        taErster.setText("1)");
        taErster.setEditable(false);
        taErster.setBounds(60, 140, 50, 50);
        taErster.setOpaque(false);
        taErster.setBackground(new Color(0, 0, 0, 0));
        taErster.setForeground(new java.awt.Color(229,184,11));
        taErster.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 40));

        JTextArea ta1 = new JTextArea();
        panel.add(ta1);
        ta1.setText("f(x) = 0    <=>  f(x) = ");
        ta1.setEditable(false);
        ta1.setBounds(150, 150, 300, 50);
        ta1.setOpaque(false);
        ta1.setBackground(new Color(0, 0, 0, 0));
        ta1.setForeground(Color.LIGHT_GRAY);
        ta1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));



        JTextArea RS1 = new JTextArea();
        panel.add(RS1);
        RS1.setText("Die Funktionsgleichung gleich 0 setzen");
        RS1.setEditable(false);
        RS1.setBounds(670, 150, 500, 50);
        RS1.setOpaque(false);
        RS1.setBackground(new Color(0, 0, 0, 0));
        RS1.setForeground(Color.LIGHT_GRAY);
        RS1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        JTextArea taZweiter = new JTextArea();
        panel.add(taZweiter);
        taZweiter.setText("2)");
        taZweiter.setEditable(false);
        taZweiter.setBounds(60, 280, 50, 50);
        taZweiter.setOpaque(false);
        taZweiter.setBackground(new Color(0, 0, 0, 0));
        taZweiter.setForeground(new java.awt.Color(229,184,11));
        taZweiter.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 40));

        JTextArea ta4 = new JTextArea();
        panel.add(ta4);
        ta4.setText("x    =   ");
        ta4.setEditable(false);
        ta4.setBounds(150, 295, 100, 50);
        ta4.setOpaque(false);
        ta4.setBackground(new Color(0, 0, 0, 0));
        ta4.setForeground(Color.LIGHT_GRAY);
        ta4.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        JTextArea ta5 = new JTextArea();
        ta5.setText(String.valueOf(b * -1));
        ta5.setEditable(false);
        ta5.setBounds(280, 280, 320, 50);
        ta5.setOpaque(false);
        ta5.setBackground(new Color(0, 0, 0, 0));
        ta5.setForeground(Color.LIGHT_GRAY);
        ta5.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        panel.add(ta5);

        JTextArea taWurzel = new JTextArea();
        if(b < 0) {
            if(a < 0 && c < 0) taWurzel.setText(b * -1 + "  - [4" + "   (" + a + ")    (" + c + ")]");
            else if(a < 0 && c > 0) taWurzel.setText(b * -1 + "  - [4" + "   (" + a + ")    " + c + "]");
            else if(a > 0 && c < 0) taWurzel.setText(b * -1 + "  - [4" + "   " + a + "    (" + c + ")]");
            else taWurzel.setText(b * -1 + "  - (4" + "   " + a + "    " + c + ")");
        }
        else{
            if(a < 0 && c < 0) taWurzel.setText(b + "  - [4" + "   (" + a + ")    (" + c + ")]");
            else if(a < 0 && c > 0) taWurzel.setText(b + "  - [4" + "   (" + a + ")    " + c + "]");
            else if(a > 0 && c < 0) taWurzel.setText(b + "  - [4" + "   " + a + "    (" + c + ")]");
            else taWurzel.setText(b + "  - (4" + "   " + a + "    " + c + ")");
        }
        taWurzel.setEditable(false);
        taWurzel.setBounds(386, 280, 320, 50);
        taWurzel.setOpaque(false);
        taWurzel.setBackground(new Color(0, 0, 0, 0));
        taWurzel.setForeground(Color.LIGHT_GRAY);
        taWurzel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        panel.add(taWurzel);

        JTextArea RS2 = new JTextArea();
        panel.add(RS2);
        RS2.setText("Die abc-Formel anwenden mit a = " + a + ", \n");
        RS2.append("b = " + b + ", c = " + c);
        RS2.setEditable(false);
        RS2.setLineWrap(true);
        RS2.setBounds(670, 280, 370, 50);
        RS2.setOpaque(false);
        RS2.setBackground(new Color(0, 0, 0, 0));
        RS2.setForeground(Color.LIGHT_GRAY);
        RS2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));


        JTextArea nenner = new JTextArea();
        panel.add(nenner);
        if(a < 0) nenner.setText("2      (" + a + ")");
        else nenner.setText("2      " + a);
        nenner.setEditable(false);
        nenner.setBounds(382, 315, 460, 50);
        nenner.setOpaque(false);
        nenner.setBackground(new Color(0, 0, 0, 0));
        nenner.setForeground(Color.LIGHT_GRAY);
        nenner.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        //Wenn es eine Lösung gibt:
        if((b * b) - (4 * a * c) > 0) {
            double x1 = Math.round((((b * -1) - (Math.pow((b * b) - (4 * a * c), 0.5))) / (2 * a)) * 1000d) / 1000d;
            double x2 = Math.round((((b * -1) + (Math.pow((b * b) - (4 * a * c), 0.5))) / (2 * a)) * 1000d) / 1000d;
            JTextArea ta7 = new JTextArea();
            panel.add(ta7);
            ta7.setText("x  =   " + x1);
            ta7.setEditable(false);
            ta7.setBounds(150, 390, 200, 50);
            ta7.setOpaque(false);
            ta7.setBackground(new Color(0, 0, 0, 0));
            ta7.setForeground(Color.LIGHT_GRAY);
            ta7.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea ta8 = new JTextArea();
            panel.add(ta8);
            ta8.setText("x  =   " + x2);
            ta8.setEditable(false);
            ta8.setBounds(400, 390, 200, 50);
            ta8.setOpaque(false);
            ta8.setBackground(new Color(0, 0, 0, 0));
            ta8.setForeground(Color.LIGHT_GRAY);
            ta8.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea RS3 = new JTextArea();
            panel.add(RS3);
            RS3.setText("Den Term vereinfachen. \n");
            RS3.append("x   und x   bestimmen");
            RS3.setEditable(false);
            RS3.setBounds(670, 390, 300, 50);
            RS3.setOpaque(false);
            RS3.setBackground(new Color(0, 0, 0, 0));
            RS3.setForeground(Color.LIGHT_GRAY);
            RS3.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea Antwortsatz = new JTextArea();
            panel.add(Antwortsatz);
            Antwortsatz.setText("LS:  Die beiden Nullstellen liegen bei  N (" + x1 + " | 0),");
            Antwortsatz.setEditable(false);
            Antwortsatz.setBounds(300, 515, 700, 50);
            Antwortsatz.setOpaque(false);
            Antwortsatz.setBackground(new Color(0, 0, 0, 0));
            Antwortsatz.setForeground(new java.awt.Color(229,184,11));
            Antwortsatz.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea n2 = new JTextArea();
            panel.add(n2);
            n2.setText("N (" + x2 + " | 0) .");
            n2.setEditable(false);
            n2.setBounds(845, 515, 700, 50);
            n2.setOpaque(false);
            n2.setBackground(new Color(0, 0, 0, 0));
            n2.setForeground(new java.awt.Color(229,184,11));
            n2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        }
        //Wenn es keine Lösung gibt:
        else{
            JTextArea keineLösungWurzel = new JTextArea();
            panel.add(keineLösungWurzel);
            keineLösungWurzel.setText(taWurzel.getText());
            keineLösungWurzel.setEditable(false);
            keineLösungWurzel.setBounds(100, 410, 300, 50);
            keineLösungWurzel.setOpaque(false);
            keineLösungWurzel.setBackground(new Color(0, 0, 0, 0));
            keineLösungWurzel.setForeground(Color.LIGHT_GRAY);
            keineLösungWurzel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea keineLösung2 = new JTextArea();
            panel.add(keineLösung2);
            keineLösung2.setText(":  Wurzel aus negativer Zahl!");
            keineLösung2.setEditable(false);
            keineLösung2.setBounds(320, 410, 300, 50);
            keineLösung2.setOpaque(false);
            keineLösung2.setBackground(new Color(0, 0, 0, 0));
            keineLösung2.setForeground(Color.LIGHT_GRAY);
            keineLösung2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea RS3 = new JTextArea();
            panel.add(RS3);
            RS3.setText("Den Term vereinfachen. \n");
            RS3.append("x   und x   bestimmen");
            RS3.setEditable(false);
            RS3.setBounds(670, 390, 300, 50);
            RS3.setOpaque(false);
            RS3.setBackground(new Color(0, 0, 0, 0));
            RS3.setForeground(Color.LIGHT_GRAY);
            RS3.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

            JTextArea Antwortsatz = new JTextArea();
            panel.add(Antwortsatz);
            Antwortsatz.setText("LS: Diese Funktion besitzt keine Nullstellen!");
            Antwortsatz.setEditable(false);
            Antwortsatz.setBounds(320, 515, 500, 50);
            Antwortsatz.setOpaque(false);
            Antwortsatz.setBackground(new Color(0, 0, 0, 0));
            Antwortsatz.setForeground(new java.awt.Color(229,184,11));
            Antwortsatz.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        }

        this.pack();

        Instance = this;
    }




}
