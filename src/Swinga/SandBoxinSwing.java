package Swinga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SandBoxinSwing extends JFrame {
    public static void main(String[] args) {
        new SandBoxinSwing();
    }

    JButton btn1;
    JPanel panel = new JPanel();
    JTextField textField = new JTextField("Type here");

    SandBoxinSwing() {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Just a title");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setLocation((int) dim.getWidth() / 2 - this.getWidth(), (int) dim.getHeight() / 2 - this.getHeight());


        //btn
        btn1 = new JButton("Click that");
        ButtonListen btnListen = new ButtonListen();
        btn1.addActionListener(btnListen);
        panel.add(btn1);

        //tfield
        textField.requestFocus();
        TextFieldListener textFieldListener = new TextFieldListener();
        textField.addActionListener(textFieldListener);
        panel.add(textField);

        this.add(panel);
        this.setVisible(true);

    }

    private class TextFieldListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == textField) {
                JOptionPane.showMessageDialog(null, "Holla");
            }
        }
    }

    private class ButtonListen implements ActionListener {


        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn1) {
                System.out.println("im in terminal now!");
            }
        }
    }

}

