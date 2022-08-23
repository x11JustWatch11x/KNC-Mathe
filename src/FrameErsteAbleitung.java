import javax.swing.*;
import java.awt.*;

public class FrameErsteAbleitung extends JFrame{

    PanelErsteAbleitung panel = new PanelErsteAbleitung();

    public static FrameErsteAbleitung Instance;

    int a, b, c;
    Integer AnzahlTerme;
    public Integer[][] Terme;
    //erste Menge: Term an welcher Stelle
    //zweite Menge: Koeffizient und Exponent

    public JTextArea Funktionsgleichung;
    public JTextArea ableitung1;

    FrameErsteAbleitung(){
        this.setTitle("Was wollen Sie berechnen?");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new java.awt.Color(60, 60, 60));
        this.setSize(900, 400);
        this.setResizable(false);
        this.setVisible(true);

        this.add(panel);

        JTextArea Funktion = new JTextArea();
        panel.add(Funktion);
        Funktion.setText("Funktion:   f(x) = ");
        Funktion.setEditable(false);
        Funktion.setBounds(250, 40, 180, 30);
        Funktion.setOpaque(false);
        Funktion.setBackground(new Color(0, 0, 0, 0));
        Funktion.setForeground(Color.WHITE);
        Funktion.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        //Funktion initialisieren
        String funktion = MainFrame.Instance.funktion.replace(" ", "");


        int temp = 0;
        while(funktion.charAt(temp) != '^'){
            temp++;
        }
        AnzahlTerme = Character.getNumericValue(funktion.charAt(temp + 1)) + 1;
        Terme = new Integer[AnzahlTerme][2];
        Terme[0][1] = AnzahlTerme - 1; //Exponent
        if(temp == 1){
            Terme[0][0] = 1;
        }
        else{
            if(funktion.charAt(0) == '-' && temp == 2){
                Terme[0][0] = -1;
            }
            else Terme[0][0] = Integer.parseInt(funktion.substring(0, temp - 1));
        }

        // Terme der Funktion bestimmen
            //count für die Position des Terms im Array
        int count = 1;
        for(int i = temp + 2; i < funktion.length(); i++) {
            if(funktion.charAt(i) == 'x' && i != funktion.length() - 1 && funktion.charAt(i + 1) == '^'){
                int j = i -1;
                if(funktion.charAt(j) == '+') {
                    Terme[count][0] = 1;
                }
                else if(funktion.charAt(j) == '-') {
                    Terme[count][0] = -1;
                }
                else {
                    while (Character.isDigit(funktion.charAt(j))) {
                        j--;
                    }
                    Terme[count][0] = Integer.parseInt(funktion.substring(j, i));
                }
                Terme[count][1] = Character.getNumericValue(funktion.charAt(i + 2));
                count++;
            } else if(funktion.charAt(i) == 'x' && i == funktion.length() - 1 || funktion.charAt(i) == 'x' && funktion.charAt(i + 1) != '^'){
                int j = i - 1;
                if(funktion.charAt(j) == '+') Terme[count][0] = 1;
                else if(funktion.charAt(j) == '-') Terme[count][0] = -1;
                else{
                    while (Character.isDigit(funktion.charAt(j))) {
                        j--;
                    }
                    Terme[count][0] = Integer.parseInt(funktion.substring(j, i));
                }
                Terme[count][1] = 1;
            }
        }
        count++;
        if(Character.isDigit(funktion.charAt(funktion.length() - 1))){
            int start = funktion.length() - 1;
            while(Character.isDigit(funktion.charAt(start))){
                start--;
            }
            Terme[count][1] = 0;
            Terme[count][0] = Integer.parseInt(funktion.substring(start, funktion.length()));
        }

        int versuch = 0;
        while(versuch < Terme.length){
            System.out.println(Terme[versuch][0] + "x^" + Terme[versuch][1]);
            versuch++;
        }

        Funktionsgleichung = new JTextArea();
        panel.add(Funktionsgleichung);
        if(Terme[0][0] == 1) Funktionsgleichung.setText("x");
        else if(Terme[0][0] == -1) Funktionsgleichung.setText("-x");
        else Funktionsgleichung.setText(Terme[0][0] + "x");
        int counter = 1;
        while(counter < Terme.length){
            if(Terme[counter][0] == null || Terme[counter][1] == null) counter++;
            else if(Terme[counter][1] > 0) {
                if (Terme[counter][0] == 1) Funktionsgleichung.append(" + x");
                else if (Terme[counter][0] > 0) Funktionsgleichung.append(" + " + Terme[counter][0] + "x");
                else if (Terme[counter][0] == -1) Funktionsgleichung.append(" - x");
                else Funktionsgleichung.append(" - " + Terme[counter][0] * -1 + "x");
            }
            else if(Terme[counter][1] == 0){
                if(Terme[counter][0] > 0) Funktionsgleichung.append(" + " + Terme[counter][0]);
                else Funktionsgleichung.append(" - " + Terme[counter][0] * -1);
            }
            counter++;
        }

        Funktionsgleichung.setEditable(false);
        Funktionsgleichung.setBounds(420, 40, 500, 20);
        Funktionsgleichung.setOpaque(false);
        Funktionsgleichung.setBackground(new Color(0, 0, 0, 0));
        Funktionsgleichung.setForeground(Color.WHITE);
        Funktionsgleichung.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        /*
        JTextArea fvonx = new JTextArea();
        panel.add(fvonx);
        fvonx.setText("f (x) =");
        fvonx.setEditable(false);
        fvonx.setBounds(150, 120, 100, 30);
        fvonx.setOpaque(false);
        fvonx.setBackground(new Color(0, 0, 0, 0));
        fvonx.setForeground(Color.WHITE);
        fvonx.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        ableitung1 = new JTextArea();
        panel.add(ableitung1);
        ableitung1.setEditable(false);
        ableitung1.setBounds(230, 120, 700, 30);
        ableitung1.setOpaque(false);
        ableitung1.setBackground(new Color(0, 0, 0, 0));
        ableitung1.setForeground(Color.WHITE);
        ableitung1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));

        if(Terme[0][0] == 1) ableitung1.setText(Terme[0][1] + " * x");
        else if(Terme[0][0] == -1) ableitung1.setText("- " + Terme[0][1] + " * x");
        else ableitung1.setText(Terme[0][1] + " * " + Terme[0][0] + "x");
        int countableitung = 1;
        while(Terme[countableitung][0] != null && Terme[countableitung][1] > 0){
            if(Terme[countableitung][0] == 1) ableitung1.append("   +   " + Terme[countableitung][1] + " * x");
            else if(Terme[countableitung][0] > 0) ableitung1.append("   +   " + Terme[countableitung][1] + " * " + Terme[countableitung][0] + "x");
            else if(Terme[countableitung][0] == -1) ableitung1.append("   -   " + Terme[countableitung][1] + " * x");
            else ableitung1.append("   -   " + Terme[countableitung][1] +  " * " + Terme[countableitung][0] * -1 + "x");
            countableitung++;
        }

         */

        //7x^4 - x^3 + 5x^2 + 2x - 12

        Instance = this;
    }
}
