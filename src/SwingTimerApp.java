import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;


class Victor{
    private Timer timer;
    JLabel statusLabel=new JLabel();
    static int nr1=0;
     void startTimer(JPanel panel) {
        if (timer == null) {
            timer = new Timer();
            SwingTimerApp.startButton.setText("Stop");

            Font font = new Font("Arial", Font.PLAIN, 20);
            statusLabel.setFont(font);
            statusLabel.setBounds(96,60,40,40);
            panel.add(statusLabel);
            TimerTask timerTask = new TimerTask() {

                @Override
                public void run() {

                    // Acțiunile care trebuie executate la fiecare interval de timp
                    /*System.out.println(i++);*/
                    statusLabel.setText(String.valueOf(nr1++));
                }
            };
            // Pornirea timer-ului cu un interval de 1000 milisecunde (1 secundă)
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }
        else{
            timer.cancel();
            SwingTimerApp.startButton.setText("Continue");
            timer=null;
        }
    }

     void stopTimer() {
            statusLabel.setText("0");
            nr1=0;
    }
}

class Ion {
    private Timer timer;
     JLabel statusLabel = new JLabel("Timer not started");
    Font font = new Font("Arial", Font.PLAIN, 20);

    void startTimer(JPanel panel) {
        if (timer == null) {
            timer = new Timer();

            statusLabel.setFont(font);
            statusLabel.setBounds(4, 4, 40, 40);
            panel.add(statusLabel);
            TimerTask timerTask = new TimerTask() {

                int nr2 = 0;

                @Override
                public void run() {

                    // Acțiunile care trebuie executate la fiecare interval de timp
                    /*System.out.println(i++);*/
                    statusLabel.setText(String.valueOf(nr2++));
                }
            };
            // Pornirea timer-ului cu un interval de 1000 milisecunde (1 secundă)
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }
    }

    void startTimer2(JPanel panel) {
        statusLabel.setFont(font);
        statusLabel.setBounds(4, 4, 300, 100);
        panel.add(statusLabel);
        statusLabel.setText("You need 4 second for first timer");
    }
}

class Sebastian {
    private Timer timer;
    JLabel statusLabel = new JLabel();
    Font font = new Font("Arial", Font.PLAIN, 20);
    int nr3 = 0;

    void startTimer(JPanel panel) {
        if (timer == null) {
            timer = new Timer();
            statusLabel.setFont(font);
            statusLabel.setBounds(4, 4, 300, 40);
            panel.add(statusLabel);
            TimerTask timerTask = new TimerTask() {

//            int nr3 = 0;

                @Override
                public void run() {

                    // Acțiunile care trebuie executate la fiecare interval de timp
                    /*System.out.println(i++);*/
                    statusLabel.setText("Notificare");
                }
            };
//         LocalTime time= LocalTime.now().plusSeconds(2);
//         while(LocalTime.now().isBefore(time)){
//         }
            timer.schedule(timerTask, 2000);
        }
    }
}

public class SwingTimerApp extends JFrame {

    public Victor victor= new Victor();

    public Ion ion=new Ion();
    public Sebastian sebastian=new Sebastian();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    JPanel panel3=new JPanel();
    static JButton startButton = new JButton("Start");

    public SwingTimerApp() {
        setTitle("Swing Timer App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton stopButton = new JButton("Reset");
        JButton startButton1 = new JButton("Start");
        JButton startButton2=new JButton("Start");



        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                victor.startTimer(panel);

            }
        });

        startButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Victor.nr1>=5) {
                    ion.startTimer(panel2);
                }
                else{
                    ion.startTimer2(panel2);
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                victor.stopTimer();
            }
        });

        startButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sebastian.startTimer(panel3);

            }
        });

        startButton.setBounds(50,100,95,30);
        stopButton.setBounds(50,20,95,30);
        startButton1.setBounds(10,100,95,30);
        startButton2.setBounds(10,100,95,30);

        panel.setSize(200,200);
        panel.setLayout(null);
        panel.add(startButton);
        panel.add(stopButton);
        Color borderColor = Color.BLUE;  // Culoarea marginei
        int borderThickness = 2;  // Grosimea marginei
        LineBorder border = new LineBorder(borderColor, borderThickness);
        panel.setBorder(border);


        panel2.setBounds(200,0,300,200);
        panel2.setLayout(null);
        panel2.add(startButton1);
        Color borderColor2 = Color.GREEN;  // Culoarea marginei
        int borderThickness2 = 2;  // Grosimea marginei
        LineBorder border2 = new LineBorder(borderColor2, borderThickness2);
        panel2.setBorder(border2);

        panel3.setBounds(500,0,300,200);
        panel3.setLayout(null);
        panel3.add(startButton2);
        Color borderColor3 = Color.WHITE;  // Culoarea marginei
        int borderThickness3 = 2;  // Grosimea marginei
        LineBorder border3 = new LineBorder(borderColor3, borderThickness3);
        panel3.setBorder(border3);


        add(panel);
        add(panel2);
        add(panel3);
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
//        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        new SwingTimerApp();
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new SwingTimerApp();
//            }
//        });
    }
}