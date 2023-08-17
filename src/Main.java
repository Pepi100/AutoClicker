import clickbot.ClickBot;
import clickbot.ClickType;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class Main extends JFrame{

    //    COLORS
    final static Color bgColor = new Color(43, 45, 48);
    final static Color dangerRed =  new Color(181, 71, 71);
    final static Color textColor = new Color(222, 224, 208);


    private JButton startButton;
    private JPanel mainPanel;
    private JFormattedTextField hours;
    private JFormattedTextField minutes;
    private JFormattedTextField seconds;
    private JFormattedTextField miliseconds;
    private JButton exitButton;
    private JButton minimizeButton;


    private static boolean state = false;
    private ClickBot c;

    public static void main(String[] args) {
        new Main();
    }


    public Main(){
//        mainFrame.setUndecorated(true);
//        mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

//        TODO TitleBar

        setAlwaysOnTop(true); //window doesn`t minimize when clicking outside of it
        setUndecorated(true); //removes default window decorations

        setTitle("AutoClicker");
        setSize(400,400);//400 width and 400 height
        setContentPane(mainPanel);
        mainPanel.setBackground(bgColor);



        startButton.setVisible(true);
        startButton.addActionListener(start);
        exitButton.addActionListener(exitAction);
        minimizeButton.addActionListener(minimizeAction);


//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); not needed anymore
        setLocationRelativeTo(null);
        setVisible(true);//making the frame visible

    }


     final ActionListener start = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {


            if (state){
                state=false;
                try{
                    c.interrupt();
                }catch (Exception interruptedException){

                }
                startButton.setText("START");

            }else{
                state = true;
                Duration d=Duration.ZERO;
                d=d.plusHours(Integer.parseInt(hours.getText()));
                d=d.plusMinutes(Integer.parseInt(minutes.getText()));
                d=d.plusSeconds(Integer.parseInt(seconds.getText()));
                d=d.plusMillis(Integer.parseInt(miliseconds.getText()));

                System.out.println(d);
                startButton.setEnabled(false);
                c= new ClickBot(d, ClickType.LEFT);

                c.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                startButton.setEnabled(true);
                startButton.setText("STOP");
            }

        }
    };

    private final Action exitAction = new AbstractAction("Exit")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    };
    private final Action minimizeAction = new AbstractAction("Minimize")
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            setState(JFrame.ICONIFIED);
        }
    };

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

