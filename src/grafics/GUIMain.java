package grafics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class GUIMain extends JFrame {


    private JPanel MyGUIMain;
    private JButton jugarButton;
    private JButton rankingButton;
    private JButton gestióUsuariButton;
    private JButton gestióProblemaButton;

    public GUIMain() {

        gestióUsuariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIUsuari user = new GUIUsuari();
                user.main();
                MyGUIMain.setVisible(false);


            }
        });

        gestióProblemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek2");
            }
        });

        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyGUIMain.setVisible(false);
            }
        });
        rankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"kek4");
            }
        });


    }

    public static void main(String[] args) {
        JFrame main = new JFrame("Main");
        main.setContentPane(new GUIMain().MyGUIMain);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setBounds(500,300,250,250);

        main.setVisible(true);


    }


}
