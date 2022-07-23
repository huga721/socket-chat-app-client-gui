package pl.hubertszaba.chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class User extends Thread{

    private PrintWriter out;
    private BufferedReader in;
    private Socket client;
    private String username = "Hubert";
    private Scanner scan;
    private boolean isConnected;

    public User() {
        super.start();
    }


    public void tryConnect(){
        try {
            this.client = new Socket("127.0.0.1", 7777);
            isConnected = true;
        } catch (IOException e) {
            System.out.println("Error in tryConnect method.");
        }
    }

    public String getUsername() {
        return username;
    }

    public void listenForMessage(){
        try {
            String message = null;
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            message = in.readLine();
            System.out.println(message);
        } catch (IOException e) {
            System.out.println("Error in listenForMessage method.");
        }
    }
    public void sendMessage(String message){
        try {
            out = new PrintWriter(client.getOutputStream(),true);
            out.println(message);
        } catch (IOException e) {
            System.out.println("Error in sendMessage method.");
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
    public void sendUsername(){
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            out.println(username);
        } catch (IOException e){
            System.out.println("Error in sendUsername method.");
        }
    }
}


