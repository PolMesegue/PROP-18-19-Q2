package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITaulell {
    private JPanel MyTaulell;
    private JButton Button00;
    private JButton Button02;

    public GUITaulell() {
        Button00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon kek = new ImageIcon("icons8-knight-40(1).png");
                Button02.setIcon(kek);
            }
        });
    }

    public JPanel getMyTaulell() {
        return MyTaulell;
    }
}

