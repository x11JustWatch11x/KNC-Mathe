import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;

    JButton ableitung1 = new JButton("erste Ableitung");
    JButton ableitung2 = new JButton("zweite Ableitung");
    JButton ableitung3 = new JButton("dritte Ableitung");
    JButton nullstellen = new JButton("Nullstellen bestimmen");
    JButton extremp = new JButton("Extrempunkte bestimmen");
    JButton wendep = new JButton("Wendepunkte bestimmen");

    public static MainFrame Instance;
    public String funktion = "";

    MainFrame(){

        //set up the frame
        this.setTitle("Was wollen Sie berechnen?");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new java.awt.Color(60, 60, 60));
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setSize(900, 400);

        //add the panel


        JLabel label1 = new JLabel();
        this.add(label1);
        label1.setText("Tippen Sie die Funktion ein:   f(x) =  ");
        label1.setBounds(120, 2, 500, 100);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

        JTextArea taFunktion = new JTextArea();
        this.add(taFunktion);
        taFunktion.setText("");

        taFunktion.setBounds(470, 38, 500, 30);
        taFunktion.setOpaque(false);
        taFunktion.setBackground(new Color(0, 0, 0, 0));
        taFunktion.setForeground(Color.WHITE);
        taFunktion.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        taFunktion.requestFocus();

        panel1 = new MainFramePanel();
        panel1.setPreferredSize(new Dimension(100, 90));
        this.getContentPane().add(panel1, BorderLayout.NORTH);


        panel2 = new MainFramePanel();
        panel2.setPreferredSize(new Dimension(100, 50));
        this.getContentPane().add(panel2, BorderLayout.SOUTH);

        panel3 = new MainFramePanel();
        this.getContentPane().add(panel3, BorderLayout.EAST);

        panel4 = new MainFramePanel();
        this.getContentPane().add(panel4, BorderLayout.WEST);

        panel5 = new MainFramePanel();
        panel5.setLayout(new GridLayout(3, 2, 10, 10));
        this.getContentPane().add(panel5, BorderLayout.CENTER);

        nullstellen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                funktion = taFunktion.getText();
                NullStellenFrame frame = new NullStellenFrame();
            }
        } );

        ableitung1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                funktion = taFunktion.getText();
                FrameErsteAbleitung frame = new FrameErsteAbleitung();
            }
        } );

        panel5.add(ableitung1);
        panel5.add(nullstellen);
        panel5.add(ableitung2);
        panel5.add(extremp);
        panel5.add(ableitung3);
        panel5.add(wendep);

        Instance = this;

        this.setVisible(true);


    }
}
