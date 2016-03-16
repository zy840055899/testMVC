package chat;

/**
 * Created by zhengying on 16/3/16.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        new ServerRead(dis).start();
        new ServerWriter(dos).start();
    }
}

class ServerRead extends Thread {
    private DataInputStream dis = null;

    public ServerRead(DataInputStream dis) {
        this.dis = dis;
    }

    public void run() {
        while (true) {
            try {
                String str = dis.readUTF();
                System.out.println("对方:" + str);
                if (str.equalsIgnoreCase("再见"))
                    break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ServerWriter extends Thread {
    private DataOutputStream dos = null;

    public ServerWriter(DataOutputStream dos) {
        this.dos = dos;
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String str = br.readLine();
                dos.writeUTF(str);
                if (str.equalsIgnoreCase("再见"))
                    break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}