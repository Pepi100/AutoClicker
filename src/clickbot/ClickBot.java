package clickbot;

import java.awt.*;
import java.time.Duration;

public class ClickBot {

    //TODO Time, ClickType, ClickLocation

    private Duration interval;
    private ClickType clickType;
    private Location clickLocation;


    public ClickBot(){

    }

    public void run(){
        try {
            Robot r = new Robot();

            while(true){
//                wait(100);
                System.out.println("Click");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop(){

    }
}
