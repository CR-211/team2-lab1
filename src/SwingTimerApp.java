import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class SwingTimerApp extends JFrame {

    private Timer timer;

    public SwingTimerApp() {
        setTitle("Swing Timer App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start Timer");
        JButton stopButton = new JButton("Stop Timer");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(stopButton);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startTimer() {
        if (timer == null) {
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    // Acțiunile care trebuie executate la fiecare interval de timp
                    System.out.println("Timer tick!");
                }
            };

            // Pornirea timer-ului cu un interval de 1000 milisecunde (1 secundă)
            timer.scheduleAtFixedRate(timerTask, 0, 1000);
        }
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
            System.out.println("Timer stopped.");
        }
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