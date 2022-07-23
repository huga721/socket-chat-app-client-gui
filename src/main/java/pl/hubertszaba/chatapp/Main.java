package pl.hubertszaba.chatapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Scanner scan = new Scanner(System.in);
        user.tryConnect();

        if (user.isConnected()){
            user.sendUsername();
            System.out.println("Polaczyles sie z serwerem");
            System.out.println("Wyslij wiadomosc");
            while (user.isConnected()) {
                String msg = scan.nextLine();
                user.sendMessage(msg);
                user.listenForMessage();
            }
        }
    }
}
