package xyz.minerproxyer.pipe;

import java.net.Socket;

public class TranslatePipe extends Thread {
    private final Socket target;
    private final Socket source;

    public TranslatePipe(Socket source, Socket target){
        this.source = source;
        this.target = target;
    }

    @Override
    public void run() {
        try{
            while(true){
                byte[] buf = new byte[1024];
                int len;
                len=source.getInputStream().read(buf);
                if(len==-1)
                    break;
                String s = new String(buf, 0, len);
                target.getOutputStream().write(buf,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
