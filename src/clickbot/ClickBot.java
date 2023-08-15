package clickbot;

import java.awt.*;
import java.time.Duration;

public class ClickBot extends Thread {

    //TODO Time, ClickType, ClickLocation

    private Duration interval;
    private ClickType clickType;
    private Location clickLocation;
    private boolean status = true;


    public ClickBot(){

    }

    public void run(){

        try {
            Robot r = new Robot();
            int i=0;
            while(true){
                Thread.sleep(300);
                System.out.println(i++);
            }
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }
}
