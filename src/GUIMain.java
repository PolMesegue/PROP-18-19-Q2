import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMain {
    private JButton gestióUsuariButton;
    private JButton gestióPorblemesButton;
    private JButton jugarButton;
    private JButton rankingButton;
    private JPanel PanellMain;


    public GUIMain() {
        gestióUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIUsuari user = new GUIUsuari();
                user.setVisible(true);

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("escacs");
        frame.setContentPane(new GUIMain().PanellMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
