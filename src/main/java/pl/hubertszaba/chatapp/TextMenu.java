package pl.hubertszaba.chatapp;

import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TextMenu extends JFrame implements ActionListener{

    String name;
    private JButton sendMessage;
    private JButton uploadImage;
    private JTextField textField;
    private JTextArea textArea;
    private User user;

    public TextMenu(String name){
        this.name = name;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setContentPane(mainPanel());
        this.setVisible(true);
        this.pack();
    }

    private JPanel mainPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.add(ioPanel(), BorderLayout.CENTER);
        panel.add(buttonPanel(), BorderLayout.SOUTH);
        return panel;
    }
    // panel that contains text
    private JPanel ioPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10,10,10,10));
        panel.add(textOutput(),BorderLayout.NORTH);
        panel.add(textInput(), BorderLayout.SOUTH);
        return panel;
    }
    private JTextField textInput(){
        textField = new JTextField(20);
        textField.setFont(new Font("Monospaced", Font.BOLD, 25));
        return textField;
    }
    private JTextArea textOutput() {
        textArea = new JTextArea(10,30);
        textArea.setToolTipText("Chat history");
        textArea.setForeground(new Color(20,205,50));
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.BOLD, 25));
        return textArea;
    }
    private JPanel buttonPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sendMessage = new JButton("Send message");
        uploadImage = new JButton("Upload image");
        sendMessage.setFocusable(false);
        uploadImage.setFocusable(false);
        sendMessage.addActionListener(this);
        uploadImage.addActionListener(this);
        panel.add(uploadImage);
        panel.add(sendMessage);
        return panel;
    }
    public void updateMessage(String k){
        textArea.append(k + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendMessage) {

        }
    }
}
