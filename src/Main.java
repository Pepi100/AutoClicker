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


    private static boolean state = false;
    private ClickBot c;

    public static void main(String[] args) {
        new Main();
    }


    public Main(){
//        mainFrame.setUndecorated(true);
//        mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

//        TODO TitleBar


        setTitle("AutoClicker");
        setSize(400,400);//400 width and 400 height
        setContentPane(mainPanel);
        mainPanel.setBackground(bgColor);



        startButton.setVisible(true);
        startButton.addActionListener(start);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
//                startButton.setEnabled(false);
                c= new ClickBot(d, ClickType.LEFT);

                c.start();


//                startButton.setEnabled(true);
                startButton.setText("STOP");
            }

        }
    };


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

