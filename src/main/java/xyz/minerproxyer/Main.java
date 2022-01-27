package xyz.minerproxyer;

import xyz.minerproxyer.pipe.TranslatePipe;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1086)) {
            while(true){
                try{
                    Socket client = serverSocket.accept();
                    System.out.println("new connect");
                    Socket target = new Socket("45.94.43.111", 778);
                    new TranslatePipe(client, target).start();
                    new TranslatePipe(target, client).start();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
