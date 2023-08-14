import java.awt.*;
import javax.swing.*;


public class Main {

    static Color bgColor = new Color(43, 45, 48);

    static JFrame mainFrame=new JFrame();//creating instance of JFrame

    public static void main(String[] args) {
        mainFrameInit();

        Point p = MouseInfo.getPointerInfo().getLocation();
        try {
            Robot r = new Robot();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


//        JButton b=new JButton("click");//creating instance of JButton
//        b.setBounds(130,100,100, 40);//x axis, y axis, width, height
//
//        f.add(b);//adding button in JFrame


    }


    private static void mainFrameInit(){
//        mainFrame.setUndecorated(true);
//        mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
//        TODO TitleBar

        mainFrame.setTitle("AutoClicker");
        mainFrame.setSize(400,400);//400 width and 400 height

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(bgColor);
        
        JButton startButton = new JButton("START");
        mainPanel.add(startButton);


        mainFrame.add(mainPanel);





        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);//making the frame visible
    }
}
