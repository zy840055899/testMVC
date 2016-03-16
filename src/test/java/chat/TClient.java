package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by zhengying on 16/3/16.
 */
public class TClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 8888);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        new ClientRead(dis).start();
        new ClientWriter(dos).start();
    }
}

class ClientRead extends Thread {
    private DataInputStream dis = null;

    public ClientRead(DataInputStream dis) {
        this.dis = dis;
    }

    public void run() {
        while (true) {
            try {
                String str = dis.readUTF();
                System.out.println("对方: " + str);
                if ("再见".equals(str))
                    break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientWriter extends Thread {
    private DataOutputStream dos = null;

    public ClientWriter(DataOutputStream dos) {
        this.dos = dos;
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String str = br.readLine();
                dos.writeUTF(str);
                if ("再见".equals(str))
                    break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}