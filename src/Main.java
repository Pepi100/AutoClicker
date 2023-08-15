import clickbot.ClickBot;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static Color bgColor = new Color(43, 45, 48);
    private static boolean state = false;
    static JFrame mainFrame=new JFrame();//creating instance of JFrame
    static ClickBot c;
    public static void main(String[] args) {
        mainFrameInit();


    }


    public static void mainFrameInit(){
//        mainFrame.setUndecorated(true);
//        mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//        TODO TitleBar

        mainFrame.setTitle("AutoClicker");
        mainFrame.setSize(400,400);//400 width and 400 height

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(bgColor);

        JButton startButton = new JButton("START");
        startButton.addActionListener(start);
        mainPanel.add(startButton);


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


            }else{
                state = true;
                c= new ClickBot();
                c.start();
            }

        }
    };


    private static void run(){

    }
}
