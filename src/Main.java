import clickbot.ClickBot;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

//    COLORS
    final static Color bgColor = new Color(43, 45, 48);
    final static Color dangerRed =  new Color(181, 71, 71);

    static JFrame mainFrame;
    static JButton startButton;
    static  JTextField hours, minutes, seconds, miliseconds ;



    private static boolean state = false;
    static ClickBot c;
    public static void main(String[] args) {
        mainFrameInit();


    }


    public static void mainFrameInit(){
//        mainFrame.setUndecorated(true);
//        mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

//        TODO TitleBar


        mainFrame=new JFrame();//creating instance of JFrame
        mainFrame.setTitle("AutoClicker");
        mainFrame.setSize(400,400);//400 width and 400 height

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(bgColor);

        startButton = new JButton("START");
        startButton.addActionListener(start);
        mainPanel.add(startButton);

        Box timeBox = new Box(0);
        hours = new JTextField("Hours");
        minutes = new JTextField("Minutes");
        seconds = new JTextField("Seconds");
        miliseconds = new JTextField("Miliseconds");

        timeBox.add(hours);
        timeBox.add(minutes);
        timeBox.add(seconds);
        timeBox.add(miliseconds);

        mainPanel.add(timeBox);

        mainFrame.add(mainPanel);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);//making the frame visible
    }


    static final ActionListener start = new ActionListener()
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
                c= new ClickBot();
                c.start();
                startButton.setText("STOP");
            }

        }
    };


}
