package clickbot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ClickBot extends Thread {

    //    TODO Implement Location

    private Duration interval;
    private ClickType clickType;


    public ClickBot() {
        clickType = ClickType.LEFT;
        interval = Duration.of(1, ChronoUnit.SECONDS);

    }

    public ClickBot(Duration interval, ClickType clickType) {
        this.interval = interval;
        this.clickType = clickType;
//        this.clickLocation = clickLocation;
    }


    public void run(){
        try {
            Robot r = new Robot();
            int click;
            switch (clickType){
                case LEFT -> click = InputEvent.BUTTON1_DOWN_MASK;
                case RIGHT -> click = InputEvent.BUTTON3_DOWN_MASK;
                default -> click = InputEvent.BUTTON2_DOWN_MASK;
            }
            while(true){
                Thread.sleep(interval.toMillis()-1);
                r.mousePress(click);
                Thread.sleep(1);
                r.mouseRelease(click);
            }


        }catch (Exception e){
            System.out.println("Dead");
        }

    }

    @Override
    public void interrupt() {
        super.interrupt();
    }
}
