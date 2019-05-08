import javax.swing.*;

public class GUIUsuari {
    private JPanel PanellUsuari;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;


    public static void main(String[] args) {
        JFrame frame = new JFrame("escacs");
        frame.setContentPane(new GUIUsuari().PanellUsuari);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}