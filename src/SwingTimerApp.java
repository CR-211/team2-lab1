import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


class Victor{
    private Timer timer;
    JLabel statusLabel=new JLabel("Timer not started");

     void startTimer(JPanel panel) {
        if (timer == null) {
            timer = new Timer();

            panel.add(statusLabel);
            TimerTask timerTask = new TimerTask() {
                int i=0;

                @Override
                public void run() {

                    // Acțiunile care trebuie executate la fiecare interval de timp
                    /*System.out.println(i++);*/
                    statusLabel.setText(String.valueOf(i++));
                }
            };
            // Pornirea timer-ului cu un interval de 1000 milisecunde (1 secundă)
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }
    }

     void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println("Timer stopped.");
        }
    }
}

public class SwingTimerApp extends JFrame {

    public Victor victor= new Victor();


    private Timer timer;
    JPanel panel = new JPanel();

    public SwingTimerApp() {
        setTitle("Swing Timer App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start Timer");
        JButton stopButton = new JButton("Stop Timer");


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                victor.startTimer(panel);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                victor.stopTimer();
            }
        });


        panel.add(startButton);
        panel.add(stopButton);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingTimerApp();
            }
        });
    }
}