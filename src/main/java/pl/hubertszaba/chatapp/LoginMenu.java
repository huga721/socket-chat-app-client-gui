package pl.hubertszaba.chatapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame implements ActionListener {

    private JButton button;
    private JTextField text;
    TextMenu menu;

    public LoginMenu(String title) {
        super(title);
        init();
    }

    private void init() {
        this.setLayout(new FlowLayout());
        this.setContentPane(mainPanel());
        this.setResizable(false);
        this.pack();


        this.setContentPane(mainPanel());
    }
    private JPanel mainPanel() {
        JPanel panel = new JPanel();
        //panel.setPreferredSize(new Dimension(500,500));
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setOpaque(true);
        panel.add(panelLabel(), BorderLayout.WEST);
        panel.add(panelText(), BorderLayout.EAST);
        panel.add(loginButton(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel panelLabel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(labelNick(), BorderLayout.NORTH);
//        panel.add(labelPort(),BorderLayout.SOUTH);
        panel.setVisible(true);
        return panel;
    }

    private JPanel panelText() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(textNick(), BorderLayout.NORTH);
//        panel.add(textPort(),BorderLayout.SOUTH);
        panel.setVisible(true);
        return panel;
    }

    private JTextField textNick() {
        text = new JTextField(10);
        text.setFont(new Font("MV Boli", Font.PLAIN, 25));
        return text;
    }

    //    private JTextField textPort(){
//        JTextField text = new JTextField(10);
//        text.setFont(new Font("MV Boli", Font.PLAIN, 25));
//        return text;
//    }
    private JLabel labelNick() {
        JLabel label = new JLabel("Nick");
        label.setFont(new Font("MV Boli", Font.PLAIN, 25));
        return label;
    }

    //    private JLabel labelPort(){
//        JLabel label = new JLabel("Port");
//        label.setFont(new Font("MV Boli", Font.PLAIN, 25));
//        return label;
//    }
    private JButton loginButton() {
        button = new JButton("Login");
        button.setFocusable(false);
        button.addActionListener(this);
        button.setFont(new Font("MV Boli", Font.PLAIN, 25));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button){
            this.setVisible(false);
            String name = text.getText();
            String title = this.getTitle();
            System.out.println(text);
            //new TextMenu(title, name).setVisible(true);
//            User client = new User(name);
            menu = new TextMenu( name);
            menu.setVisible(true);
        }
    }
}